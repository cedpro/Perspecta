package com.test.server;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

import com.server.ServerController;

public class ServerControllerTests {
	
	@Test
	public void testGetServerTime() {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
		df.setTimeZone(tz);	    	
    	df.format(new Date());
    	ServerController serverController = new ServerController();
		assertEquals(df.format(new Date()), serverController.index());
	}

}
