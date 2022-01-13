package org.testing_framework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.open_weather_DTO.OpenWeatherDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
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
        assertEquals(200, openWeatherDTO.getStatusCode());
    }

    @Test
    @DisplayName("test")
    void testWeather() {

        System.out.println(openWeatherDTO.getWeather().get(0).getMain());
    }

    @Test
    @DisplayName("tesBase")
    void tesBase() {

        System.out.println(openWeatherDTO.getBase());
    }

    @Test
    @DisplayName("tesBase")
    void testMase() {

        System.out.println(openWeatherDTO.getMain().getHumidity());
    }

    @Test
    @DisplayName("tesBase")
    void testcloud() {

        System.out.println(openWeatherDTO.getClouds().getAll());
    }

    @Test
    @DisplayName("tesBase")
    void testrain() {

        if(openWeatherDTO.getRain() != null){
        System.out.println(openWeatherDTO.getRain().getJsonMember1h());
    } else {
            System.out.println("whooops");
        }}

}
