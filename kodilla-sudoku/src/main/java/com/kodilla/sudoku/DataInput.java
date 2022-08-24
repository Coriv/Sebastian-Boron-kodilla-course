package com.kodilla.sudoku;

import java.util.Scanner;

public class DataInput {

    Scanner input = new Scanner(System.in);
    String data = input.next();
    int x = input.nextInt();
    int y = input.nextInt();

    int value = input.nextInt();


    public static void setValueOnBoard(SudokuBoard sudokuBoard, int x, int y, int value) {
        SudokuRow sudokuRow = sudokuBoard.getBoardRowList().get(x-1);
        SudokuElement sudokuElement = sudokuRow.getFieldsOnRowList().get(y-1);
        sudokuElement.setValue(value);
        System.out.println(sudokuBoard);
    }
}
