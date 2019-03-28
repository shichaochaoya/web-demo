package servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("session-name","xxxxx");
        System.out.println("session 创建了" );
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session 摧毁啦");
    }

}
