package org.testing_framework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.open_weather_DTO.OpenWeatherDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameworkTests {
    OpenWeatherDTO openWeatherDTO;
    String location = "london";

    @BeforeEach
    void setup() {
        openWeatherDTO = Injector.injectDTO(ConnectionManager.getConnection(location));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200() {
        assertEquals(200, openWeatherDTO.getStatusCode());
    }

    @Test
    @DisplayName("testBase")
    void testRain() {
        if (openWeatherDTO.getRain() != null) {
            System.out.println(openWeatherDTO.getRain().getJsonMember1h());
        } else {
            System.out.println("whooops");
        }
    }
}
