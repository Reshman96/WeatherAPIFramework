package org.testing_framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.open_weather_DTO.OpenWeatherDTO;

public class Injector {

    public static OpenWeatherDTO injectDTO(String URL) {
        ObjectMapper mapper = new ObjectMapper();
        OpenWeatherDTO openWeatherDTO = new OpenWeatherDTO();
        try {
            openWeatherDTO = mapper.readValue(URL, openWeatherDTO.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return openWeatherDTO;
    }
}