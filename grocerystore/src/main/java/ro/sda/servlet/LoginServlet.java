package ro.sda.servlet;

import ro.sda.logic.UserUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginservlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(UserUtil.checkUser(username, password)){
            request.setAttribute("loggedUser", username);
            RequestDispatcher view = request.getRequestDispatcher("success.jsp");
            view.forward(request, response);
        } else {
            request.setAttribute("failedUser", username);
            RequestDispatcher view = request.getRequestDispatcher("error.jsp");
            view.forward(request, response);
        }
    }


}
