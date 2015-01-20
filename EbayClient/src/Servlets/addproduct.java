package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServicesProxy;

/**
 * Servlet implementation class addproduct
 */
public class addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesProxy proxy = new ServicesProxy();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailid = (String) session.getAttribute("emailid");
		proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
		
		String itemname = request.getParameter("itemname");
		String itemdiscription = request.getParameter("itemdiscription");
		String itemprice = request.getParameter("itemprice");
		String itemquantity = request.getParameter("itemquantity");
		String sname = request.getParameter("name");
		String saddress = request.getParameter("address");
		String semailid = request.getParameter("emailid");
		String category = request.getParameter("categories");
		
		String result = proxy.addproduct(emailid, category, itemname, itemdiscription, itemprice, itemquantity, sname, saddress, semailid);
	    if(result.substring(0,4).equals("true")){
	    	request.getRequestDispatcher("/View/buyorsell.jsp").forward(request, response);	
	    }else{
	    	System.out.println("there is problem in adding product");
	    }
		
		
	}

}
