package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServicesProxy;

/**
 * Servlet implementation class validatecardinfo
 */
public class validatecardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServicesProxy proxy = new ServicesProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validatecardinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailid = (String) session.getAttribute("emailid");
		String cardnumber = request.getParameter("creditcardnumber");
		if(cardnumber.length() == 16){
			String result = proxy.checkout(emailid);
			//System.out.println("card accepted");
			String categories = proxy.rendercategory();
			System.out.println("categories in servlet "+ categories );
			String[] categoriesToSend = categories.split(";");
			String username = proxy.getname(emailid);
			request.setAttribute("username", username);
			request.setAttribute("categoriesToSend", categoriesToSend);
			request.getRequestDispatcher("/View/categories.jsp").forward(request, response);
		
		}else{
			String msg = "card failed to validate....please check out again";
			System.out.println("card rejected");
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/View/checkout.jsp").forward(request, response);

		}
	}

}
