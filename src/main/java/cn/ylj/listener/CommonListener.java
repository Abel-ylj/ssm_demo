package cn.ylj.listener;

import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author : yanglujian
 * create at:  2021/1/9  2:11 下午
 */
public class CommonListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        System.out.println("Listener监控到启动， 创建IoC容器" + ctx.getInitParameter("contextConfigLocation"));
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}