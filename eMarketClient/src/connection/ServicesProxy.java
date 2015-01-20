package connection;

public class ServicesProxy implements connection.Services {
  private String _endpoint = null;
  private connection.Services services = null;
  
  public ServicesProxy() {
    _initServicesProxy();
  }
  
  public ServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicesProxy();
  }
  
  private void _initServicesProxy() {
    try {
      services = (new connection.ServicesServiceLocator()).getservices();
      if (services != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)services)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)services)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (services != null)
      ((javax.xml.rpc.Stub)services)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public connection.Services getServices() {
    if (services == null)
      _initServicesProxy();
    return services;
  }
  
  public java.lang.String addtocart(java.lang.String emailid, java.lang.String productname) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.addtocart(emailid, productname);
  }
  
  public int getuserid(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.getuserid(emailid);
  }
  
  public java.lang.String getname(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.getname(emailid);
  }
  
  public int getcartid(int userid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.getcartid(userid);
  }
  
  public java.lang.String rendercart(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.rendercart(emailid);
  }
  
  public int getproductid(java.lang.String productname) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.getproductid(productname);
  }
  
  public java.lang.String signup(java.lang.String firstname, java.lang.String lastname, java.lang.String emailid, java.lang.String password) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.signup(firstname, lastname, emailid, password);
  }
  
  public java.lang.String signin(java.lang.String name, java.lang.String pass) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.signin(name, pass);
  }
  
  public java.lang.String pastpurchases(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.pastpurchases(emailid);
  }
  
  public java.lang.String settime(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.settime(emailid);
  }
  
  public java.lang.String addproduct(java.lang.String emailid, java.lang.String category, java.lang.String itemname, java.lang.String itemdiscription, java.lang.String itemprice, java.lang.String itemquantity, java.lang.String sname, java.lang.String saddress, java.lang.String semailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.addproduct(emailid, category, itemname, itemdiscription, itemprice, itemquantity, sname, saddress, semailid);
  }
  
  public java.lang.String addcategory(java.lang.String categoryname) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.addcategory(categoryname);
  }
  
  public java.lang.String deleteproduct(java.lang.String productname) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.deleteproduct(productname);
  }
  
  public java.lang.String pastsoldouts(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.pastsoldouts(emailid);
  }
  
  public java.lang.String checkout(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.checkout(emailid);
  }
  
  public java.lang.String deleteFromCart(java.lang.String emailid, java.lang.String productname) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.deleteFromCart(emailid, productname);
  }
  
  public int getcategorytid(java.lang.String categoryname) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.getcategorytid(categoryname);
  }
  
  public java.lang.String lasttimeloggedin(java.lang.String emailid) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.lasttimeloggedin(emailid);
  }
  
  public java.lang.String rendercategory() throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.rendercategory();
  }
  
  public java.lang.String renderproducts(java.lang.String catname) throws java.rmi.RemoteException{
    if (services == null)
      _initServicesProxy();
    return services.renderproducts(catname);
  }
  
  
}