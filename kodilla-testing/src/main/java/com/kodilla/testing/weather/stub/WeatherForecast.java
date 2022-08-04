package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast    {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String, Double> temperature: this.temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double averageTemp(){
        double sumTemp = 0.0;
        for(Map.Entry<String, Double> temperature : this.temperatures.getTemperatures().entrySet()){
            sumTemp += temperature.getValue();
        }
        double averageTemp = sumTemp/this.temperatures.getTemperatures().size();
        return averageTemp;
    }

    public double median(){
        double[] array = new double[temperatures.getTemperatures().size()];
        double mediana;
        int i =0;
        for(Map.Entry<String, Double> map : temperatures.getTemperatures().entrySet()){
            array[i] = map.getValue();
            i++;
        }
        Arrays.sort(array);
        if(array.length % 2 == 0){
            mediana = (array[(array.length/2)-1] + array[array.length/2])/2;
        }else
            mediana = array[(array.length)/2];

        for(int j=0; j< array.length; j++){
        System.out.println(array[j]);}
        return mediana;
    }
}
