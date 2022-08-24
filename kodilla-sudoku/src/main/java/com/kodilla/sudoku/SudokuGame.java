package com.kodilla.sudoku;

import java.util.Scanner;

import static com.kodilla.sudoku.DataInput.*;

public class SudokuGame {

    public static void main(String[] args) throws Exception {

        SudokuBoard sudokuBoard = new SudokuBoard();
        Scanner scanner = new Scanner(System.in);

       // sedData2(sudokuBoard);
        suducuData(sudokuBoard);
        String x = "";
        int xx;

        while (!x.equals("SUDOKU")) {
            x = scanner.next();
            //int xx = Integer.parseInt(x);
            if (x.length() % 5 == 0) {

                xx = Integer.parseInt(x, 0, 1, Character.MAX_RADIX);
                int y = Integer.parseInt(x, 2, 3, Character.MAX_RADIX);
                int value = Integer.parseInt(x, 4, 5, Character.MAX_RADIX);

                if (xx > 0 && xx <= 9 && y > 0 && y <= 9 && value > 0 && value <= 9) {
                    DataInput.setValueOnBoard(sudokuBoard, xx, y, value);
                } else {
                    System.out.println("You can select only from 1 to 9 numbers.");
                }
            } else if (x.equals("SUDOKU")) {
                System.out.println("Starting looking for a resolve");
                break;
            } else {
                System.out.println("Input correct data. It's mean : x,y,v as numbers form 1 to 9\n" +
                        "where x is the row number,\n y is the column number\n and v is the value you want to put inside");
            }
        }

        new Resolver().resolve(sudokuBoard);
        System.out.println("RESOLVED : \n" + sudokuBoard);
    }

    public static SudokuBoard startTheGame() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        System.out.println(sudokuBoard);
        return sudokuBoard;
    }


    static void suducuData(SudokuBoard sudokuBoard) {
        DataInput.setValueOnBoard(sudokuBoard, 1, 2, 2);
        DataInput.setValueOnBoard(sudokuBoard, 1, 4, 5);
        DataInput.setValueOnBoard(sudokuBoard, 1, 6, 1);
        DataInput.setValueOnBoard(sudokuBoard, 1, 8, 9);
        DataInput.setValueOnBoard(sudokuBoard, 2, 1, 8);
        DataInput.setValueOnBoard(sudokuBoard, 2, 4, 2);
        DataInput.setValueOnBoard(sudokuBoard, 2, 6, 3);
        DataInput.setValueOnBoard(sudokuBoard, 2, 9, 6);
        DataInput.setValueOnBoard(sudokuBoard, 3, 2, 3);
        DataInput.setValueOnBoard(sudokuBoard, 3, 5, 6);
        DataInput.setValueOnBoard(sudokuBoard, 3, 8, 7);
        DataInput.setValueOnBoard(sudokuBoard, 4, 3, 1);
        DataInput.setValueOnBoard(sudokuBoard, 4, 7, 6);
        DataInput.setValueOnBoard(sudokuBoard, 5, 1, 5);
        DataInput.setValueOnBoard(sudokuBoard, 5, 2, 4);
        DataInput.setValueOnBoard(sudokuBoard, 5, 8, 1);
        DataInput.setValueOnBoard(sudokuBoard, 5, 9, 9);
        DataInput.setValueOnBoard(sudokuBoard, 6, 3, 2);
        DataInput.setValueOnBoard(sudokuBoard, 6, 7, 7);
        DataInput.setValueOnBoard(sudokuBoard, 7, 2, 9);
        DataInput.setValueOnBoard(sudokuBoard, 7, 5, 3);
        DataInput.setValueOnBoard(sudokuBoard, 7, 8, 8);
        DataInput.setValueOnBoard(sudokuBoard, 8, 1, 2);
        DataInput.setValueOnBoard(sudokuBoard, 8, 4, 8);
        DataInput.setValueOnBoard(sudokuBoard, 8, 6, 4);
        DataInput.setValueOnBoard(sudokuBoard, 8, 9, 7);
        DataInput.setValueOnBoard(sudokuBoard, 9, 2, 1);
        DataInput.setValueOnBoard(sudokuBoard, 9, 4, 9);
        DataInput.setValueOnBoard(sudokuBoard, 9, 6, 7);
        DataInput.setValueOnBoard(sudokuBoard, 9, 8, 6);
    }

public static void sedData2(SudokuBoard sudokuBoard) {
    DataInput.setValueOnBoard(sudokuBoard,2, 1, 1);

    setValueOnBoard(sudokuBoard,1, 2, 3);

    setValueOnBoard(sudokuBoard,2, 2, 5);

    setValueOnBoard(sudokuBoard,3, 2, 6);

    setValueOnBoard(sudokuBoard,4, 1, 6);

    setValueOnBoard(sudokuBoard,5, 3, 5);

    setValueOnBoard(sudokuBoard,6, 1, 4);

    setValueOnBoard(sudokuBoard,6, 3, 3);

    setValueOnBoard(sudokuBoard,7, 1, 3);

    setValueOnBoard(sudokuBoard,7, 3, 6);

    setValueOnBoard(sudokuBoard,9, 1, 7);

    setValueOnBoard(sudokuBoard,8, 3, 9);

    setValueOnBoard(sudokuBoard,2, 4, 8);

    setValueOnBoard(sudokuBoard,3, 4, 3);

    setValueOnBoard(sudokuBoard,1, 6, 4);

    setValueOnBoard(sudokuBoard,3, 6, 5);

    setValueOnBoard(sudokuBoard,4, 4, 2);

    setValueOnBoard(sudokuBoard,5, 4, 6);

    setValueOnBoard(sudokuBoard,5, 6, 7);

    setValueOnBoard(sudokuBoard,6, 6, 8);

    setValueOnBoard(sudokuBoard,7, 4, 4);

    setValueOnBoard(sudokuBoard,9, 4, 9);

    setValueOnBoard(sudokuBoard,7, 6, 2);

    setValueOnBoard(sudokuBoard,8, 6, 6);

    setValueOnBoard(sudokuBoard,2, 7, 4);

    setValueOnBoard(sudokuBoard,3, 7, 2);

    setValueOnBoard(sudokuBoard,1, 9, 7);

    setValueOnBoard(sudokuBoard,3, 9, 9);

    setValueOnBoard(sudokuBoard,4, 7, 5);

    setValueOnBoard(sudokuBoard,5, 7, 3);

    setValueOnBoard(sudokuBoard,4, 9, 4);

    setValueOnBoard(sudokuBoard,6, 9, 2);

    setValueOnBoard(sudokuBoard,7, 8, 7);

    setValueOnBoard(sudokuBoard,8, 8, 2);

    setValueOnBoard(sudokuBoard,9, 8, 4);

    setValueOnBoard(sudokuBoard,8, 9, 8);

}
}