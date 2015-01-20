package connection;

import java.util.ArrayList;

public class resultsBeans implements java.io.Serializable{
	
	private static ArrayList<String> categories = new ArrayList<String>(); 
	public resultsBeans(){}
	
 	public ArrayList getcategories(){
			return categories;
		}
	
 	public void setcategories(String name){
 		  categories.add(name);
 	}
}
