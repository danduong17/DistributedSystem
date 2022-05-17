package com.cs.ds.ws.soap;

public class SOAPEx1DemoProxy implements com.cs.ds.ws.soap.SOAPEx1Demo {
  private String _endpoint = null;
  private com.cs.ds.ws.soap.SOAPEx1Demo sOAPEx1Demo = null;
  
  public SOAPEx1DemoProxy() {
    _initSOAPEx1DemoProxy();
  }
  
  public SOAPEx1DemoProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAPEx1DemoProxy();
  }
  
  private void _initSOAPEx1DemoProxy() {
    try {
      sOAPEx1Demo = (new com.cs.ds.ws.soap.SOAPEx1DemoServiceLocator()).getSOAPEx1Demo();
      if (sOAPEx1Demo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAPEx1Demo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAPEx1Demo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAPEx1Demo != null)
      ((javax.xml.rpc.Stub)sOAPEx1Demo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cs.ds.ws.soap.SOAPEx1Demo getSOAPEx1Demo() {
    if (sOAPEx1Demo == null)
      _initSOAPEx1DemoProxy();
    return sOAPEx1Demo;
  }
  
  public java.lang.String add2Numbers(int a, int b) throws java.rmi.RemoteException{
    if (sOAPEx1Demo == null)
      _initSOAPEx1DemoProxy();
    return sOAPEx1Demo.add2Numbers(a, b);
  }
  
  
}