package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import connection.*;
/**
 * Servlet implementation class signin
 */
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServicesProxy proxy = new ServicesProxy();   
    ResultsBeansProxy beanproxy = new ResultsBeansProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone;
		
		 try{			
			   // System.out.println("in the servlet");
			 	String emailid = request.getParameter("emailid");
			 	String pass = request.getParameter("pass");
			 	if(emailid.contains("@")){
			 		proxy.setEndpoint("http://localhost:8080/Ebay/services/services");
					qdone = proxy.signin(emailid,pass);
					
					
					if(qdone.substring(0,4).equals("true")){
						HttpSession session = request.getSession();
						session.setAttribute("emailid" , emailid);
						session.setMaxInactiveInterval(30*60);
					
						String date = proxy.lasttimeloggedin(emailid);
						String result1 = proxy.settime(emailid);
						request.setAttribute("date", date);
						request.getRequestDispatcher("/View/buyorsell.jsp").forward(request, response);

						//request.setAttribute("msg", "Welcome to Ebay "+user);
						//Object res =  proxy.rendercategory();
						/*String categories = proxy.rendercategory();
						//Object[] categories =  beanproxy.getcategories();
						System.out.println("categories in servlet "+ categories );
						String[] categoriesToSend = categories.split(";");
						//System.out.println("res1 " + res);
						String username = proxy.getname(emailid);
						
						
						request.setAttribute("username", username);
						request.setAttribute("categoriesToSend", categoriesToSend);
						request.setAttribute("date", date);
						out.println("WELCOME to Simple Market Place :"+ emailid);*/
					}
					else{
						String msg = "email Id or password incorrect";
						request.setAttribute("msg", msg);
				 		request.getRequestDispatcher("/View/signin.jsp").forward(request, response);					}
			 	}else{
			 		String msg = "Please use your email id to log in....bad email format";
			 		request.setAttribute("msg", msg);
			 		request.getRequestDispatcher("/View/signin.jsp").forward(request, response);
			 		System.out.println("it does not contains @");
			 	}
			 	
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

}
