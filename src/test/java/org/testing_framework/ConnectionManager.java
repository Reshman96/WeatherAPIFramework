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

    public static String getConnectionWithID(String location){
        return BASEURL + "?q=" + location + "&appid=" + APIKEY;
    }

    public static String getConnectionWithCoordinates(String latitude, String longitude){
        return BASEURL + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + APIKEY;
    }

    public static String getConnectionWithZIP(String zip){
        return BASEURL + "?zip=" + zip + "&appid=" + APIKEY;
    }

    public static int getStatusCode(){
        return getResponse().statusCode();
    }

    private static HttpResponse<String> getResponse(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASEURL + "?q=london&appid=" + APIKEY))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

    public Map<String, List<String>> getHeadersMap(){
        return getResponse().headers().map();
    }

    public String getURL(){ return BASEURL + endPoint;}
}
