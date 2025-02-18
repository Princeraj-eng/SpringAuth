package com.example.test.springAuth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.test.springAuth.repository.pSqlRepo"},
        entityManagerFactoryRef = "pSqlEntityMangerFactoryBean",
        transactionManagerRef = "pSqlTransactionManager")
public class DbConfigPSql {

    @Autowired
    private Environment environment;

    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.postgres.datasource") // This will take all the db configurations like endpoint or password e.t.c  by this prefix.
    @Primary
    public DataSource postgresDataSource(){

        return DataSourceBuilder.create().build();
    }


    @Bean(name="pSqlEntityMangerFactoryBean")
    @Primary
    LocalContainerEntityManagerFactoryBean pSqlEntityMangerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(postgresDataSource()).packages("com.example.test.springAuth.entity.pSqlEntity").build();
    }

    @Bean(name = "pSqlTransactionManager")
    @Primary
    PlatformTransactionManager pSqlTransactionManager(
            final @Qualifier("pSqlEntityMangerFactoryBean") LocalContainerEntityManagerFactoryBean pSqlEntityMangerFactoryBean) {
        return new JpaTransactionManager(pSqlEntityMangerFactoryBean.getObject());
    }






}
