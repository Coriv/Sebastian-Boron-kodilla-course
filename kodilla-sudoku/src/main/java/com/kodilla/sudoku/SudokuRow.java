package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuElement> fieldsOnRowList = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            fieldsOnRowList.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getFieldsOnRowList() {
        return fieldsOnRowList;
    }
}
