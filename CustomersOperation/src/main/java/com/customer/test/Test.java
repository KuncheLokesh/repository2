package com.customer.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	public static void main(String[] args) {
		try {
            // Create URL object
            URL url = new URL("https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp");

            // Create HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print response
            System.out.println("Response: " + response.toString());

            // Close connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
