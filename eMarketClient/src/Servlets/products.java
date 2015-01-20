package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ServicesProxy;

/**
 * Servlet implementation class products
 */
public class products extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServicesProxy proxy = new ServicesProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public products() {
        super();	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailid = (String) session.getAttribute("emailid");
		String catname = request.getQueryString();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		System.out.println("in the product's get");
		 try{			
			    System.out.println("in the products servlet");
			 	proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
									
					String productsInfo = proxy.renderproducts(catname);
					
					//Object[] categories =  beanproxy.getcategories();
					System.out.println("products in servlet "+ productsInfo );
					String[] productsAtt = productsInfo.split("!");
					String productnames = productsAtt[0];
					String discriptions = productsAtt[1];
					String prices = productsAtt[2];
					String quantitys = productsAtt[3];
					String sellernames = productsAtt[4];
			        String selleraddresses = productsAtt[5];
			        String selleremailids = productsAtt[6];
			        	
					String[] productname = productnames.split(";");
					String[] discription = discriptions.split(";");
					String[] price = prices.split(";");
					String[] quantity = quantitys.split(";");
					String[] sellername = sellernames.split(";");
					String[] selleraddress = selleraddresses.split(";");
					String[] selleremailid = selleremailids.split(";");
					
					String name = proxy.getname(emailid);
					
					request.setAttribute("emailid", emailid );
					request.setAttribute("name", name );
					request.setAttribute("productname", productname);
					request.setAttribute("discription", discription);
					request.setAttribute("price", price);
					request.setAttribute("quantity", quantity);
					request.setAttribute("sellername", sellername);
					request.setAttribute("selleraddress", selleraddress);
					request.setAttribute("selleremailid", selleremailid);
					
					request.getRequestDispatcher("/View/products.jsp").forward(request, response);	
				
		 }
		 catch (Exception e)
	        {
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
