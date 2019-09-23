package servlet;

import DAO.UserDAO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("List begin");
        response.setContentType("text/html; charset=UTF-8");
        UserDAO ud = new UserDAO();
        List<User> users = ud.getUsers();
        System.out.println("List begin");
        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td>></tr>\r\n";
        System.out.println("l1");
        for (User user : users) {
            String tr = String.format(trFormat, user.getId(), user.getName());
            sb.append(tr);
        }
        System.out.println("l2");
        sb.append("</table>");
        response.getWriter().write(sb.toString());

        System.out.println("List end");
        ud.ShowAll();
    }

    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    System.out.println("get");
    //}
}
