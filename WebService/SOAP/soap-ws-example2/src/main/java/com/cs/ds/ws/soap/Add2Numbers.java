package com.cs.ds.ws.soap;

import javax.jws.WebMethod;  
import javax.jws.WebService;  
import javax.jws.soap.SOAPBinding;  
import javax.jws.soap.SOAPBinding.Style;  

// Service Endpoint Interface  
@WebService  
@SOAPBinding(style = Style.RPC)  

public interface Add2Numbers {
	@WebMethod String get2NumbersAsString(int a, int b);
}
