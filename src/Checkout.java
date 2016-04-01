import java.util.HashMap;
import java.util.Map.Entry;
import java.text.NumberFormat;

import model.Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HashMap<Product, Integer> checkCart = (HashMap<Product, Integer>) session.getAttribute("cart");
		double total = 0;
		for(Entry<Product, Integer> entry : checkCart.entrySet()) {
			total += entry.getKey().getPprice().doubleValue() * entry.getValue();
		}
		String displayTotal = NumberFormat.getCurrencyInstance().format(total);
		request.setAttribute("checkouttotal", displayTotal);
		request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
	}

}
