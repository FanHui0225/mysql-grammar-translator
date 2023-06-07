
package com.glodon.translator.parser.enums;

import java.util.Arrays;

public enum Paren {

    PARENTHESES('(', ')'), BRACKET('[', ']'), BRACES('{', '}');

    private final char leftParen;

    private final char rightParen;

    Paren(char leftParen, char rightParen) {
        this.leftParen = leftParen;
        this.rightParen = rightParen;
    }

    public static boolean isLeftParen(final char token) {
        return Arrays.stream(values()).anyMatch(each -> each.leftParen == token);
    }

    public static boolean match(final char leftToken, final char rightToken) {
        return Arrays.stream(values()).anyMatch(each -> each.leftParen == leftToken && each.rightParen == rightToken);
    }

    public char getLeftParen() {
        return leftParen;
    }

    public char getRightParen() {
        return rightParen;
    }
}
