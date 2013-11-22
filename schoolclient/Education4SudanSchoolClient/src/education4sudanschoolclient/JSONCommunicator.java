/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package education4sudanschoolclient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugh
 */
public class JSONCommunicator {
    public static final String ATTENDANCE_ADDRESS = "http://localhost:3000/attend";
    public static final String CURRICULUM_ADDRESS = "http://localhost:3000/curric";
    public static final String REQUEST_ADDRESS = "http://localhost:3000/reques";
    public static final String TEACHERS_ADDRESS = "http://localhost:3000/teach";
    public static final String INVENTORY_ADDRESS = "http://locahost:3000/invent";
    public static final String NOTIFICATIONS_ADDRESS = "http://localhost:3000/notif";
    public static final String REQUEST_STATUS_ADDRESS = "http://localhost:3000/request_status";
    
    public static void sendJson(String address, String Json) throws ConnectException, MalformedURLException {
        
        URL url = new URL(address);
        HttpURLConnection urlConnection;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
        } catch (IOException ex) {
            Logger.getLogger(JSONCommunicator.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectException("Unable to connect to server.");
        }
        
        
        byte[] rawPostData;
	if (Json == null) {
            throw new IllegalArgumentException("Json cannot be null.");
        }
        rawPostData = Json.getBytes();
        
        urlConnection.setRequestProperty("Content-Length", String.valueOf(rawPostData.length));
        
        // Write postData to connection OutputStream
        try (OutputStream out = urlConnection.getOutputStream()) {
            out.write(rawPostData);
            int responseCode = urlConnection.getResponseCode();
            if (responseCode != 200) {
                throw new ConnectException("Connection failed. Response code - " + String.valueOf(responseCode) + ".");
            }
        } catch (IOException e) {
            if (e.getMessage() == null) {
                throw new ConnectException("Failed to send data to server.");
            } else {
                throw new ConnectException("Failed to send data to server. Failed with message: " + e.getMessage());
            }
        }
        
        urlConnection.disconnect();
    }
    
    public static String requestJson(String address) throws MalformedURLException, ConnectException {
        URL url = new URL(address);
        HttpURLConnection urlConnection;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
        } catch (IOException ex) {
            Logger.getLogger(JSONCommunicator.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectException("Unable to connect to server.");
        }

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null) { 
                builder.append(line); 
            }
        }
        catch (IOException e) {
            throw new ConnectException("Couldn't read data from server.");
        }

        return builder.toString();
    }
}
