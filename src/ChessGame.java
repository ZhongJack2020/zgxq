import chess.Board;
import control.GameController;
import view.GameView;

public class ChessGame {
    private Board board;

    private GameController controller;
    private GameView view;

    public static void main(String[] args) throws InterruptedException {
        ChessGame game = new ChessGame();
        game.init();
        game.run();
    }

    public void init() {
        controller = new GameController();
        board = controller.playChess();

        view = new GameView(controller);
        view.init(board);
    }

    public void run() throws InterruptedException {
        while (controller.hasWin(board) == 'x') {
            view.showPlayer('r');
            /* User in. */
            while (board.player == 'r')
                Thread.sleep(1000);

            if (controller.hasWin(board) != 'x')
                view.showWinner('r');
            view.showPlayer('b');
            /* AI in. */
            controller.responseMoveChess(board, view);
        }
        view.showWinner('b');
    }
}