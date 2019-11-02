package com.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.server.ClientRequest;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class ClientGui extends JFrame {

private static final long serialVersionUID = 3394233326037049893L;
private JFrame mainFrame;
private JLabel headerLabel;
private JLabel statusLabel;
private JPanel controlPanel;
private String url;
private ClientRequest clientRequest;

	public ClientGui() {
		setUrl(JOptionPane.showInputDialog("Input connection URL Hint: http://localhost:8080"));
		try {
			clientRequest = new ClientRequest(getUrl());
			if(clientRequest.isConnected()) {
				guiSetup();
				actionButtonSetup();
				}
			} catch (IOException e) {			
			JOptionPane.showMessageDialog(null, "There was an issue connecting to the server.  Make sure server is running.");
		}
		
	}
	
	/**
	 * Method to initialize and display the GUI
	 */
    private void guiSetup(){
	      mainFrame = new JFrame("Perspecta Client");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);    
	      statusLabel.setSize(350,100);

	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
    
	/**
	 * Method to setup button to request server time. 
	 */
	private void actionButtonSetup(){
	      headerLabel.setText("Click submit to get the server time."); 
	      JButton submit = new JButton("Submit");	      
	      submit.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	
	        	 if(clientRequest.isConnected()) {
				statusLabel.setText(clientRequest.getServerTime());	        	 
	         }else
	        	 statusLabel.setText("Cannot connect to server.");
	        	 }
	      });	     
	      controlPanel.add(submit); 
	      mainFrame.setVisible(true);  
	   }		

	//Getters and Setters
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}
