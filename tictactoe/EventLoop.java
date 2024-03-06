package tictactoe;

public class EventLoop {

  // Instance variables for the UI and State classes
  State state = new State();
  UI ui = new UI();
  int row, col;

  public void eventLoop() {
    while (state.getGameState() != Constants.QUIT_PROGRAM) {
      int gameState = state.getGameState();
      if (gameState == Constants.STANDBY) {
        state.setGameState(Constants.GET_RED_NAME);
      } else if (gameState == Constants.GET_RED_NAME) {
        state.setRedName(ui.promptForName(Constants.RED));
        state.setGameState(Constants.GET_BLACK_NAME);
      } else if (gameState == Constants.GET_BLACK_NAME) {
        state.setBlackName(ui.promptForName(Constants.BLACK));
        state.setGameState(Constants.GET_RED_MOVE);
    
      } else if (gameState == Constants.GET_RED_MOVE) {
        col = ui.getMoveCol(state, state.getWhoseMove());
        row = ui.getMoveRow(state, col);
        if (ui.isLegalMove(state, row, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        }
      } else if (gameState == Constants.GET_BLACK_MOVE) {
        col = ui.getMoveCol(state, state.getWhoseMove());
        row = ui.getMoveRow(state, col);
        if (ui.isLegalMove(state, row, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        }
      } else if (gameState == Constants.MAKE_MOVE) {
        ui.printMove(state, row, col);
        state.setBoardCell(row, col, state.getWhoseMove());
        ui.printBoard(state);
        state.setGameState(Constants.CHECK_IF_WINNER);

      } else if (gameState == Constants.CHECK_IF_WINNER) {
        if (state.isWinner()) {
          if (state.getWhoseMove() == Constants.RED) {
            state.setGameState(Constants.RED_WINS);
          } else {
            state.setGameState(Constants.BLACK_WINS);
          }
        } else {
          state.setGameState(Constants.CHECK_IF_TIE);
        }

      } else if (gameState == Constants.CHECK_IF_TIE) {
        if (state.isTie()) {
          ui.printTieGame();
          state.setGameState(Constants.GAME_OVER);
        } else {
          state.setWhoseMove(state.getWhoseMove() * -1);
          if (state.getWhoseMove() == Constants.RED) {
            state.setGameState(Constants.GET_RED_MOVE);
          } else {
            state.setGameState(Constants.GET_BLACK_MOVE);
          }
        }

      } else if (gameState == Constants.RED_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);
    
      } else if (gameState == Constants.BLACK_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);

      } else if (gameState == Constants.GAME_OVER) {
        if (ui.startNewGame()) {

          state.setGameState(Constants.STANDBY);
        } else {
         state.setGameState(Constants.QUIT_PROGRAM);
        }
      }
    }
  }
}
