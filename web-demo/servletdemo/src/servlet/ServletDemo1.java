package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("namep");
        String pwd= request.getParameter("pwdp");
        System.out.println(name +"----"+pwd);


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "使用POST方法读取表单数据";
        //处理中

        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>name</b>："
                + name + "\n" +
                "  <li><b>pwd</b>："
                + pwd + "\n" +
                "</ul>\n" +
                "</body></html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String pwd= request.getParameter("pwd");
        String xx = (String) request.getSession().getAttribute("session-name");


        //System.out.println("容器 "+request.getServletContext().getAttribute("vle"));
        System.out.println("Session name "+xx);
        System.out.println(name +"----"+pwd);

    }
}
