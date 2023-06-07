
package com.glodon.translator.parser.statement.ddl;

import com.glodon.translator.parser.segment.ddl.column.alter.*;
import com.glodon.translator.parser.segment.ddl.constraint.alter.AddConstraintDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.alter.DropConstraintDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.alter.ModifyConstraintDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.constraint.alter.ValidateConstraintDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.index.DropIndexDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.index.RenameIndexDefinitionSegment;
import com.glodon.translator.parser.segment.ddl.table.ConvertTableDefinitionSegment;
import com.glodon.translator.parser.segment.generic.table.SimpleTableSegment;
import com.glodon.translator.parser.statement.AbstractSQLStatement;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

public abstract class AlterTableStatement extends AbstractSQLStatement implements DDLStatement {

    private SimpleTableSegment table;

    private SimpleTableSegment renameTable;

    private ConvertTableDefinitionSegment convertTableDefinition;

    private final Collection<AddColumnDefinitionSegment> addColumnDefinitions = new LinkedList<>();

    private final Collection<ModifyColumnDefinitionSegment> modifyColumnDefinitions = new LinkedList<>();

    private final Collection<ChangeColumnDefinitionSegment> changeColumnDefinitions = new LinkedList<>();

    private final Collection<DropColumnDefinitionSegment> dropColumnDefinitions = new LinkedList<>();

    private final Collection<AddConstraintDefinitionSegment> addConstraintDefinitions = new LinkedList<>();

    private final Collection<ValidateConstraintDefinitionSegment> validateConstraintDefinitions = new LinkedList<>();

    private final Collection<ModifyConstraintDefinitionSegment> modifyConstraintDefinitions = new LinkedList<>();

    private final Collection<DropConstraintDefinitionSegment> dropConstraintDefinitions = new LinkedList<>();

    private final Collection<DropIndexDefinitionSegment> dropIndexDefinitions = new LinkedList<>();

    private final Collection<RenameColumnSegment> renameColumnDefinitions = new LinkedList<>();

    private final Collection<RenameIndexDefinitionSegment> renameIndexDefinitions = new LinkedList<>();

    public Optional<SimpleTableSegment> getRenameTable() {
        return Optional.ofNullable(renameTable);
    }

    public Optional<ConvertTableDefinitionSegment> getConvertTableDefinition() {
        return Optional.ofNullable(convertTableDefinition);
    }

    public SimpleTableSegment getTable() {
        return table;
    }

    public void setTable(SimpleTableSegment table) {
        this.table = table;
    }

    public void setRenameTable(SimpleTableSegment renameTable) {
        this.renameTable = renameTable;
    }

    public void setConvertTableDefinition(ConvertTableDefinitionSegment convertTableDefinition) {
        this.convertTableDefinition = convertTableDefinition;
    }

    public Collection<AddColumnDefinitionSegment> getAddColumnDefinitions() {
        return addColumnDefinitions;
    }

    public Collection<ModifyColumnDefinitionSegment> getModifyColumnDefinitions() {
        return modifyColumnDefinitions;
    }

    public Collection<ChangeColumnDefinitionSegment> getChangeColumnDefinitions() {
        return changeColumnDefinitions;
    }

    public Collection<DropColumnDefinitionSegment> getDropColumnDefinitions() {
        return dropColumnDefinitions;
    }

    public Collection<AddConstraintDefinitionSegment> getAddConstraintDefinitions() {
        return addConstraintDefinitions;
    }

    public Collection<ValidateConstraintDefinitionSegment> getValidateConstraintDefinitions() {
        return validateConstraintDefinitions;
    }

    public Collection<ModifyConstraintDefinitionSegment> getModifyConstraintDefinitions() {
        return modifyConstraintDefinitions;
    }

    public Collection<DropConstraintDefinitionSegment> getDropConstraintDefinitions() {
        return dropConstraintDefinitions;
    }

    public Collection<DropIndexDefinitionSegment> getDropIndexDefinitions() {
        return dropIndexDefinitions;
    }

    public Collection<RenameColumnSegment> getRenameColumnDefinitions() {
        return renameColumnDefinitions;
    }

    public Collection<RenameIndexDefinitionSegment> getRenameIndexDefinitions() {
        return renameIndexDefinitions;
    }
}
