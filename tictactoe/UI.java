package tictactoe;
import java.util.Scanner;

/**
 * UI class
 */
public class UI
{

Scanner scanner;

public UI() {
    scanner = new Scanner(System.in);         
}

// Utility methods
public String getRedOrBlack(int whoseMove) {
  return (whoseMove == -1) ? "R" : "B";
}

public String getPlayerName(int whoseMove, String xName, String yName) {
  return (whoseMove == -1) ? xName : yName;
}

public boolean isLegalMove(State state, int row, int col) {
   if (row == 5) {
       if (state.getBoardCell(row, col) == 0) {
           return true;
       }
   }
   if (state.getBoardCell(row - 1, col) == 0) {
       return true;
   }
   return false;
}

// Prompt for input methods
public String promptForName(int player) {
    System.out.printf(Constants.GET_PLAYER_NAME, player);
    return scanner.next();
}

public int getMoveRow(State state, int col) {
    int row = 0;
    for (int i = Constants.BOARD_ROWS - 1; i >= 0; i--) {
        if (state.getBoardCell(i, col) == 0) {
            row = i;
            break;
        }
    }
    return row;
}

public int getMoveCol(State state, int whoseMove) {
    int col = -1;
    while (col < 0 || col > Constants.BOARD_COLUMNS - 1) {
        try {
            System.out.printf(Constants.GET_COL_MOVE, getRedOrBlack(whoseMove), getPlayerName(whoseMove, state.getRedName(), state.getBlackName()));
            col = scanner.nextInt() - 1;
        } catch (Exception e) {
            System.out.println(Constants.INVALID_ROW_OR_COLUMN);
        }
    }
    return col;
}

public boolean startNewGame() {
  System.out.println(Constants.START_NEW_GAME);
  String yesOrNo = scanner.next();
  return yesOrNo == "T";
}

// Printing text methods
public void printWelcome() {
    System.out.println(Constants.TITLE);
}

public String isEmpty(State state, int row, int col) {
    if (state.getBoardCell(row, col) == 0) {
        return "";
    }
    return getRedOrBlack(state.getBoardCell(row, col));
}

public void printBoard(State state) {
    System.out.println();
    for (int row = 0; row < Constants.BOARD_ROWS; row++) {
        if (row == 0) {
            System.out.println(Constants.DIVIDER_STRING);
        }
        for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
            System.out.printf(Constants.BOARD_STRING, isEmpty(state, row, col));
        }
        System.out.println();
        if (row == Constants.BOARD_ROWS - 1) {
            System.out.println(Constants.DIVIDER_STRING);
        }
    }
}

public void printInvalidRowOrColumn(int rowOrCol) {
    System.out.printf(Constants.INVALID_ROW_OR_COLUMN, rowOrCol);
}

public void printInvalidMove(int row, int col) {
    System.out.printf(Constants.INVALID_MOVE_ERROR, row, col);
}

public void printMove(State state, int row, int col) {
    System.out.printf(Constants.PRINT_MOVE, getRedOrBlack(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getRedName(), state.getBlackName()), row, col);
} 

public void printWinner(State state) {
    System.out.printf(Constants.WINNER, getRedOrBlack(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getRedName(), state.getBlackName()));
}

public void printTieGame() {
    System.out.println(Constants.TIE_GAME);
}
}
