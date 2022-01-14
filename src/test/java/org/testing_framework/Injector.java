package org.testing_framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.open_weather_DTO.OpenWeatherDTO;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Injector {

    public static OpenWeatherDTO injectDTO(String URL) {
        ObjectMapper mapper = new ObjectMapper();
        OpenWeatherDTO openWeatherDTO = new OpenWeatherDTO();
        try {
            openWeatherDTO = mapper.readValue(new URL(URL), OpenWeatherDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return openWeatherDTO;
    }

    public static OpenWeatherDTO injectFileDTO(String path) {
        ObjectMapper mapper = new ObjectMapper();
        OpenWeatherDTO openWeatherDTO = new OpenWeatherDTO();
        try {
            openWeatherDTO = mapper.readValue(new File(path), OpenWeatherDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return openWeatherDTO;
    }
}