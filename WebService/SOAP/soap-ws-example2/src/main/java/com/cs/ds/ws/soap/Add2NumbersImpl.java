package com.cs.ds.ws.soap;

import javax.jws.WebService; 

//Service Implementation  
@WebService(endpointInterface = "com.cs.ds.ws.soap.Add2Numbers")

public class Add2NumbersImpl implements Add2Numbers {
	public String get2NumbersAsString(int a, int b) {
		return String.valueOf(a+b);
	}
}
