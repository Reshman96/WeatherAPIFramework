package org.testing_framework;

import org.junit.jupiter.api.*;
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

    @Nested
    @DisplayName("Valid Input Checks")
    static class validityChecks{
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
        @DisplayName("Rain in MM if raining")
        void rainInMMIfRaining(OpenWeatherDTO dto) {
            if (dto.getRain() != null) {
                if (dto.getRain().rainWithinBounds()) Assertions.assertTrue(dto.getRain().rainWithinBounds());
                else System.out.println("Rainfall amount is out of bounds");
                System.out.println("Current rainfall in mm is: " + dto.getRain().getRainInMM());
            } else {
                System.out.println("Is not raining");
            }
        }

        @ParameterizedTest
        @MethodSource("getDTOS")
        @DisplayName("Valid cloud percentage if cloudy")
        void validCloudPercentageIfCloudy(OpenWeatherDTO dto) {
            if (dto.getClouds() != null) {
                if (dto.getClouds().cloudPercentageWithinBounds()) Assertions.assertTrue(dto.getClouds().cloudPercentageWithinBounds());
                else System.out.println("Cloud percentage is out of bounds");
                System.out.println("Cloud in percentage is: " + dto.getClouds().getPercentage());
            } else {
                System.out.println("Is not cloudy");
            }
        }

        @ParameterizedTest
        @MethodSource("getDTOS")
        @DisplayName("Sunrise and sunset are within a day")
        void sunriseAndSunsetWithinADay(OpenWeatherDTO dto) {
            Assertions.assertTrue(dto.getSys().sysSunriseSunsetDifferenceWithinADay());
        }
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
    @DisplayName("Creating DTOS with different units")
    void creatingDTOSWithDifferentUnits(OpenWeatherDTO dto, String unit) {
        System.out.println(dto.getMain().getTemp());
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
    @DisplayName("Creating DTOS with different location input types")
    void creatingDTOSWithDifferentLocationTypes(OpenWeatherDTO dto) {
        System.out.println(dto.getName());
    }
}
