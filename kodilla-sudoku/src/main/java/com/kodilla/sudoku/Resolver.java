package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class Resolver {
    private int number;
    static List<BackTrack> backTracksList1 = new ArrayList<>();
    int progress = 0;
    public boolean resolve(SudokuBoard sudokuBoard) throws NoAnyOptionException, CloneNotSupportedException {
        Set<Integer> usedValues;

        do {
            for (SudokuRow sudokuRow : sudokuBoard.getBoardRowList()) {

                for (SudokuElement element : sudokuRow.getFieldsOnRowList()) {
                    usedValues = new HashSet<>();

                    int elementIndex = sudokuRow.getFieldsOnRowList().indexOf(element);
                    int rowIndex = sudokuBoard.getBoardRowList().indexOf(sudokuRow);

                    int value = element.getValue();
                    if (value != SudokuElement.EMPTY) {
                        continue;
                    }

                    for (SudokuElement insideRowElement : sudokuRow.getFieldsOnRowList()) {

                        Integer valueToRemoveRow = insideRowElement.getValue();
                        usedValues.add(valueToRemoveRow);
                        element.getListOfPossibilities().remove(valueToRemoveRow);
                    }

                    for (SudokuElement se : createColumn(elementIndex, sudokuBoard)) {
                        Integer valueToRemoveCol = se.getValue();
                        usedValues.add(valueToRemoveCol);
                        element.getListOfPossibilities().remove(valueToRemoveCol);
                    }

                    List<SudokuElement> squares = createSquare3x3(sudokuBoard, rowIndex, elementIndex);

                    for (SudokuElement se : squares) {
                        Integer valueToRemoveSq = se.getValue();
                        usedValues.add(valueToRemoveSq);
                        element.getListOfPossibilities().remove(valueToRemoveSq);
                    }

                    Set<SudokuElement> neighbourFields = new HashSet<>();
                    neighbourFields.addAll(sudokuRow.getFieldsOnRowList());
                    neighbourFields.addAll(createColumn(elementIndex, sudokuBoard));
                    neighbourFields.addAll(squares);
                    neighbourFields.remove(element);

                    if (element.getListOfPossibilities().size() == 1 ) {
                        element.setValue(element.getListOfPossibilities().get(0));
                    }
                    if (isPossibleSomewhereElse(element, neighbourFields)) {
                        element.setValue(number);
                    }
                    if(element.getListOfPossibilities().size() == 0) {
                        throw new NoAnyOptionException();

                    }
                }
            }
        } while (isSolved(sudokuBoard));
        return true;
    }

    boolean isSolved(SudokuBoard sudokuBoard) throws CloneNotSupportedException, NoAnyOptionException{
        boolean isSolved = false;
        int emptyFields = 0;
        List<SudokuElement> fullList = sudokuBoard.getBoardRowList().stream()
                .flatMap(n -> n.getFieldsOnRowList().stream())
                .collect(Collectors.toList());

        for (SudokuElement se : fullList) {
            if (se.getValue() == SudokuElement.EMPTY) {
                isSolved = true;
                emptyFields++;
            }
        }
        if(progress == emptyFields && emptyFields != 0) {
            predictSomething(sudokuBoard);
        }
        progress = emptyFields;
        return isSolved;
    }
    public void predictSomething(SudokuBoard sudokuBoard) throws CloneNotSupportedException, NoAnyOptionException{

        SudokuElement sudokuElement;
        int randomRow;
        int randomField;

        do {
            randomRow = (int) (9 * Math.random());
            randomField = (int) (9 * Math.random());

            SudokuRow sudokuRow = sudokuBoard.getBoardRowList().get(randomRow);
            sudokuElement = sudokuRow.getFieldsOnRowList().get(randomField);
        } while (sudokuElement.getValue() != SudokuElement.EMPTY);

            int randomIndex = (int) (sudokuElement.getListOfPossibilities().size() * Math.random());
            Integer valueToFill = sudokuElement.getListOfPossibilities().get(randomIndex);

            BackTrack backTrack1 = new BackTrack(sudokuBoard.deepCopy(), randomRow, randomField, valueToFill);
            backTracksList1.add(backTrack1);

            sudokuElement.setValue(valueToFill);

        }

    boolean isPossibleSomewhereElse(SudokuElement sudokuElement, Set<SudokuElement> sudoku) {
        List<Integer> possibilities = new ArrayList<>(sudokuElement.getListOfPossibilities());
        boolean doesItOccur = false;

        List<Integer> dd = sudoku.stream()
                .flatMap(n -> n.getListOfPossibilities().stream())
                .collect(Collectors.toList());

        possibilities.removeAll(dd);
        if (possibilities.size() ==1) {
            doesItOccur = true;
            number = possibilities.get(0);
        }

        return doesItOccur;
    }

    public List<SudokuElement> createColumn(int index, SudokuBoard sudokuBoard) {
        List<SudokuElement> sudokuColumn = new ArrayList<>();

        for (int j = 0; j < 9; j++) {
            SudokuElement e = sudokuBoard.getBoardRowList().get(j).getFieldsOnRowList().get(index);
            sudokuColumn.add(e);
        }
        return sudokuColumn;
    }

    public List<SudokuElement> createSquare3x3(SudokuBoard sb, int indexRow, int indexElement) {
        List<SudokuElement> squareList = new ArrayList<>();

        if (indexRow < 3 && indexElement < 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }}  return squareList;

        } else if (3 <= indexRow && indexRow < 6 && indexElement < 3) {
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }}return squareList;

        } else if (6 <= indexRow && indexRow < 9 && indexElement < 3) {
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }} return squareList;

        } else if (indexRow < 3 && 3 <= indexElement && indexElement < 6) {
            for (int i = 0; i < 3; i++) {
                for (int j = 3; j < 6; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }} return squareList;

        } else if (indexRow < 3 && 6 <= indexElement && indexElement < 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 6; j < 9; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }} return squareList;

        } else if (3 <= indexRow && indexRow < 6 && 3 <= indexElement && indexElement < 6) {
            for (int i = 3; i < 6; i++) {
                for (int j = 3; j < 6; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }} return squareList;

        } else if (3 <= indexRow && indexRow < 6 && 6 <= indexElement && indexElement < 9) {
            for (int i = 3; i < 6; i++) {
                for (int j = 6; j < 9; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }} return squareList;

        } else if (6 <= indexRow && indexRow < 9 && 3 <= indexElement && indexElement < 6) {
            for (int i = 6; i < 9; i++) {
                for (int j = 3; j < 6; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }} return squareList;

        } else if (6 <= indexRow && indexRow <9 && 6 <= indexElement && indexElement <9){
            for (int i = 6; i < 9; i++) {
                for (int j = 6; j < 9; j++) {
                    SudokuElement se = sb.getBoardRowList().get(i).getFieldsOnRowList().get(j);
                    squareList.add(se);
                }} return squareList;
        }
        return null;
    }
}
