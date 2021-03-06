package com.example.yang_deng.monashfriendfindertest.RestHttpService;

/**
 * Created by Yang-Deng on 22/4/17.
 */

import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestHttpClient {
    private static final String BASE_URI = "http://10.0.0.24:8080/TESTFOR5046ASS/webresources";

    public static String GetStuProfileByEmail(String Email) {
        final String methodPath = "/test.studentprofile/findByMonashEmail/";
        //initialise
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        //Making HTTP request
        try {
            url = new URL(BASE_URI + methodPath + Email);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000); //set the connection method to GET
            conn.setRequestMethod("GET");
            //add http headers to set your response type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json"); //Read the response
            Scanner inStream = new Scanner(conn.getInputStream()); //read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine(); }
        } catch (Exception e) { e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }

    public static String GetAllStuProfile() {
        final String methodPath = "/test.studentprofile/";
        //initialise
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";
        //Making HTTP request
        try {
            url = new URL(BASE_URI + methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();
            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000); //set the connection method to GET
            conn.setRequestMethod("GET");
            //add http headers to set your response type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json"); //Read the response
            Scanner inStream = new Scanner(conn.getInputStream()); //read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine(); }
        } catch (Exception e) { e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }
}

