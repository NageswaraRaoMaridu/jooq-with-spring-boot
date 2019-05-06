/*
 * Copyright (c) 2018, Synopsys, Inc. All rights reserved worldwide.
 */

package com.nrmaridu.jooqdemo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nrmaridu.jooqdemo.configuration.JooQJdbcImpl;
import com.nrmaridu.jooqdemo.configuration.Jooq;

/**
 * @author nrmaridu on 5/1/2019
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public Jooq configureJooq(DataSource dataSource) {
        return new JooQJdbcImpl(dataSource);
    }
}
