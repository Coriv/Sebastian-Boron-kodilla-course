package com.kodilla.sudoku;

public class BackTrack {

    private final SudokuBoard sudokuBoard;
    private final int indexRow;
    private final int indexColumn;
    private final int filledValue;

    public BackTrack(final SudokuBoard sudokuBoard, final int indexRow, final int indexColumn, final int filledValue) {
        this.sudokuBoard = sudokuBoard;
        this.indexRow = indexRow;
        this.indexColumn = indexColumn;
        this.filledValue = filledValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public int getIndexColumn() {
        return indexColumn;
    }

    public int getFilledValue() {
        return filledValue;
    }
}
