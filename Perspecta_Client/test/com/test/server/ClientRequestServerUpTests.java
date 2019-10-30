package com.test.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.server.ClientRequest;

//Tests for the ClientRequest class.
//Assumes the server is not up and cannot make a connection.

public class ClientRequestServerUpTests {
		
	
	@Test
	public void testGoodURLNoConnection() throws IOException {
		String goodUrl = "http://localhost:8080";	
		ClientRequest testClientRequest = new ClientRequest(goodUrl);
		Assertions.assertTrue(testClientRequest.isConnected()); 
		}
	
	@Test
	public void testGoodURLBadPort() throws IOException {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
		df.setTimeZone(tz);	    	
    	df.format(new Date());
    	String goodUrl = "http://localhost:8080";	
		ClientRequest testClientRequest = new ClientRequest(goodUrl);
		assertEquals(df.format(new Date()), testClientRequest.getServerTime());	
		}
}
