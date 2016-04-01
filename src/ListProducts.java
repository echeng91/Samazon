import java.util.List;
import java.util.HashMap;
import model.Product;
import customTools.DBUtil;
import model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProducts() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(request.getParameter("newmap").equals("yes")) {
			HashMap<Product, Integer> cart = new HashMap<Product, Integer>();
			session.setAttribute("cart", cart);
			if(request.getParameter("login").equals("yes")) {
				User found;
				EntityManager em = DBUtil.getEmFactory().createEntityManager();
				String qString = "SELECT u from User u WHERE u.username = '" + request.getParameter("user") 
					+ "' AND u.userpass = '" + request.getParameter("pass") + "'";
				TypedQuery<User> q = em.createQuery(qString, User.class);
				try {
					if(q.getResultList().isEmpty()) {
						session.setAttribute("loggedin", "no");
					} else {
						found = q.getSingleResult();
						session.setAttribute("loggedin", "yes");
						session.setAttribute("user", found);
					}
				} catch (Exception e) {
					e.getMessage();
				} finally {
					em.close();
				}
			} else {
				session.setAttribute("loggedin", "no");
			}
		} 
		List<Product> productList = ProductDB.getAllProducts();
		request.setAttribute("productlist", productList);
		request.getRequestDispatcher("ProductList.jsp").forward(request, response);
	}

}
