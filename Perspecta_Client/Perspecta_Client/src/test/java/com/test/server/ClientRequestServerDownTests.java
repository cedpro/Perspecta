package com.test.server;

import java.net.ConnectException;
import java.net.MalformedURLException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.server.ClientRequest;

//Tests for the ClientRequest class.
//Assumes the server is not up and cannot make a connection.

public class ClientRequestServerDownTests {
	

	@Test
	public void testBadURL() {
		String badUrl = "testUrl";		
		Assertions.assertThrows(MalformedURLException.class, ()->
		{@SuppressWarnings("unused")
		ClientRequest testClientRequest = new ClientRequest(badUrl);
			}); 
		}
	
	@Test
	public void testGoodURLNoConnection() {
		String goodUrl = "http://localhost:8081";		
		Assertions.assertThrows(ConnectException.class, ()->
		{@SuppressWarnings("unused")
		ClientRequest testClientRequest = new ClientRequest(goodUrl);
			}); 
		}
	
	@Test
	public void testGoodURLBadPort() {
		String goodUrl = "http://localhost:75432";		
		Assertions.assertThrows(RuntimeException.class, ()->
		{@SuppressWarnings("unused")
		ClientRequest testClientRequest = new ClientRequest(goodUrl);
			}); 
		}						
}
