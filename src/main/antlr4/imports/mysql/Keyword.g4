lexer grammar Keyword;
import Alphabet;
// Custom keyword Non-mysql key system

WS
    : [ \t\r\n] + ->skip
    ;

MAX
    : M A X
    ;

MIN
    : M I N
    ;

SUM
    : S U M
    ;

COUNT
    : C O U N T
    ;

GROUP_CONCAT
    : G R O U P UL_ C O N C A T
    ;

CAST
    : C A S T
    ;

POSITION
    : P O S I T I O N
    ;

SUBSTRING
    : S U B S T R I N G
    ;

SUBSTR
    : S U B S T R
    ;

EXTRACT
    : E X T R A C T
    ;

TRIM
    : T R I M
    ;

LAST_DAY
    : L A S T UL_ D A Y
    ;

TRADITIONAL
    : T R A D I T I O N A L
    ;

TREE
    : T R E E
    ;

MYSQL_MAIN
    : M Y S Q L UL_ M A I N
    ;

MYSQL_ADMIN
    : M Y S Q L UL_ A D M I N
    ;

INSTANT
    : I N S T A N T
    ;

INPLACE
    : I N P L A C E
    ;

COPY
    : C O P Y
    ;

UL_BINARY
    : UL_ B I N A R Y
    ;

AUTOCOMMIT
    : A U T O C O M M I T
    ;

INNODB
    : 'INNODB'
    ;

REDO_LOG
    : 'REDO_LOG'
    ;
    
DELIMITER
    : D E L I M I T E R
    ;
