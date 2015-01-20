package connection;

public class ResultsBeansProxy implements connection.ResultsBeans {
  private String _endpoint = null;
  private connection.ResultsBeans resultsBeans = null;
  
  public ResultsBeansProxy() {
    _initResultsBeansProxy();
  }
  
  public ResultsBeansProxy(String endpoint) {
    _endpoint = endpoint;
    _initResultsBeansProxy();
  }
  
  private void _initResultsBeansProxy() {
    try {
      resultsBeans = (new connection.ResultsBeansServiceLocator()).getresultsBeans();
      if (resultsBeans != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)resultsBeans)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)resultsBeans)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (resultsBeans != null)
      ((javax.xml.rpc.Stub)resultsBeans)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public connection.ResultsBeans getResultsBeans() {
    if (resultsBeans == null)
      _initResultsBeansProxy();
    return resultsBeans;
  }
  
  public java.lang.Object[] getcategories() throws java.rmi.RemoteException{
    if (resultsBeans == null)
      _initResultsBeansProxy();
    return resultsBeans.getcategories();
  }
  
  public void setcategories(java.lang.String name) throws java.rmi.RemoteException{
    if (resultsBeans == null)
      _initResultsBeansProxy();
    resultsBeans.setcategories(name);
  }
  
  
}