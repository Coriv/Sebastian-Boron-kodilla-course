package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer> evenList = new ArrayList<>();

        for(int i=0; i < numbers.size(); i++){
        if(numbers.get(i) >= 2 && numbers.get(i) % 2 == 0 )
            evenList.add(numbers.get(i));
        }
        return evenList;
        }
}
