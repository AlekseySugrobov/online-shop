package ru.winzdoor.onlineshoppingbackend.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"ru.winzdoor.onlineshoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineShop";
    private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private final static String DATABASE_USERNAME = "root";
    private final static String DATABASE_PASSWORD = "rkg7mnNhfyr";
    //dataSource bean
    @Bean
    DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }
    //sessionFactory bean
    @Bean
    SessionFactory getSessionFactory(DataSource dataSource){
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.addProperties(getHibernateProperties());
        sessionFactoryBuilder.scanPackages("ru.winzdoor.onlineshoppingbackend.dto");
        return sessionFactoryBuilder.buildSessionFactory();
    }
    //hibernate properties
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "sql");
        return properties;
    }
    //transactionManager bean
    @Bean
    HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
}
