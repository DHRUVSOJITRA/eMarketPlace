package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServicesProxy;

/**
 * Servlet implementation class deletefromcart
 */
public class deletefromcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesProxy proxy = new ServicesProxy();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletefromcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailid = (String) session.getAttribute("emailid");
		String productname = request.getQueryString();
		try{
			System.out.println("in the delete from cart servlet");
		 	proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
		 	
		 	String result = proxy.deleteFromCart(emailid, productname);
		 	if(result.substring(0,4).equals("true")){
		 		request.getRequestDispatcher("/showcart").forward(request, response);	
		 	}else{
		 		System.out.println("there is some problem with transaction in delete from cart");
		 	}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
