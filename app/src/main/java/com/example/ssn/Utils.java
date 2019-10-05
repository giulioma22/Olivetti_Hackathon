package com.example.ssn;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class Utils {
    static String fbKey = "EAAFa7O0P5AkBAHVDs5siDoHToBXB8cmsSUePwchB42DzlD2wCVVzADv2Hs8EsLzONIhbVAUgiOVWUrl4M0UZCmZCNAv0J5LTNfZARUZCBQeRkEP4VogaZBP4piblwloUqavIhmokz20YpKZAqvKyTU7sCWfZAfDpz9ZBuanXsAkobwIgis4i09sHzwsYMvna3XHJhqvWgeDSbQZDZD";

    public static ProductBatch getProducts(String filename){
        //TODO genrate or fetch from file
        return new ProductBatch();
    }


    public static void PostFacebookRequest(String Message){

        try {
            URL url = new URL("https://graph.facebook.com/104577460953350/feed");

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            try {
                urlConnection.getHeaderField("Authorization");
                urlConnection.addRequestProperty("Authorization", fbKey);
                urlConnection.getResponseCode();

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                System.out.println(in);

            } finally {
                urlConnection.disconnect();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
