package org.testing_framework;

import org.Config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ConnectionManager {
    private static final String BASEURL = Config.getBaseURL();
    private static final String APIKEY = Config.getAPIKey();
    private static String endPoint;
    private static String URL;
    private static String type;

    public static String getConnection(String location){
        URL = BASEURL + "?q=" + location + "&appid=";
        return URL + APIKEY;
    }

    public static String getConnection(String location, String unit){
        URL = BASEURL + "?q=" + location + "&units=" + unit + "&appid=";
        return URL + APIKEY;
    }

    public static String getConnection(double latitude, double longitude){
        URL = BASEURL + "?lat=" + latitude + "&lon=" + longitude + "&appid=";
        return URL + APIKEY;
    }

    public static String getConnection(double latitude, double longitude, String unit){
        URL = BASEURL + "?lat=" + latitude + "&lon=" + longitude + "&units=" + unit + "&appid=";
        return URL + APIKEY;
    }

    public static String getConnection(int zip){
        URL = BASEURL + "?zip=" + zip + "&appid=";
        return URL + APIKEY;
    }

    public static String getConnection(int zip, String unit){
        URL = BASEURL + "?zip=" + zip + "&units=" + unit + "&appid=";
        return URL + APIKEY;
    }

    public static int getStatusCode(){
        return getResponse().statusCode();
    }

    private static HttpResponse<String> getResponse(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + APIKEY))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }
    public static Map<String, List<String>> getHeadersMap(){
        return getResponse().headers().map();
    }

    public static String getURL(){ return URL;}
}
