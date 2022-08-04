package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@DisplayName("Test Suite for the Weather Forecast")
@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void beforeEvryTest(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }

    @DisplayName("Test of quantity sensor")
    @Test
    void testCalculateForecastWithMock() {
        //Given

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName("Test of average temperature calculation")
    @Test
    void testCalculateAverageTempWithMock() {

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double average = weatherForecast.averageTemp();
        System.out.println(temperaturesMock.getTemperatures().size());

    Assertions.assertEquals(25.56, average );
    }

    @DisplayName("Test od median calculation")
    @Test
    void testCalculateMedian(){
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double result = weatherForecast.median();

        Assertions.assertEquals(25.5, result);
    }

}