package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ServicesProxy;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServicesProxy proxy = new ServicesProxy();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
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
		String result;
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		String msg = "please fill all the fields and sign up again";
		if(firstname == "" || lastname == "" || emailid == "" || password == ""){
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/View/signup.jsp").forward(request, response);	
		}else{
			/*System.out.println("in the signup servlet : " + firstname);
			System.out.println("in the signup servlet : " + lastname);
			System.out.println("in the signup servlet : " + emailid);
			System.out.println("in the signup servlet : " + password);*/
			
			proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
			result = proxy.signup(firstname,lastname,emailid,password);
			
			if(result.substring(0,4).equals("true")){
				request.getRequestDispatcher("/View/signin.jsp").forward(request, response);
			}else{
				System.out.println("error adding signup info");
			}
		}
		
		
		
		
	}

}
