import com.kodilla.sudoku.DataInput;
import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuGame;
import org.junit.jupiter.api.Test;

public class SudokuTestSuite {

    @Test
    void deepCloneBoardTest() throws CloneNotSupportedException {
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuGame.sedData2(sudokuBoard);

        System.out.println(sudokuBoard);

        System.out.println("\n copy :: \n");
        SudokuBoard deepCopy = sudokuBoard.deepCopy();
        System.out.println(deepCopy);

        System.out.println();
        System.out.println("TEST~Y!");

        DataInput.setValueOnBoard(sudokuBoard,1,1,8);
        System.out.println(sudokuBoard);



        System.out.println(deepCopy);
        DataInput.setValueOnBoard(deepCopy, 9,9,9);

        System.out.println(sudokuBoard);
        System.out.println(deepCopy);



    }
}

