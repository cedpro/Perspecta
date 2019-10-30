package com.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientRequest {
	
	private String requestUrl;
	private boolean isConnected = false;
	private String serverTime;
	
	public ClientRequest(String url) throws IOException {
		setRequestUrl(url);
		sendGet();
	}
	/**Method to send request to local server for UTC time
	 * 
	 * @throws IOException
	 */
	private void sendGet() throws IOException  {
       
		String url = getRequestUrl();

        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");
        
        int responseCode = httpClient.getResponseCode();
        if(responseCode==200) {
        	setConnected(true);
        }      
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }          
            setServerTime(response.toString());
        }
    }

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}

}
