package kpavlov.jsonweb;

import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static org.slf4j.LoggerFactory.getLogger;

@EnableAutoConfiguration
@EnableTransactionManagement
@EnableGlobalMethodSecurity
@ComponentScan(basePackageClasses = AppConfig.class)
public class AppConfig {

    private static final Logger LOGGER = getLogger(AppConfig.class);

    @Bean
    DataSource dataSource() {
        return new SimpleDriverDataSource() {
            {
                setDriverClass(org.h2.Driver.class);
                setUsername("sa");
                setUrl("jdbc:h2:mem");
                setPassword("");
            }
        };
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.info("Creating tables");
        jdbcTemplate.execute("drop table ITEMS if exists");
        jdbcTemplate.execute("create table ITEMS(ID serial, NAME varchar(32) NOT NULL, DESCRIPTION varchar(128))");
        return jdbcTemplate;
    }
}
