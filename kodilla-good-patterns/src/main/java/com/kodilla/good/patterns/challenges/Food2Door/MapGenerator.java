package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.*;

public class MapGenerator {

    public static Map<String, Integer> mapGenerator() {
        List<String> products = Arrays.asList("Bread", "Beer", "Tomato");

        Map<String, Integer> preparedMap = new HashMap<>();
        int randProd = new Random().nextInt(3);
        int randQuan = new Random().nextInt(1000);

        preparedMap.put(products.get(randProd), randQuan);
        preparedMap.put(products.get(randProd), randQuan);

        return preparedMap;
    }
}
