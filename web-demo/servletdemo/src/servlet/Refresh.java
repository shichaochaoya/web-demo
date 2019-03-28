package servlet;


import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
    private static final long serialVersionUID = 1l;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置刷新自动加载的事件间隔为 5 秒
        resp.setIntHeader("Refresh",5);

        //设置相应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        //获取当前时间
        Calendar calender = new GregorianCalendar();
        String am_pm;
        int hour = calender.get(Calendar.HOUR);
        int minute = calender.get(Calendar.MINUTE);
        int secound = calender.get(Calendar.SECOND);
        if (calender.get(Calendar.AM_PM) == 0)
            am_pm= "AM";
        else am_pm = "PM";

        String CT = hour+":"+minute+":"+secound+" "+am_pm;

        PrintWriter out = resp.getWriter();
        String title = "使用Servlet自动刷新页面";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType+
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是："+CT+"</p>\n");
    }
}
