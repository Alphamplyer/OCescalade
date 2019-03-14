package com.alphamplyer.ocescalade.spring;

import java.util.Properties;

import javax.sql.DataSource;

import com.alphamplyer.ocescalade.service.impl.CommentServiceImpl;
import com.alphamplyer.ocescalade.service.impl.TopoServiceImpl;
import com.alphamplyer.ocescalade.service.interf.CommentService;
import com.alphamplyer.ocescalade.service.interf.TopoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@ComponentScan("com.alphamplyer.ocescalade")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:db.properties")
public class ApplicationContextConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();

        // See: db.properties
        properties.put("hibernate.dialect", environment.getProperty("db.dialect"));
        properties.put("hibernate.show_sql", environment.getProperty("db.show_sql"));
        properties.put("current_session_context_class", environment.getProperty("current_session_context_class"));


        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setPackagesToScan(new String[] { "com.alphamplyer.ocescalade.model" });
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();

        return factoryBean.getObject();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

    @Bean(name="topoService")
    public TopoService getTopoService() {
        return new TopoServiceImpl();
    }

    @Bean(name = "commentService")
    public CommentService getCommentService() {
        return new CommentServiceImpl();
    }
}
