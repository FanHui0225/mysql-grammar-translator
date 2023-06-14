package com.glodon.translator.parser;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.glodon.translator.parser.dialect.mysql.MySQLParser;
import com.glodon.translator.parser.dialect.mysql.MySQLParserErrorListener;
import com.glodon.translator.parser.dialect.mysql.lexer.MySQLLexer;
import com.glodon.translator.parser.dialect.mysql.visitor.*;
import com.glodon.translator.parser.segment.generic.CommentSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;
import com.glodon.translator.parser.statement.SQLStatement;
import com.glodon.translator.parser.statement.SQLStatementType;
import com.glodon.translator.parser.visitor.SQLVisitorRule;
import com.glodon.translator.parser.visitor.statement.SQLStatementVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;

public abstract class SQLParserExecutor {

    private final boolean isParseComment;

    private final LoadingCache<String, ParseASTNode> parseTreeCache;

    public SQLParserExecutor() {
        this(false, new ParseTreeCacheBuilder.CacheOption(128, 1024L));
    }

    public SQLParserExecutor(boolean isParseComment, ParseTreeCacheBuilder.CacheOption cacheOption) {
        this.isParseComment = isParseComment;
        parseTreeCache = ParseTreeCacheBuilder.build(cacheOption, this);
    }

    protected final SQLStatement parse(final String sql, boolean useCache) {
        ParseASTNode parseASTNode = useCache ? parseTreeCache.get(sql) : parseASTNode(sql);
        if (parseASTNode.getRootNode() instanceof ErrorNode) {
            throw new SQLParsingException(sql);
        }
        SQLVisitorRule visitorRule = SQLVisitorRule.valueOf(parseASTNode.getRootNode().getClass());
        SQLStatementVisitor visitor = createParseTreeVisitor(visitorRule.getType());
        ASTNode result = parseASTNode.getRootNode().accept(visitor);
        if (isParseComment) {
            appendSQLComments(parseASTNode, result);
        }
        return (SQLStatement) result;
    }


    private final <T> void appendSQLComments(final ParseASTNode parseASTNode, final T visitResult) {
        if (visitResult instanceof AbstractSQLStatement) {
            for (Token each : parseASTNode.getHiddenTokens()) {
                ((AbstractSQLStatement) visitResult).getCommentSegments().add(new CommentSegment(each.getText(), each.getStartIndex(), each.getStopIndex()));
            }
        }
    }

    protected abstract ParseASTNode parseASTNode(final String sql);

    protected abstract SQLStatementVisitor createParseTreeVisitor(final SQLStatementType type);
}
