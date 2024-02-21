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
        int total;
        for (int row=0; row< Constants.BOARD_ROWS; row++) {
            total = getBoardCell(row, 0) + getBoardCell(row,1) + getBoardCell(row,2);
            if (total == -3 || total == 3) return true;
        }
        for (int col=0; col<Constants.BOARD_COLUMNS; col++) {
            total = getBoardCell(0, col) + getBoardCell(1,col) + getBoardCell(2, col);
            if (total == -3 || total == 3) return true;
        }
        total = getBoardCell(0, 0) + getBoardCell(1,1) + getBoardCell(2, 2);
        if (total == -3 || total == 3) return true;
        total = getBoardCell(2, 0) + getBoardCell(1,1) + getBoardCell(0, 2);
        if (total == -3 || total == 3) return true;
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_ROWS; row++) {
            for (int col=0; col<Constants.BOARD_COLUMNS; col++) {
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
