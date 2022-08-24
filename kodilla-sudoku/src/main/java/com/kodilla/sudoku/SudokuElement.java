package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement {

    public final static int EMPTY = -1;
    private int value = EMPTY;
    private List<Integer> listOfPossibilities;

    public SudokuElement() {
        listOfPossibilities = new ArrayList<>(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getListOfPossibilities() {
        return listOfPossibilities;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "|_}";
    }
}
