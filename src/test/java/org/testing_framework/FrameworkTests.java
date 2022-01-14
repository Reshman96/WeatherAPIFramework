package org.testing_framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.open_weather_DTO.OpenWeatherDTO;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrameworkTests {
    OpenWeatherDTO openWeatherDTO;
    String location = "tartous";
    // A city that usually rains: "volda"

    @BeforeEach
    void setup() {
        openWeatherDTO = Injector.injectDTO(ConnectionManager.getConnection(location));
    }

    @Test
    @DisplayName("Status code is 200")
    void statusCodeIs200() {
        Assertions.assertEquals(200, ConnectionManager.getStatusCode());
    }

    @Test
    @DisplayName("Rain in MM if raining")
    void rainInMMIfRaining() {
        if (openWeatherDTO.getRain() != null) {
            Assertions.assertTrue(openWeatherDTO.getRain().rainWithinBounds());
            System.out.println("Current rainfall in mm is: " + openWeatherDTO.getRain().getRainInMM());
        } else {
            System.out.println("Is not raining");
        }
    }

    @Test
    @DisplayName("Valid cloud percentage if cloudy")
    void validCloudPercentageIfCloudy() {
        if (openWeatherDTO.getClouds() != null) {
            Assertions.assertTrue(openWeatherDTO.getClouds().cloudPercentageWithinBounds());
            System.out.println("Cloud in percentage is: " + openWeatherDTO.getClouds().getPercentage());
        } else {
            System.out.println("Is not cloudy");
        }
    }

    @Test
    @DisplayName("Sunrise and sunset are within a day")
    void sunriseAndSunsetWithinADay() {
        Assertions.assertTrue(openWeatherDTO.getSys().sysSunriseSunsetDifferenceWithinADay());
    }

    // add tempToBounds test method
    // run with default, metric, imperial



    // add weatherMainIsValid test



    public static Stream<Arguments> getDTOS(){
        String location = "london";
        String path = "src/test/resources/IncorrectJSONResponse.JSON";
        OpenWeatherDTO openWeatherDTOUnit = Injector.injectDTO(ConnectionManager.getConnection(location));
        OpenWeatherDTO badOpenWeatherDTO = Injector.injectFileDTO(path);
        return Stream.of(Arguments.arguments(openWeatherDTOUnit),
                Arguments.arguments(badOpenWeatherDTO));
    }

    @ParameterizedTest
    @MethodSource("getDTOS")
    @DisplayName("testBase")
    void testRain(OpenWeatherDTO dto) {
        if(dto.getRain()!=null) System.out.println("test");
    }

    public static Stream<Arguments> getDTOSUnit(){
        String location = "london";
        OpenWeatherDTO openWeatherDTOUnit = Injector.injectDTO(ConnectionManager.getConnection(location));
        OpenWeatherDTO openWeatherDTOImperial = Injector.injectDTO(ConnectionManager.getConnection(location, "imperial"));
        OpenWeatherDTO openWeatherDTOMetric = Injector.injectDTO(ConnectionManager.getConnection(location, "metric"));

        return Stream.of(Arguments.arguments(openWeatherDTOUnit,""),
                Arguments.arguments(openWeatherDTOImperial,"imperial"),
                Arguments.arguments(openWeatherDTOMetric,"metric"));
    }

    @ParameterizedTest
    @MethodSource("getDTOSUnit")
    @DisplayName("Test name")
    void testName(OpenWeatherDTO dto, String unit) {
        System.out.println(dto.getMain().getTemp());
        System.out.println(ConnectionManager.getType());
        assertTrue(dto.getMain().tempWithinBounds(unit));
    }


    public static Stream<Arguments> getDTOSLocations(){
        String location = "london";
        double latitude = 48.8566;
        double longitude = 2.3522;
        int zip = 10022;
        OpenWeatherDTO openWeatherDTOUnit = Injector.injectDTO(ConnectionManager.getConnection(location));
        OpenWeatherDTO openWeatherDTOImperial = Injector.injectDTO(ConnectionManager.getConnection(latitude, longitude));
        OpenWeatherDTO openWeatherDTOMetric = Injector.injectDTO(ConnectionManager.getConnection(zip));

        return Stream.of(Arguments.arguments(openWeatherDTOUnit),
                Arguments.arguments(openWeatherDTOImperial),
                Arguments.arguments(openWeatherDTOMetric));
    }

    @ParameterizedTest
    @MethodSource("getDTOSLocations")
    @DisplayName("Test name")
    void testName(OpenWeatherDTO dto) {
        System.out.println(dto.getName());
    }
}
