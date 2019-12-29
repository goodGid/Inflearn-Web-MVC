package be.goodgid;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[Goodgid] : contextInitialized");
        sce.getServletContext().setAttribute("name","goodgid");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[Goodgid] : contextDestroyed");

    }
}
