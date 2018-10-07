package ro.sda.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "shoppingservlet", urlPatterns = "/shop")
public class ShoppingServlet extends HttpServlet {

    private Map<Integer, String> products = new HashMap<>();

    @Override
    public void init() {
        products.put(1, "Small tomatoes");
        products.put(2, "Big tomatoes");
        products.put(3, "Fabio cucumber");
        products.put(4, "Chilly peppers");
        products.put(5, "Green peppers");
        products.put(6, "Butter");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        switch (action) {
            case "addToCart":
                this.addToCart(request, response);
                break;
            case "viewCart":
                this.viewCart(request, response);
                break;
            case "emptyCart":
                this.emptyCart(request, response);
                break;
            case "browse":
            default:
                this.browse(request, response);
                break;
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId"));

        HttpSession session = request.getSession();
        if(session.getAttribute("cart") == null){
            session.setAttribute("cart", new HashMap<String, Integer>());
        }
        Map<String, Integer> cart = (HashMap<String, Integer>) request.getAttribute("cart");

        if(cart.containsKey(products.get(productId))){
            cart.put(products.get(productId), cart.get(products.get(productId)) + 1);
        } else {
            cart.put(products.get(productId), 1);
        }

        response.sendRedirect("shop?action=viewCart");

    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Integer> cart = (HashMap<String, Integer>) request.getSession().getAttribute("cart");
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("viewCart.jsp").forward(request, response);
    }

    private void emptyCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("cart");
        //response.sendRedirect("shop?action=browse");
        browse(request, response);
    }

    private void browse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", products);
        request.getRequestDispatcher("products").forward(request, response);
    }

}
