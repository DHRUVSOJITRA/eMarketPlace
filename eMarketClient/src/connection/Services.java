/**
 * Services.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connection;

public interface Services extends java.rmi.Remote {
    public java.lang.String addtocart(java.lang.String emailid, java.lang.String productname) throws java.rmi.RemoteException;
    public int getuserid(java.lang.String emailid) throws java.rmi.RemoteException;
    public java.lang.String getname(java.lang.String emailid) throws java.rmi.RemoteException;
    public int getcartid(int userid) throws java.rmi.RemoteException;
    public java.lang.String rendercart(java.lang.String emailid) throws java.rmi.RemoteException;
    public int getproductid(java.lang.String productname) throws java.rmi.RemoteException;
    public java.lang.String signup(java.lang.String firstname, java.lang.String lastname, java.lang.String emailid, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String signin(java.lang.String name, java.lang.String pass) throws java.rmi.RemoteException;
    public java.lang.String pastpurchases(java.lang.String emailid) throws java.rmi.RemoteException;
    public java.lang.String settime(java.lang.String emailid) throws java.rmi.RemoteException;
    public java.lang.String addproduct(java.lang.String emailid, java.lang.String category, java.lang.String itemname, java.lang.String itemdiscription, java.lang.String itemprice, java.lang.String itemquantity, java.lang.String sname, java.lang.String saddress, java.lang.String semailid) throws java.rmi.RemoteException;
    public java.lang.String addcategory(java.lang.String categoryname) throws java.rmi.RemoteException;
    public java.lang.String deleteproduct(java.lang.String productname) throws java.rmi.RemoteException;
    public java.lang.String pastsoldouts(java.lang.String emailid) throws java.rmi.RemoteException;
    public java.lang.String checkout(java.lang.String emailid) throws java.rmi.RemoteException;
    public java.lang.String deleteFromCart(java.lang.String emailid, java.lang.String productname) throws java.rmi.RemoteException;
    public int getcategorytid(java.lang.String categoryname) throws java.rmi.RemoteException;
    public java.lang.String lasttimeloggedin(java.lang.String emailid) throws java.rmi.RemoteException;
    public java.lang.String rendercategory() throws java.rmi.RemoteException;
    public java.lang.String renderproducts(java.lang.String catname) throws java.rmi.RemoteException;
}
