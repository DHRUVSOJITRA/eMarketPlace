package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServicesProxy;

/**
 * Servlet implementation class addtocart
 */
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServicesProxy proxy = new ServicesProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("emailid");
		String username = proxy.getname(userEmail);
		String productname = request.getQueryString();
		int userid = proxy.getuserid(userEmail);
		int cartid = proxy.getcartid(userid);
		int productid = proxy.getproductid(productname);
		
		
		 try{
			 System.out.println("in the addtocart servlet");
			 	proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
			 	
			 	String result = proxy.addtocart(userEmail, productname);
			 	if(result.substring(0,4).equals("true")){
			 		System.out.println("product added to cart successfully");
			 		String categories = proxy.rendercategory();
			 		String[] categoriesToSend = categories.split(";");
					request.setAttribute("categoriesToSend", categoriesToSend);
			 		request.getRequestDispatcher("/View/categories.jsp").forward(request, response);
			 	}
			 
		 }catch(Exception s){
			 s.printStackTrace();
		 }
		
		
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
