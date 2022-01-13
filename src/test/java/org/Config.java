package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties config = new Properties();

    static {
        try {
            config.load(new BufferedReader(new FileReader("src/test/resources/config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAPIKey(){
        return config.getProperty("APIKEY");
    }

    public static String getBaseURL(){
        return config.getProperty("BASEURL");
    }

    public static String getUnit(){
        return config.getProperty("UNIT");
    }
}
