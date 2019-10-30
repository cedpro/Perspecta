package com.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JOptionPane;

@RestController
public class ServerController {
    
    @RequestMapping("/")
    public String index() {    	
    	return getServerTime();        
    }
    
    /**
     * Method to get UTC server time and return as a response.
     * 
     * @return date formatted in UTC timezone and as a String
     */
    private String getServerTime() {    	
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
		df.setTimeZone(tz);	    	
    	return df.format(new Date());
    }    
}