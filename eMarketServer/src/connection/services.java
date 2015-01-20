package connection;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import com.google.gson.Gson;

public class services {
	public static final String categoryname = "";
	dbconnection dbcon = new dbconnection();
	
	public String getname(String emailid){
		String name = null;
		ResultSet res = dbcon.getname(emailid);
		
		try {
			while(res.next()){
				name =  res.getString("firstname") ;	
			}
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("name " + name );
		return name;
	}
	
	public int getuserid(String emailid){
		int userid = 0;
		ResultSet res = dbcon.getuserid(emailid);
		
		try {
			while(res.next()){
				userid =  res.getInt("userid") ;	
			}
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("userid " + userid );
		return userid;
	}
	
	public int getcartid(int userid){
		int cartid = 0;
		ResultSet res = dbcon.getcartid(userid);
		
		try {
			while(res.next()){
				cartid =  res.getInt("cartid") ;	
			}
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("cartid " + cartid );
		return cartid;
	}
	
	public int getproductid(String productname){
		int productid = 0;
		ResultSet res = dbcon.getproductid(productname);
		
		try {
			while(res.next()){
				productid =  res.getInt("productid") ;	
			}
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("productid " + productid );
		return productid;
	}
	
	public int getcategorytid(String categoryname){
		int categoryid = 0;
		ResultSet res = dbcon.getcategoryid(categoryname);
		
		try {
			while(res.next()){
				categoryid =  res.getInt("categoryid") ;	
			}
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("productid " + categoryid );
		return categoryid;
	}
	
	
	public String addtocart(String emailid , String productname){
		String result = "false";
		result = dbcon.addtocart(emailid, productname);
		return result;
	}
	
	public String rendercart(String emailid){
		String result = "";
		String products = "";
		String discription = "";
		String price = "";
		String sellerid = "";
		String selleraddress = "";
		String selleremailid = "";
		try {
			ResultSet res = dbcon.rendercart(emailid);
			while(res.next()){
				products += res.getString("productname")+";";
				discription += res.getString("discription")+";";
				price += res.getInt("price")+";";
				sellerid += res.getString("sellername")+";";
				selleraddress += res.getString("selleraddress")+";";
				selleremailid += res.getString("selleremailid")+";";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = products+"!"+ discription+"!"+ price+"!"+sellerid+"!"+selleraddress+"!"+selleremailid;
		return result;
	}
	
	public String signup(String firstname, String lastname , String emailid , String password){
    	System.out.println("inside signup");
    	String result = "";
    	
    	result = dbcon.signup(firstname, lastname , emailid , password);
    	
    	return result;
    }
    
    public String signin(String name, String pass){
    	System.out.println("inside signin");
    	String result = "";
    	
    	result = dbcon.signin(name, pass);
    	
    	return result;
    }
    
    public String rendercategory(){
    	    String catname = "";
 	    	System.out.println("in render cat");
 	    	ResultSet res = dbcon.rendercategory();
 	    	resultsBeans bean = new resultsBeans();
     		try {
				while(res.next()){
					catname += (res.getString("name") + ";");
					bean.setcategories(catname);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
     		System.out.println("in services " + catname );
     		return catname;
        
    }
    
        
    public String renderproducts(String catname){
	   String productname = "";
	   String discription = "";
	   String price = "";
	   String quantity = "";
	   String sellername = "";
	   String selleraddress = "";
	   String selleremailid = "";
    	
	    	System.out.println("in render cat"+catname);
	    	ResultSet res = dbcon.renderproducts(catname);
	    try {
			while(res.next()){
				productname += (res.getString("productname") + ";");
				discription += (res.getString("discription") + ";");
				price += ((res.getInt("price")) + ";");
				quantity += ((res.getInt("quantity")) + ";");
				sellername += (res.getString("sellername") + ";");
				selleraddress += (res.getString("selleraddress") + ";");
				selleremailid += (res.getString("selleremailid") + ";");
							
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String finalString = productname+"!"+discription+"!"+price+"!"+quantity + "!"+sellername+"!" + selleraddress + "!"+ selleremailid   ;
		System.out.println();
		System.out.println("in services final string " + finalString );
		System.out.println();
 		return finalString;
    
    }
    
    public String deleteFromCart(String emailid , String productname){
    	String result = dbcon.deleteFromCart(emailid, productname);
            	
    	return result;
    }
    
    public String checkout(String emailid){
    	String result = "false";
    	result = dbcon.checkout(emailid);
    	return result;
    }
    
    public String lasttimeloggedin(String emailid){
    	Time time = null;
    	time = dbcon.lasttimeloggedin(emailid);
    	System.out.println("date nd time " + time);
    	String stime = time.toString();
    	System.out.println("date nd stime " + stime);
    	return stime;
    }
    
    public String settime(String emailid){
    	String result = "false";
    	result = dbcon.settime(emailid);
    	return result;
    }
    
   
    public String addproduct(String emailid, String category,String itemname,String itemdiscription,String itemprice,String itemquantity,String sname,String saddress,String semailid){
    	String result = "false";
    	result = dbcon.addproduct( emailid , category, itemname , itemdiscription , itemprice, itemquantity, sname , saddress , semailid);
    	return result;
    	
    }
    
    public String addcategory(String categoryname){
    	String result = "false";
    	result = dbcon.addcategory(categoryname);
    	return result;
    	
    }
    
    public String pastpurchases(String emailid){
    	String finalstring = "";
    	ResultSet res = dbcon.pastpurchases(emailid);
    	String productnames = "" ;
    	String discriptions = "";
    	String prices = "";
    	String sellerid = "";
    	String selleremailid = "";
    	String selleraddress = "";
    	try {
			while(res.next()){
				productnames += res.getString("productname")+";";
				discriptions += res.getString("discription")+";";
				prices += res.getInt("price")+";";
				sellerid += res.getString("sellername")+";";
				selleremailid += res.getString("selleremailid")+";";
				selleraddress += res.getString("selleraddress")+";";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finalstring = productnames + "!" +discriptions + "!" +prices+"!"+sellerid+"!"+selleremailid+"!"+selleraddress;
    	return finalstring;
    }
    
    public String pastsoldouts(String emailid){
    	String finalstring = "";
    	ResultSet res = dbcon.pastsoldouts(emailid);
    	String productnames = "" ;
    	String discriptions = "";
    	String prices = "";
    	
    	try {
			while(res.next()){
				productnames += res.getString("productname")+";";
				discriptions += res.getString("discription")+";";
				prices += res.getInt("price")+";";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finalstring = productnames + "!" +discriptions + "!" +prices;
    	return finalstring;
    }
    
    public String deleteproduct(String productname){
    	String result = "";
    	result = dbcon.deletefromproducts(productname);
    	return result ;
    	
    }
    
    
}


