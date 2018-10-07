package ro.sda.servlet;

import ro.sda.logic.GroceryUtil;
import ro.sda.model.Options;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "groceryservlet", urlPatterns = "/SelectGrocery")
public class GroceryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("Type");
        List<String> list = GroceryUtil.getAvailableGroceries(Options.valueOf(parameter));
        request.setAttribute("selectedOption", list);
        RequestDispatcher view = request.getRequestDispatcher("grocery.jsp");
        view.forward(request, response);

    }
}
