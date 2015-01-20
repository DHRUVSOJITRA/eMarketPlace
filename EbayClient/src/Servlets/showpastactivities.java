package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServicesProxy;

/**
 * Servlet implementation class showpastactivities
 */
public class showpastactivities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServicesProxy proxy = new ServicesProxy();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showpastactivities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailid = (String) session.getAttribute("emailid");
		String username = proxy.getname(emailid);
		proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
		String productinfo = proxy.pastpurchases(emailid);
		String sproductinfo = proxy.pastsoldouts(emailid);
		System.out.println("sproductinfo " + sproductinfo);
		
		String productnames = "";
		String discriptions = "";
		String prices = "";
		String[] productname  ;
		String[] discription = null;
		String[] price = null;
		

		String sproductnames = "";
		String sdiscriptions = "";
		String sprices = "";
		String[] sproductname = null;
		String[] sdiscription = null;
		String[] sprice = null;
		
		String[] productsAtt = productinfo.split("!");
		String[] sproductsAtt = sproductinfo.split("!");
		System.out.println(productsAtt.length);
		if(productsAtt.length > 1){
			 productnames = productsAtt[0];
			 discriptions = productsAtt[1];
			 prices = productsAtt[2];
			 
			     productname = productnames.split(";");
				 discription = discriptions.split(";");
				 price = prices.split(";");
				 
				 request.setAttribute("pproductname", productname);
					request.setAttribute("pdiscription", discription);
					request.setAttribute("pprice", price);
		}
		
		if(sproductsAtt.length > 1){
		    sproductnames = sproductsAtt[0];
			sdiscriptions = sproductsAtt[1];
			sprices = sproductsAtt[2];
			
		     sproductname = sproductnames.split(";");
			 sdiscription = sdiscriptions.split(";");
			 sprice = sprices.split(";");
			 
			    request.setAttribute("sproductname", sproductname);
				request.setAttribute("sdiscription", sdiscription);
				request.setAttribute("sprice", sprice);
		}	
		
		request.setAttribute("username", username);
		request.getRequestDispatcher("/View/pastactivities.jsp").forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
