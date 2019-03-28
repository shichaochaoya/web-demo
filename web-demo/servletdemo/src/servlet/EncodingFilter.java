package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {


    /**
     *过滤器练习
     * */
    private String encode = "UTF-8";
    /**摧毁方法*/
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    /**过滤器生效*/
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse respon = (HttpServletResponse) resp;

        req.setCharacterEncoding(encode);//拦截请求设置编码
        resp.setContentType("text/html;charset="+encode);//设置编码

        chain.doFilter(req, resp); //设计模式  责任链模式 chain：把过滤器穿成一串，挨个过滤


    }

    /**初始化方法*/
    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("endcoding");
        System.out.println("过滤器初始化");

    }

}
