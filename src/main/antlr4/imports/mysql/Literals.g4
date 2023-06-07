lexer grammar Literals;

import Alphabet, Symbol;

FILESIZE_LITERAL
    : INT_NUM_ ('K'|'M'|'G'|'T')
    ;

SINGLE_QUOTED_TEXT
    : SQ_ ('\\'. | '\'\'' | ~('\'' | '\\'))* SQ_
    ;

DOUBLE_QUOTED_TEXT
    : DQ_ ( '\\'. | '""' | ~('"'| '\\') )* DQ_
    ;

NCHAR_TEXT
    : N SINGLE_QUOTED_TEXT
    ;

UNDERSCORE_CHARSET
    : UL_ [a-z0-9A-Z]+
    ;

NUMBER_
    : INT_NUM_
    | FLOAT_NUM_
    | DECIMAL_NUM_
    ;

INT_NUM_
    : DIGIT+
    ;

FLOAT_NUM_
    : INT_NUM_? DOT_? INT_NUM_ E (PLUS_ | MINUS_)? INT_NUM_
    ;

DECIMAL_NUM_
    : INT_NUM_? DOT_ INT_NUM_
    ;

HEX_DIGIT_
    : '0x' HEX_+ | X SQ_ HEX_+ SQ_ | X SQ_ + SQ_
    ;

BIT_NUM_
    : '0b' ('0' | '1')+ | B SQ_ ('0' | '1')+ SQ_
    ;

IDENTIFIER_
    : [A-Za-z_$0-9\u0080-\uFFFF]*?[A-Za-z_$\u0080-\uFFFF]+?[A-Za-z_$0-9\u0080-\uFFFF]*
    | BQ_ ~'`'+ BQ_
    ;

IP_ADDRESS
    : INT_NUM_ DOT_ INT_NUM_ DOT_ INT_NUM_ DOT_ INT_NUM_
    ;

NOT_SUPPORT_
    : 'not support'
    ;

fragment DIGIT
    : [0-9]
    ;

fragment HEX_
    : [0-9a-fA-F]
    ;