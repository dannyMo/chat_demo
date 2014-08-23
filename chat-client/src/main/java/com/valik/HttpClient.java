/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valik;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Валик
 */
public class HttpClient {
    
    private HttpClient() {        
    }
    private static HttpClient self = new HttpClient();
    public static HttpClient getInstnce() {
        return self;
    }
    
    public String sendData(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;
        String inputLine = null;
        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {

            throw new RuntimeException(e);
            //return null;

        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return inputLine;
    }
}
