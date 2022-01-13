package org.testing_framework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.open_weather_DTO.OpenWeatherDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testing_framework.ConnectionManager.getStatusCode;

public class FrameworkTests {
    OpenWeatherDTO openWeatherDTO;

    @BeforeEach
    void setup() {
        openWeatherDTO = Injector.injectDTO(ConnectionManager.getConnectionWithID("london"));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200() {
        assertEquals(200, getStatusCode());
    }
}
