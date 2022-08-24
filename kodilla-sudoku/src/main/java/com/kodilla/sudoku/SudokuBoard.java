package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {

    private List<SudokuRow> boardRowList = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            boardRowList.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getBoardRowList() {
        return boardRowList;
    }

    @Override
    public String toString() {
        String board = "";

        for(int i = 0; i < boardRowList.size(); i++) {
            board += "|_";
            for (int j =0 ; j < boardRowList.size(); j++) {
                if (boardRowList.get(i).getFieldsOnRowList().get(j).getValue() == SudokuElement.EMPTY) {
                    board += " ";
                } else {
                    board += boardRowList.get(i).getFieldsOnRowList().get(j).getValue();
                }
                board += "|_";
            }
            board += "\n";
        }
        return board;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard cloneBoard = super.clone();
        cloneBoard.boardRowList = new ArrayList<>();
        for(SudokuRow sudokuRow : boardRowList) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement se : clonedRow.getFieldsOnRowList()) {
                    se.setValue(sudokuRow.getFieldsOnRowList().get(clonedRow.getFieldsOnRowList().indexOf(se)).getValue());
            }
            cloneBoard.getBoardRowList().add(clonedRow);
        }
        return cloneBoard;
    }
}
