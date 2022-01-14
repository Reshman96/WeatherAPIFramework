package org.testing_framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.open_weather_DTO.OpenWeatherDTO;

public class FakeJSONTests {
    private ObjectMapper mapper;
    OpenWeatherDTO openWeatherDTO;
    String path = "src/test/resources/IncorrectJSONResponse.JSON";

    @BeforeEach
    void setup() {
        openWeatherDTO = Injector.injectFileDTO(path);
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200() {
        System.out.println(openWeatherDTO.getRain().rainWithinBounds());;
    }
}
