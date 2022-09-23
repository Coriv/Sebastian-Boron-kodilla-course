import com.kodilla.sudoku.SudokuBoard;
import org.junit.jupiter.api.Test;

public class SudokuTestSuite {

    @Test
    void deepCloneBoardTest() throws CloneNotSupportedException {
        SudokuBoard sudokuBoard = new SudokuBoard();

        System.out.println(sudokuBoard);

        System.out.println("\n copy :: \n");
        SudokuBoard deepCopy = sudokuBoard.deepCopy();
        System.out.println(deepCopy);

        System.out.println();
        System.out.println("TEST~Y!");

        sudokuBoard.setValueOnBoard(1,1,8);
        System.out.println(sudokuBoard);

        System.out.println(deepCopy);
         deepCopy.setValueOnBoard( 9,9,9);

        System.out.println(sudokuBoard);
        System.out.println(deepCopy);
    }
}

