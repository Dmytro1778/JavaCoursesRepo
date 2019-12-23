import Logic.Basket;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();

        Basket basket = (Basket) session.getAttribute("basket");

        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if(basket==null) {
            basket = new Basket();
            basket.setName(name);
            basket.setQuantity(quantity);
        }

        basket.setName(name);
        basket.setQuantity(quantity);

        session.setAttribute("basket", basket);

//        PrintWriter pw = response.getWriter();

//        pw.println("<html>");
//        pw.println("<h1> Your counter is: " + " </h1>");
//        pw.println("<h1> Hello, " + name + " " + lastName + " </h1>");
//        pw.println("</html>");

        getServletContext().getRequestDispatcher("/showBasket.jsp").forward(request, response);
    }
}
