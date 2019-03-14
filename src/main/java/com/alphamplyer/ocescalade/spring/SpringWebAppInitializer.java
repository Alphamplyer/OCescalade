package com.alphamplyer.ocescalade.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationContextConfig.class);
        servletContext.addListener(new ContextLoaderListener(appContext));

        ServletRegistration.Dynamic dispacher = servletContext.addServlet("SpringDispacher", new DispatcherServlet(appContext));
        dispacher.setLoadOnStartup(1);
        dispacher.addMapping("/");
    }
}
