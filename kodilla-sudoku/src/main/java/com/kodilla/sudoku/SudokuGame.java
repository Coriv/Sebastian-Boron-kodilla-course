package com.kodilla.sudoku;
import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args)  {

        SudokuBoard sudokuBoard = new SudokuBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter data or write 'SUDOKU' to find a solution.");
        String x = "";
        int xx;

        while (!x.equals("SUDOKU")) {
            x = scanner.next();
            if (x.length() % 5 == 0) {

                xx = Integer.parseInt(x, 0, 1, Character.MAX_RADIX);
                int y = Integer.parseInt(x, 2, 3, Character.MAX_RADIX);
                int value = Integer.parseInt(x, 4, 5, Character.MAX_RADIX);

                if (xx > 0 && xx <= 9 && y > 0 && y <= 9 && value > 0 && value <= 9) {
                    sudokuBoard.setValueOnBoard(xx, y, value);
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
        Resolver resolver = new Resolver();

        boolean isResolved = false;
        while(!isResolved) {
        try {
            resolver.resolve(sudokuBoard);
            System.out.println("RESOLVED : \n" + sudokuBoard);
            isResolved = true;
        } catch (NoAnyOptionException e) {
            BackTrack backTrack = Resolver.backTracksList1.get(Resolver.backTracksList1.size() - 1);
            System.out.println("COFAMY");
            sudokuBoard = backTrack.sudokuBoard();
            int row = backTrack.indexRow();
            int ele = backTrack.indexColumn();
            int val = backTrack.filledValue();

            sudokuBoard.getBoardRowList().get(row).getFieldsOnRowList().get(ele).getListOfPossibilities().remove((Integer) val);

            Resolver.backTracksList1.remove(backTrack);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    } }
}