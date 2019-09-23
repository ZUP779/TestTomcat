package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends javax.servlet.http.HttpServlet {
    public void init(ServletConfig config) {
        System.out.println("init");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String name = request.getParameter("name");
        String pwd = request.getParameter("password");

        System.out.println(name);
        System.out.println(pwd);

        String html = null;

        html = "<body> Username is " + name + "</body>";
        PrintWriter pw = response.getWriter();
        pw.println(html);

        try{
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if("success".equals(name)){
            response.sendRedirect("success.html");
        }
        else if("fail".equals(name)){
            request.getRequestDispatcher("fail.html").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }


}
