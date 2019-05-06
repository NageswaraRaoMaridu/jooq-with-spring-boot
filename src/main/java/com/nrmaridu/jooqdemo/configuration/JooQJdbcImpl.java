package com.nrmaridu.jooqdemo.configuration;

import javax.sql.DataSource;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.RecordMapperProvider;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultRecordMapperProvider;

public class JooQJdbcImpl implements Jooq {

    private final Settings defaultSettings = new Settings()
        .withRenderNameStyle(RenderNameStyle.AS_IS);

    private final RecordMapperProvider recordMapperProvider = new DefaultRecordMapperProvider();

    DataSource dataSource;

    public JooQJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public DSLContext build() {
        return withSettings(defaultSettings);
    }

    @Override
    public DSLContext withSettings(Settings settings) {
        final Configuration configuration = new DefaultConfiguration()
            .set(SQLDialect.POSTGRES_10)
            .set(dataSource)
            //.set(recordMapperProvider)
            .set(settings);
        return DSL.using(configuration);
    }

}
