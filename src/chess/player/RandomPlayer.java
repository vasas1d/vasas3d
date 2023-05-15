// lvl1 AI random lép /üt

package chess.player;

import chess.board.Board;
import chess.game.Move;
import chess.pieces.ChessPiece;
import chess.pieces.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPlayer {

    private final Color color;

    public RandomPlayer(Color color) {
        this.color = color;
    }

    public Move getNextMove(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        for (int x = 0; x < 8 ; x++) {
            for (int y = 0; y < 8 ; y++) {
                ChessPiece piece = board.getPiece(x, y);
                if (piece != null && piece.getColor() == color) {
                    for (Move move : piece.getLegalMoves(board)) {
                        legalMoves.add(move);
                    }
                }
            }
        }

        if (legalMoves.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(legalMoves.size());
        return legalMoves.get(randomIndex);
    }

    public Color getColor() {
        return color;
    }
}
