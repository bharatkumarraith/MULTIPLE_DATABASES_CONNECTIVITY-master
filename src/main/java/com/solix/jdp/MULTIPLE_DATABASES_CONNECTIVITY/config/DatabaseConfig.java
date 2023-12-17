package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactorySecondary",
        basePackages = {"com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryRepository"},
        transactionManagerRef = "secondaryTransactionManager"
)
public class DatabaseConfig {


    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.db2.datasource") // Corrected prefix
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "entityManagerFactorySecondary")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("secondaryDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryDomain") // Corrected package name
                .persistenceUnit("db2")
                .properties(Map.of("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"))
                .build();
    }


    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager(
            @Qualifier("entityManagerFactorySecondary") EntityManagerFactory secondaryEntityManagerFactory) {
        return new JpaTransactionManager(secondaryEntityManagerFactory);
    }
}
