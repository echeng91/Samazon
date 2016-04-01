import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import model.Product;
import model.User;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessOrder
 */
@WebServlet("/ProcessOrder")
public class ProcessOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessOrder() {
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
		Connection con = null;
		try{
			java.util.Date now = new java.util.Date();
			java.sql.Date sqlnow = new java.sql.Date(now.getTime());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			HashMap<Product, Integer> checkCart = (HashMap<Product, Integer>) session.getAttribute("cart");
			for(Entry<Product, Integer> entry: checkCart.entrySet()) {
				PreparedStatement placeOrder = con.prepareStatement("insert into orders(userid, productid, quantity, orderdate) values (?,?,?,?)");
				placeOrder.setInt(1, (int)((User)session.getAttribute("user")).getUserid());
				placeOrder.setInt(2, (int)entry.getKey().getPid());
				placeOrder.setInt(3, entry.getValue());
				placeOrder.setDate(4, sqlnow);
				placeOrder.executeUpdate();
			}
			HashMap<Product, Integer> emptyCart = new HashMap<Product, Integer>();
			session.setAttribute("cart", emptyCart);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		
	}

}
