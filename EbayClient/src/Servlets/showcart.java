package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis.session.Session;

import connection.Services;
import connection.ServicesProxy;

/**
 * Servlet implementation class showcart
 */
public class showcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServicesProxy proxy = new ServicesProxy();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String emailid = (String) session.getAttribute("emailid");
		/////if null then it sends empty/////////
		String productnames = "";
		String discriptions = "";
		String prices = "";
		String sellerids = "";
	    String selleraddresss = "";
		String selleremailids = "";
		/////////////////////////////////////
		String[] productname = null;
		String[] discription = null;
		String[] price = null;
		String[] sellerid = null;
		String[] selleraddress = null;
		String[] selleremailid = null;
		
		
		String name = proxy.getname(emailid);
		String results = proxy.rendercart(emailid);
		String[] data = results.split("!");
		System.out.println(results);
		if(results.length() > 1){
			 productnames = data[0];
			 discriptions = data[1];
			 prices = data[2];
			 sellerids = data[3];
			 selleraddresss = data[4];
			 selleremailids = data[5];
			
			 
				
			 productname = productnames.split(";");
			 discription = discriptions.split(";");
			 price = prices.split(";");	
			 sellerid = sellerids.split(";");	
			 selleraddress = selleraddresss.split(";");	
			 selleremailid = selleremailids.split(";");	
		}
		 
		
		request.setAttribute("name", name );
		request.setAttribute("productname", productname);
		request.setAttribute("discription", discription);
		request.setAttribute("price", price);
		request.setAttribute("sellerid", sellerid);
		request.setAttribute("selleraddress", selleraddress);
		request.setAttribute("selleremailid", selleremailid);
		request.getRequestDispatcher("/View/showcart.jsp").forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
