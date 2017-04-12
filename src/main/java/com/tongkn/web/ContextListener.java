package com.tongkn.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by tongkn on 2017/4/11.
 */
public class ContextListener implements ServletContextListener {
    /**
     ** Notification that the web application initialization
     ** process is starting.
     ** All ServletContextListeners are notified of context
     ** initialization before any filter or servlet in the web
     ** application is initialized.
     * 可以在该方法内实现log4j的配置，以及其他的加载
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
