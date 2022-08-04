package com.kodilla.good.patterns.challenges.movieStore;

import java.util.List;
import java.util.Map;

public class MovieStoreRunner {
    public static void main(String[] args) {
        MovieStore ms = new MovieStore();
        Map<String, List<String>> mapToIterate = ms.getMovies();

       mapToIterate.entrySet().stream()
               .map(Map.Entry::getValue)
               .flatMap(n -> n.stream())
               .forEach(n -> System.out.print(n+"! "));
    }
}
