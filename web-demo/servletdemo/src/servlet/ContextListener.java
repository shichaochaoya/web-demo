package servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String x = sce.getServletContext().getInitParameter("name");
        sce.getServletContext().setAttribute("vle","vvvv");
        System.out.println("容器初始化了"+x);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁了");
    }
}
