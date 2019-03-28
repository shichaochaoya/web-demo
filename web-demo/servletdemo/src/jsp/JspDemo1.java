package jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JspDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("namep");
        User user = new User("wang", 18);
        User user1 = new User("zhang",19);
        User user2 = new User("li",20);
        User user3 = new User("zhou",21);
        User user4 = new User("cai",22);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        request.setAttribute("users",users);
        request.setAttribute("user",user);
        request.setAttribute("name", name);
        request.getRequestDispatcher("/WEB-INF/jsp-demo.jsp").forward(request, response);//将请求转发到jsp文件 ，一个请求
        //response.sendRedirect("demo2"); //重定向 指定一个文件处理请求 ，有两次请求，两个响应


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  doPost(request, response);*/

      //GET请求不改变编码

      String name = request.getParameter("name");
      String pwd = request.getParameter("pwd");
      response.getWriter().write(name);

    }
}
