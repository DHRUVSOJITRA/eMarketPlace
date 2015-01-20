package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ServicesProxy;

/**
 * Servlet implementation class addcategory
 */
public class addcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServicesProxy proxy = new ServicesProxy();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
		String categoryname = request.getParameter("categoryname");
		String result = proxy.addcategory(categoryname);
		
		if(result.substring(0,4).equals("true")){
			String categories = proxy.rendercategory();
			String[] categoriesToSend = categories.split(";");
			request.setAttribute("categoriesToSend", categoriesToSend);
			request.getRequestDispatcher("/View/sellingportal.jsp").forward(request, response);	
		}else{
			System.out.println("there is problem in adding category");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
