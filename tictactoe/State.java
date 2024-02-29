package tictactoe;

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.RED;
    private String redName = "";
    private String blackName = "";
    private int[][] board = new int[Constants.BOARD_ROWS][Constants.BOARD_COLUMNS];

    public boolean isWinner() {
        // Checks Horizontally
        for (int row = 0; row < Constants.BOARD_ROWS; row++) {
            for (int col = 0; col < Constants.BOARD_COLUMNS - 3; col++) {
                if (getBoardCell(row, col) == getBoardCell(row, col + 1) && getBoardCell(row, col) == getBoardCell(row, col + 2) && getBoardCell(row, col) == getBoardCell(row, col + 3) && getBoardCell(row, col) != 0) {
                    return true;
                }
            }
        }
        // Checks Vertically
        for (int row = 0; row < Constants.BOARD_ROWS - 3; row++) {
            for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
                if (getBoardCell(row, col) == getBoardCell(row + 1, col) && getBoardCell(row, col) == getBoardCell(row + 2, col) && getBoardCell(row, col) == getBoardCell(row + 3, col) && getBoardCell(row, col) != 0) {
                    return true;
                }
            }
        }
        // Checks Diagonally
        for (int row = Constants.BOARD_ROWS - 1; row < 0; row--) {
            for (int col = 0; col < Constants.BOARD_COLUMNS - 3; col++) {
                if (getBoardCell(row, col) == getBoardCell(row - 1, col + 1) && getBoardCell(row, col) == getBoardCell(row - 2, col + 2) && getBoardCell(row, col) == getBoardCell(row - 3, col + 3) && getBoardCell(row, col) != 0) {
                    return true;
                }
            }
        }
        // Checks Diagonally in Reverse
        for (int row = Constants.BOARD_ROWS - 1; row < 0; row--) {
            for (int col = Constants.BOARD_COLUMNS - 1; col < 0; col--) {
                if (getBoardCell(row, col) == getBoardCell(row - 1, col - 1) && getBoardCell(row, col) == getBoardCell(row - 2, col - 2) && getBoardCell(row, col) == getBoardCell(row - 3, col - 3) && getBoardCell(row, col) != 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTie() {
        for (int row = 0; row < Constants.BOARD_ROWS; row++) {
            for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getRedName() {
        return redName;
    }

    public void setRedName(String redName) {
        this.redName = redName;
    }

    public String getBlackName() {
        return blackName;
    }

    public void setBlackName(String blackName) {
        this.blackName = blackName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

}
