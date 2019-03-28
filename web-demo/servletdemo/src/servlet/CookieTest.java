package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;


@WebServlet(name = "/servlet.CookieTest")
public class CookieTest extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public CookieTest() {
            super();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            /**
             * 为名字和姓氏创建Cookie
             * */
            Cookie name = new Cookie("name",
                    URLEncoder.encode(request.getParameter("name"), "UTF-8"));//中文转码

            Cookie url = new Cookie("url",
                    request.getParameter("url"));


            name.setMaxAge(60 * 60 * 24);
            url.setMaxAge(60 * 60 * 24);//为Cookie设置过期日期为24小时后


            response.addCookie(name);
            response.addCookie(url);//在响应头中添加两个Cookie


            response.setContentType("text/html;charset=UTF-8");//设置响应内容类型


            PrintWriter out = response.getWriter();
            String title = "设置Cookie实例";
            String docType = "<!DOCTYPE html>\n";

            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<ul>\n" +
                    "  <li><b>站点名</b>："
                    + request.getParameter("name") + "\n<li>" +
                    "  <li><b>站点 URL:</b>："
                    + request.getParameter("url") + "\n<li>" +
                    "</ul>\n" +
                    "</body></html>");
        }
    }


