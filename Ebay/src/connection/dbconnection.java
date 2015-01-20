package connection;
import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.corba.se.impl.orbutil.ObjectWriter;


public class dbconnection {
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
    
    dbconnection(){
    	try{
    	    
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","jerrymouse");
    		stmt = con.createStatement();
    		if(!con.isClosed()){
    			System.out.println("connection successfully");
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}catch(InstantiationException i){
    		i.printStackTrace();
    	}
    	catch(IllegalAccessException a){
    		a.printStackTrace();
    	}catch(ClassNotFoundException c){
    		c.printStackTrace();
    	}
    }
    //////////////function for signup/////////////
    public String signup(String firstname, String lastname , String emailid , String password){
		
    	int count;
		int userid;
		ResultSet res = null;
		String result = "";
		services ser = new services();
		try{
			
			String query = "INSERT INTO users (firstname , lastname , emailid , password ) values ('"+ firstname+"','"+lastname +"' , '"+emailid+"' , '"+ password+"')";
			count = stmt.executeUpdate(query);
		    userid = ser.getuserid(emailid);
			System.out.println("userid in signup "+ userid);
			if(count >= 1){
				String query1 = "insert into userhistory (userid , lasttimeloggedin ) values ('"+ userid+"' , Now())";
				String query2 = "insert into purchasehistory (id) values ('"+ userid+"')";
				String query3 = "insert into cart (userid , bill) values ('"+ userid+"','0')";
				/////////////////////////execute multiple sql statements together////////////
				con.setAutoCommit(false);
			      stmt.addBatch(query1);
			      stmt.addBatch(query2);
			      stmt.addBatch(query3);
			      stmt.executeBatch();
			      con.commit();
			      System.out.println("Batch executed");
				/////////////////////////////////////////////////////////////////////////////
				result = "true";
    			System.out.println("insert successfull");
    		}else{
    			System.out.println("failed");
    		}
		}catch(SQLException s){
			s.printStackTrace();
		}
    	return result;
    	
    }
    ////////////////fun for sign in
    public String signin(String emailid , String password){
    	//System.out.println("user emailid "+ emailid );
    	//System.out.println("user password "+ password );
		String result = "false";
		try{
			String query = "SELECT * FROM users where emailid = '"+ emailid+"' and password= '"+password+"'";
			System.out.println("query in sign in " + query);
			//count = stmt.executeQuery(query);
			ResultSet res = stmt.executeQuery(query);
			if(res.next()){
				result="true";
					
					
			}
			return result;
			
		}catch(SQLException s){
			s.printStackTrace();
		}
    	return result;
    	
    }
    
    public ResultSet getname(String emailid){
    	ResultSet res = null;
    	System.out.println("emails in dbcon "+ emailid );
    	String query = "select firstname from users where emailid = '"+emailid +"'";
    	try{
    		res = stmt.executeQuery(query);
    		System.out.println("name is taken: con successful " );
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return res;
    }
    
    
    public ResultSet getuserid(String emailid){
    	ResultSet res = null;
    	System.out.println("emails in dbcon getid "+ emailid );
    	String query = "select userid from users where emailid = '"+emailid +"'";
    	try{
    		res = stmt.executeQuery(query);
    		System.out.println("userid is taken: con successful " );
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return res;
    }
    
    public ResultSet getcartid(int userid){
    	ResultSet res = null;
    	System.out.println("userid in dbcon getid "+ userid );
    	String query = "select cartid from cart where userid='"+userid+"'";
    	try{
    		res = stmt.executeQuery(query);
    		System.out.println("cartid is taken: con successful " );
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return res;
    }
    
    public ResultSet getproductid(String productname){
    	ResultSet res = null;
    	System.out.println("productname in dbcon getid "+ productname );
    	String query = "select productid from products where productname='"+productname+"'";
    	try{
    		res = stmt.executeQuery(query);
    		System.out.println("productname is taken: con successful " );
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return res;
    }
    
    public ResultSet getcategoryid(String categoryname){
    	ResultSet res = null;
    	System.out.println("categoryname in dbcon getid "+ categoryname );
    	String query = "select categoryid from category where name='"+categoryname+"'";
    	try{
    		res = stmt.executeQuery(query);
    		System.out.println("categoryname is taken: con successful " );
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return res;
    }
    
    public String addtocart(String emailid , String productname){
    	services ser = new services();
    	ResultSet res = null;
    	int price = 0 ;
    	String result = "false";
    	String username = ser.getname(emailid);
		try{
			int userid = ser.getuserid(emailid);
			int cartid = ser.getcartid(userid);
			int productid = ser.getproductid(productname);
			System.out.println("in the addcart " + productid );
	    	String query1 = "insert into cart_pro (cartid , productid) values ('"+ cartid +"' , '"+ productid +"')";
	    	String query2 = "select price from products where productid = '"+productid+"'";
	    	int count1 = stmt.executeUpdate(query1);
	    	res = stmt.executeQuery(query2);
	    	while(res.next()){
	    		 price = res.getInt("price");
	    	}
			String query3 = "update cart set bill = bill + "+price+" where cartid='"+cartid +"'" ;
			int count = stmt.executeUpdate(query3);
			if(count >= 1){
				result = "true";
			}
			
		}catch(SQLException s){
			s.printStackTrace();
		}
		return result;
		
    }
    
    public String deleteFromCart(String emailid , String productname){
    	String result = "false";
    	services ser = new services();
    	int userid = ser.getuserid(emailid);
    	try{
    		String query = "delete from cart_pro where productid = (select productid from products where productname = '"+productname+"' LIMIT 1) AND cartid = (select cartid from cart where userid = '"+userid +"' LIMIT 1)";
    		int count = stmt.executeUpdate(query);
    		if(count >=1){
    			result = "true";
    			
    		}
    		System.out.println("in the dbcon deletecart result: " + result);
    	}catch(SQLException s){
    		s.printStackTrace();
    	}
    	return result;
    }
    
    public ResultSet rendercart(String emailid){
    	services ser = new services();
    	ResultSet res = null;
    	int userid = ser.getuserid(emailid);
		int cartid = ser.getcartid(userid);
    	try{
    		String query = "select productname,discription,price,sellername,selleraddress,selleremailid from products,cart_pro,cart,users where cart_pro.cartid = cart.cartid and products.productid = cart_pro.productid and cart.userid ='"+
    		userid+"' and users.userid = cart.userid";
    		
    		res = stmt.executeQuery(query);
    		
    	}catch(SQLException s){
    		s.printStackTrace();
    	}
    	return res;
    }
    
    public ResultSet rendercategory(){
    	ResultSet res = null;
    	String jsonized = null;
    	
    	try{
    		String query = "SELECT name FROM amazon.category";
	
			res = stmt.executeQuery(query);
			//Gson gson = new Gson();
			//ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			//String json = ow.writeValueAsString(res);
			//System.out.println("after gson");
		    //String json = gson.toJson(res); 
		    //System.out.println("json "+ json);
			//Array categoryname = res.getArray("name");
			//System.out.println("categoryname " + categoryname);
    	}catch(SQLException s){
    		s.printStackTrace();	
    	}
		return res;
    }
    
    public ResultSet renderproducts(String categoryname){
    	
    	ResultSet res = null;
    	String jsonized = null;
    	
    	try{
    		String query = "select products.productid,productname,discription,price,quantity,sellername,selleraddress,selleremailid from category,products,pro_cat where category.name='"+ categoryname +"' AND category.categoryid= pro_cat.categoryid AND products.productid = pro_cat.productid";
	
			res = stmt.executeQuery(query);
			
    	}catch(SQLException s){
    		s.printStackTrace();	
    	}
		return res;
    	
    } 
    
    public String checkout(String emailid){
        String result = "false";
        services ser = new services();
        String name = ser.getname(emailid);
        int userid = ser.getuserid(emailid);
        int cartid = ser.getcartid(userid);
        String pname = "";
        String query = "select productid from cart_pro where cartid = '"+ cartid +"'";
    	try{
    		Statement stmt1 = con.createStatement();
    		ResultSet res = stmt1.executeQuery(query);
    		while(res.next()){
    			int pid = res.getInt("productid");
    			System.out.println("pid " + pid);
    			String query1 = "select productname from amazon.products where productid='"+pid+"'";
    		
    			ResultSet res1 = stmt.executeQuery(query1);
    			while(res1.next()){
    				 pname = res1.getString("productname");
        			System.out.println("pname " + pname);
        			String query5 = "select sellername from products where productname='"+ pname+"' LIMIT 1";
        			Statement stmt3 = con.createStatement();
        			ResultSet res2 = stmt3.executeQuery(query5);
        			while(res2.next()){
        				int sellerid = Integer.parseInt(res2.getString("sellername"));
        				String query6 = "insert into userhistory (userid , pastsoldouts) values ('"+ sellerid+"','"+ pname+"')"; 
        				Statement stmt4 = con.createStatement();
        				int count = stmt4.executeUpdate(query6);
        					
        			}
        			String query3 = "insert into amazon.userhistory (userid , purchasedproducts) values ('"+userid +"' , '"+pname +"')";
        			Statement stmt2 = con.createStatement();
        			int count = stmt2.executeUpdate(query3);
        			if(count >= 1){
        				result = "true";
        				//return result;
        			}
    			}
    			
    			
    			
    		}
    		String query4 = "select * from cart_pro where cartid = (select cartid from users , cart where cart.userid = users.userid AND users.firstname = '"+ name+"')";
    		Statement stmt3 = con.createStatement();
    		ResultSet res2 = stmt3.executeQuery(query4);
			while(res2.next()){
				int pid = res2.getInt("productid");
				Statement stmt4 = con.createStatement();
				String query5 = "update products set quantity = quantity-1 where productid = '"+ pid +"'";
				String query6 = "delete from amazon.cart_pro where cartid = '"+ cartid+"'";
				
				int count1 = stmt4.executeUpdate(query5);
				int count2 = stmt4.executeUpdate(query6);
				System.out.println("count1 "+ count1);
				System.out.println("count2 "+ count2);
				if(count1 >= 1){
    				System.out.println("products inventory updated");
    				return result;
    			}
			}
    	}catch(SQLException s){
    		s.printStackTrace();
    	}
        
    	return result;
    }
    
    public Time lasttimeloggedin(String emailid){
    	Time time = null;
    	services ser = new services();
    	int userid = ser.getuserid(emailid);
    	String query = "select lasttimeloggedin from userhistory where userid= '"+userid +"' LIMIT 1";
    	try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while(res.next()){
				time = res.getTime("lasttimeloggedin");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
    }
    
    public String settime(String emailid){
        String result = "false";
        services ser = new services();
        int userid = ser.getuserid(emailid);
    	String query ="update userhistory set lasttimeloggedin = Now() where userid = '"+ userid+"'";
    	try {
			Statement stmt1 = con.createStatement();
			int count = stmt1.executeUpdate(query);
			if(count >= 1){
				result = "true";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return result;
    }
    
    public String addproduct(String emailid, String category, String itemname,String itemdiscription,String itemprice,String itemquantity,String sname,String saddress,String semailid){
    	String result = "false";
    	services ser = new services(); 
    	int price = Integer.parseInt(itemprice);
    	int quantity = Integer.parseInt(itemquantity);
    	String query1 ="insert into products (productname , discription , price, quantity , sellername , selleraddress , selleremailid) values ('"+itemname+"','"+itemdiscription+"','"+price+"','"+quantity+"','"+sname+"','"+saddress+"','"+semailid+"')";
    	
    	try {
    		
			Statement stmt1 = con.createStatement();
			int count = stmt1.executeUpdate(query1);
			if(count >= 1){
				Statement stmt2 = con.createStatement();
				int productid = ser.getproductid(itemname);
				int categoryid = ser.getcategorytid(category);
				String query2 ="insert into pro_cat (productid , categoryid) values ('"+productid+"','"+categoryid+"')";
				int count1 = stmt2.executeUpdate(query2);
				if(count1 >= 1){
					result = "true";
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }
    
    public String addcategory(String categoryname){
    	String result = "false";
    	services ser = new services(); 
    	String query1 ="insert into category (name) values ('"+categoryname+"')";
    	
    	try {
    		
			Statement stmt1 = con.createStatement();
			int count = stmt1.executeUpdate(query1);
			if(count >= 1){
				result = "true";
				return result;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }
    
    public ResultSet pastpurchases(String emailid){
    	ResultSet res = null;
    	services ser = new services();
    	int userid = ser.getuserid(emailid);
    	String query1 = "select productname , discription , price , sellername , selleremailid, selleraddress from amazon.products , amazon.userhistory where userhistory.purchasedproducts = products.productname AND userhistory.userid = '"+ userid +"'";
    	try {
			Statement stmt1 = con.createStatement();
		    res = stmt1.executeQuery(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return res;
    }
    
    public ResultSet pastsoldouts(String emailid){
    	ResultSet res = null;
    	services ser = new services();
    	int userid = ser.getuserid(emailid);
    	String query1 = "select productname , discription , price  from amazon.products , amazon.userhistory where userhistory.pastsoldouts = products.productname AND userhistory.userid = '"+ userid +"'";
    	try {
			Statement stmt1 = con.createStatement();
		    res = stmt1.executeQuery(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return res;
    }
    
    public String deletefromproducts(String productname){
        String result = "false";
    	String query = "delete from amazon.products where productname='"+ productname+"'";
    	try {
			Statement stmt1 = con.createStatement();
			int count = stmt1.executeUpdate(query);
			if(count > 1){
				result = "true";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return result ;
    }
    
    
}
