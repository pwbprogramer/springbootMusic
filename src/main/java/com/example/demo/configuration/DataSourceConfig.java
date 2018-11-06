package com.example.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据源配置
 * @author pwb
 *
 */
@Configuration
public class DataSourceConfig {
        
	    /**
	     * 数据源-Demo
	     * @return
	     */
	    @Bean(name = "DataSource1")
	    @Primary
	    @Qualifier("DataSource1")
	    @ConfigurationProperties(prefix = "spring.datasource.db1") // application.properteis中对应属性的前缀
	    public DataSource dataSource1() {
	        return DataSourceBuilder.create().build();
	    }
}
