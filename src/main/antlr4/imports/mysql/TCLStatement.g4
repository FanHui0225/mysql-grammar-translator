grammar TCLStatement;
import BaseRule;

setTransaction
    : SET optionType? TRANSACTION transactionCharacteristics
    ;

setAutoCommit
    : SET (AT_? AT_)? optionType? DOT_? AUTOCOMMIT EQ_ autoCommitValue=(NUMBER_ | ON | OFF)
    ;

beginTransaction
    : BEGIN WORK? | START TRANSACTION (transactionCharacteristic (COMMA_ transactionCharacteristic)*)?
    ;

transactionCharacteristic
    : WITH CONSISTENT SNAPSHOT | transactionAccessMode
    ;

commit
    : COMMIT WORK? optionChain? optionRelease?
    ;

rollback
    : ROLLBACK (WORK? TO SAVEPOINT? identifier | WORK? optionChain? optionRelease?)
    ;

savepoint
    : SAVEPOINT identifier
    ;

begin
    : BEGIN WORK?
    ;

lock
    : LOCK (INSTANCE FOR BACKUP | ((TABLES | TABLE) tableLock (COMMA_ tableLock)*))
    ;

unlock
    : UNLOCK (INSTANCE | TABLE | TABLES)
    ;

releaseSavepoint
    : RELEASE SAVEPOINT identifier
    ;

optionChain
    : AND NO? CHAIN
    ;

optionRelease
    : NO? RELEASE
    ;

tableLock
    : tableName (AS? alias)? lockOption
    ;

lockOption
    : READ LOCAL? | LOW_PRIORITY? WRITE
    ;

xaBegin
    : XA (START | BEGIN) xid (JOIN | RESUME)?
    ;

xaPrepare
    : XA PREPARE xid
    ;

xaCommit
    : XA COMMIT xid (ONE PHASE)?
    ;

xaRollback
    : XA ROLLBACK xid
    ;

xaEnd
    : XA END xid (SUSPEND (FOR MIGRATE)?)?
    ;

xaRecovery
    : XA RECOVER (CONVERT XID)?
    ;

xid
    : gtrid=textString (COMMA_ bqual=textString (COMMA_ formatID=NUMBER_)?)?
    ;
