/**
 * SOAPEx1DemoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cs.ds.ws.soap;

public class SOAPEx1DemoServiceLocator extends org.apache.axis.client.Service implements com.cs.ds.ws.soap.SOAPEx1DemoService {

    public SOAPEx1DemoServiceLocator() {
    }


    public SOAPEx1DemoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOAPEx1DemoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOAPEx1Demo
    private java.lang.String SOAPEx1Demo_address = "http://localhost:8080/soap-ws-example1/services/SOAPEx1Demo";

    public java.lang.String getSOAPEx1DemoAddress() {
        return SOAPEx1Demo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOAPEx1DemoWSDDServiceName = "SOAPEx1Demo";

    public java.lang.String getSOAPEx1DemoWSDDServiceName() {
        return SOAPEx1DemoWSDDServiceName;
    }

    public void setSOAPEx1DemoWSDDServiceName(java.lang.String name) {
        SOAPEx1DemoWSDDServiceName = name;
    }

    public com.cs.ds.ws.soap.SOAPEx1Demo getSOAPEx1Demo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOAPEx1Demo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAPEx1Demo(endpoint);
    }

    public com.cs.ds.ws.soap.SOAPEx1Demo getSOAPEx1Demo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cs.ds.ws.soap.SOAPEx1DemoSoapBindingStub _stub = new com.cs.ds.ws.soap.SOAPEx1DemoSoapBindingStub(portAddress, this);
            _stub.setPortName(getSOAPEx1DemoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOAPEx1DemoEndpointAddress(java.lang.String address) {
        SOAPEx1Demo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cs.ds.ws.soap.SOAPEx1Demo.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cs.ds.ws.soap.SOAPEx1DemoSoapBindingStub _stub = new com.cs.ds.ws.soap.SOAPEx1DemoSoapBindingStub(new java.net.URL(SOAPEx1Demo_address), this);
                _stub.setPortName(getSOAPEx1DemoWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SOAPEx1Demo".equals(inputPortName)) {
            return getSOAPEx1Demo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.ws.ds.cs.com", "SOAPEx1DemoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.ws.ds.cs.com", "SOAPEx1Demo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOAPEx1Demo".equals(portName)) {
            setSOAPEx1DemoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
