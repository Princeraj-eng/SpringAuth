package com.example.test.springAuth.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.test.springAuth.repository.mySqlRepo",
                       entityManagerFactoryRef = "mySqlEntityManagerFactory",
                       transactionManagerRef = "mySqlTransactionManager")
public class DbConfigMySql {


    @Bean(name = "mySqlDataSource")
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSource mySqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="mySqlEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(mySqlDataSource()).packages("com.example.test.springAuth.entity.mySqlEntity").build();
    }

    @Bean(name = "mySqlTransactionManager")
    PlatformTransactionManager mySqlTransactionManager(
            final @Qualifier("mySqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory
    ) {
        return new JpaTransactionManager(Objects.requireNonNull(mySqlEntityManagerFactory.getObject()));

//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(mySqlEntityManagerFactory.);
//        return manager;
    }
}
