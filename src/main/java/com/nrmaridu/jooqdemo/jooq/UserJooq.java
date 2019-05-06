package com.nrmaridu.jooqdemo.jooq;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.impl.DSL;

/**
 * @author nrmaridu on 5/1/2019
 */
public class UserJooq {

    public static final UserJooq instance = new UserJooq();

    private final String tableName = "_USER";

    public final Table<Record> table = DSL.table(DSL.name(tableName));

    public final Field<UUID> Id = DSL.field(DSL.name(tableName, "ID"), UUID.class);

    public final Field<String> name = DSL.field(DSL.name(tableName, "NAME"), String.class);

    public final Field<Integer> age = DSL.field(DSL.name(tableName, "AGE"), Integer.class);

    public final Field<String> occupation = DSL.field(DSL.name(tableName, "OCCUPATION"), String.class);

    private UserJooq() {

    }
}
