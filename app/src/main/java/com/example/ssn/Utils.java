package com.example.ssn;


import android.net.Uri;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class Utils {
    static String fbKey = "Bearer EAAFa7O0P5AkBAHVDs5siDoHToBXB8cmsSUePwchB42DzlD2wCVVzADv2Hs8EsLzONIhbVAUgiOVWUrl4M0UZCmZCNAv0J5LTNfZARUZCBQeRkEP4VogaZBP4piblwloUqavIhmokz20YpKZAqvKyTU7sCWfZAfDpz9ZBuanXsAkobwIgis4i09sHzwsYMvna3XHJhqvWgeDSbQZDZD";

    public static ProductBatch getProducts(String filename){
        //TODO generate or fetch from file
        return new ProductBatch();
    }


    public static void PostFacebookRequest(String message){
        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("https")
                .authority("graph.facebook.com")
                .appendPath("104577460953350")
                .appendPath("feed");
        Uri uri = uriBuilder.build();

        HttpURLConnection client = null;
        try {
            URL url = new URL(uri.toString());

            client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("POST");
            client.setRequestProperty("Authorization",fbKey);
            client.setRequestProperty("message", message);
            client.setDoOutput(true);
            client.connect();
            System.out.println("Sending" +client.getURL());
            System.out.println("Response" +client.getResponseCode() + client.getResponseMessage());


            OutputStream outputPost = new BufferedOutputStream(client.getOutputStream());
            System.out.println(outputPost.toString());
            outputPost.flush();
            outputPost.close();




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(client != null) // Make sure the connection is not null.
                client.disconnect();
        }


    }




}
