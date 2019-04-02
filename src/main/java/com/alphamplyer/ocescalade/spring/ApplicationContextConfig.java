package com.alphamplyer.ocescalade.spring;

import javax.sql.DataSource;

import com.alphamplyer.ocescalade.service.impl.*;
import com.alphamplyer.ocescalade.service.interf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();

        DataSource dataSource = this.getDataSource();
        txManager.setDataSource(dataSource);

        return txManager;
    }

    @Bean(name="topoService")
    public TopoService getTopoService() {
        return new TopoServiceImpl();
    }

    @Bean(name = "commentService")
    public CommentService getCommentService() {
        return new CommentServiceImpl();
    }

    @Bean(name = "userService")
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean(name = "siteService")
    public SiteService getSiteService() {
        return new SiteServiceImpl();
    }

    @Bean(name = "sectorService")
    public SectorService getSectorService() {
        return new SectorServiceImpl();
    }

    @Bean(name = "wayService")
    public WayService getWayService() {
        return new WayServiceImpl();
    }

    @Bean(name = "imageService")
    public ImageService getImageService() {
        return new ImageServiceImpl();
    }
}
