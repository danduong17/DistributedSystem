package com.cs.ds.ws.soap;
import javax.xml.ws.Endpoint;  
// Endpoint publisher 
public class Add2NumbersPublisher {
    Endpoint.publish("http://localhost:7779/ws/add2numbers", new Add2NumbersImpl());  
}
