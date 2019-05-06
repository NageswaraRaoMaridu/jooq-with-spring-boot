package com.nrmaridu.jooqdemo.configuration;

import javax.validation.constraints.NotNull;

import org.jooq.DSLContext;
import org.jooq.conf.Settings;

/**
 * An interface used to obtain a preconfigured jOOQ {@link DSLContext}, suitable for communicating using any supported
 * dialect of SQL.
 *
 */
public interface Jooq {
    /**
     * Begins building a jOOQ query.
     *
     * @return A new {@link DSLContext}.  Not null.
     */
    @NotNull
    DSLContext build();

    /**
     * Begins building a jOOQ query, with custom settings used to configure the {@link DSLContext}.
     *
     * @param settings Settings used to configure the {@link DSLContext}.  Not null.
     * @return A new {@link DSLContext}.  Not null.
     */
    @NotNull
    DSLContext withSettings(@NotNull final Settings settings);
}
