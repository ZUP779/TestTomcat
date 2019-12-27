package servlet;

import DAO.UserDAO;
import Model.UserService;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//need open mysql server
public class ListUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("List begin");
//        response.setContentType("text/html; charset=UTF-8");
        UserService us = new UserService();
        String userList = us.getUserList();

        request.setAttribute("UserList",userList);
        RequestDispatcher view = request.getRequestDispatcher("listUser.jsp");
        view.forward(request,response);
    }

    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    System.out.println("get");
    //}
}
