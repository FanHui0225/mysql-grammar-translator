
package com.glodon.translator.parser.util;

import com.glodon.translator.parser.ASTNode;
import com.glodon.translator.parser.enums.Paren;
import com.glodon.translator.parser.segment.dml.expr.ExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.complex.CommonExpressionSegment;
import com.glodon.translator.parser.segment.dml.expr.simple.LiteralExpressionSegment;
import com.glodon.translator.parser.segment.generic.table.JoinTableSegment;
import com.glodon.translator.parser.segment.generic.table.SubqueryTableSegment;
import com.glodon.translator.parser.segment.generic.table.TableSegment;
import com.glodon.translator.parser.value.literal.*;
import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class SQLUtils {

    private static final String SQL_END = ";";

    private static final String COMMENT_PREFIX = "/*";

    private static final String COMMENT_SUFFIX = "*/";

    private static final String EXCLUDED_CHARACTERS = "[]`'\"";

    private static final Pattern SINGLE_CHARACTER_PATTERN = Pattern.compile("([^\\\\])_|^_");

    private static final Pattern SINGLE_CHARACTER_ESCAPE_PATTERN = Pattern.compile("\\\\_");

    private static final Pattern ANY_CHARACTER_PATTERN = Pattern.compile("([^\\\\])%|^%");

    private static final Pattern ANY_CHARACTER_ESCAPE_PATTERN = Pattern.compile("\\\\%");

    public static Number getExactlyNumber(final String value, final int radix) {
        try {
            return getBigInteger(value, radix);
        } catch (final NumberFormatException ex) {
            return new BigDecimal(value);
        }
    }

    private static Number getBigInteger(final String value, final int radix) {
        BigInteger result = new BigInteger(value, radix);
        if (result.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) >= 0 && result.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) <= 0) {
            return result.intValue();
        }
        if (result.compareTo(new BigInteger(String.valueOf(Long.MIN_VALUE))) >= 0 && result.compareTo(new BigInteger(String.valueOf(Long.MAX_VALUE))) <= 0) {
            return result.longValue();
        }
        return result;
    }

    public static String getExactlyValue(final String value) {
        return null == value ? null : CharMatcher.anyOf(EXCLUDED_CHARACTERS).removeFrom(value);
    }

    public static String getExactlyValue(final String value, final String reservedCharacters) {
        if (null == value) {
            return null;
        }
        String toBeExcludedCharacters = CharMatcher.anyOf(reservedCharacters).removeFrom(EXCLUDED_CHARACTERS);
        return CharMatcher.anyOf(toBeExcludedCharacters).removeFrom(value);
    }

    public static String getExactlyExpression(final String value) {
        return Strings.isNullOrEmpty(value) ? value : CharMatcher.anyOf(" ").removeFrom(value);
    }

    public static String getExpressionWithoutOutsideParentheses(final String value) {
        int parenthesesOffset = getParenthesesOffset(value);
        return 0 == parenthesesOffset ? value : value.substring(parenthesesOffset, value.length() - parenthesesOffset);
    }

    private static int getParenthesesOffset(final String value) {
        int result = 0;
        if (Strings.isNullOrEmpty(value)) {
            return result;
        }
        while (Paren.PARENTHESES.getLeftParen() == value.charAt(result)) {
            result++;
        }
        return result;
    }

    public static List<SubqueryTableSegment> getSubqueryTableSegmentFromTableSegment(final TableSegment tableSegment) {
        List<SubqueryTableSegment> result = new LinkedList<>();
        if (tableSegment instanceof SubqueryTableSegment) {
            result.add((SubqueryTableSegment) tableSegment);
        }
        if (tableSegment instanceof JoinTableSegment) {
            result.addAll(getSubqueryTableSegmentFromJoinTableSegment((JoinTableSegment) tableSegment));
        }
        return result;
    }

    private static List<SubqueryTableSegment> getSubqueryTableSegmentFromJoinTableSegment(final JoinTableSegment joinTableSegment) {
        List<SubqueryTableSegment> result = new LinkedList<>();
        if (joinTableSegment.getLeft() instanceof SubqueryTableSegment) {
            result.add((SubqueryTableSegment) joinTableSegment.getLeft());
        } else if (joinTableSegment.getLeft() instanceof JoinTableSegment) {
            result.addAll(getSubqueryTableSegmentFromJoinTableSegment((JoinTableSegment) joinTableSegment.getLeft()));
        }
        if (joinTableSegment.getRight() instanceof SubqueryTableSegment) {
            result.add((SubqueryTableSegment) joinTableSegment.getRight());
        } else if (joinTableSegment.getRight() instanceof JoinTableSegment) {
            result.addAll(getSubqueryTableSegmentFromJoinTableSegment((JoinTableSegment) joinTableSegment.getRight()));
        }
        return result;
    }

    public static ExpressionSegment createLiteralExpression(final ASTNode astNode, final int startIndex, final int stopIndex, final String text) {
        if (astNode instanceof StringLiteralValue) {
            return new LiteralExpressionSegment(startIndex, stopIndex, ((StringLiteralValue) astNode).getValue());
        }
        if (astNode instanceof NumberLiteralValue) {
            return new LiteralExpressionSegment(startIndex, stopIndex, ((NumberLiteralValue) astNode).getValue());
        }
        if (astNode instanceof BooleanLiteralValue) {
            return new LiteralExpressionSegment(startIndex, stopIndex, ((BooleanLiteralValue) astNode).getValue());
        }
        if (astNode instanceof NullLiteralValue) {
            return new LiteralExpressionSegment(startIndex, stopIndex, null);
        }
        if (astNode instanceof OtherLiteralValue) {
            return new CommonExpressionSegment(startIndex, stopIndex, ((OtherLiteralValue) astNode).getValue());
        }
        return new CommonExpressionSegment(startIndex, stopIndex, text);
    }

    public static String trimSemicolon(final String sql) {
        return sql.endsWith(SQL_END) ? sql.substring(0, sql.length() - 1) : sql;
    }

    public static String trimComment(final String sql) {
        String result = sql;
        if (sql.startsWith(COMMENT_PREFIX)) {
            result = result.substring(sql.indexOf(COMMENT_SUFFIX) + 2);
        }
        if (sql.endsWith(SQL_END)) {
            result = result.substring(0, result.length() - 1);
        }
        return result.trim();
    }

    public static String convertLikePatternToRegex(final String pattern) {
        String result = pattern;
        if (pattern.contains("_")) {
            result = SINGLE_CHARACTER_PATTERN.matcher(result).replaceAll("$1.");
            result = SINGLE_CHARACTER_ESCAPE_PATTERN.matcher(result).replaceAll("_");
        }
        if (pattern.contains("%")) {
            result = ANY_CHARACTER_PATTERN.matcher(result).replaceAll("$1.*");
            result = ANY_CHARACTER_ESCAPE_PATTERN.matcher(result).replaceAll("%");
        }
        return result;
    }
}
