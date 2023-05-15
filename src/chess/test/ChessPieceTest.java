package chess.test;

import chess.board.Board;
import chess.pieces.Color;
import chess.pieces.ChessPiece;
import chess.pieces.King;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChessPieceTest {

    @Test
    public void testIsWhite1() {
        ChessPiece whiteKing = new King(0, 0, Color.WHITE);
        assertTrue(whiteKing.isWhite());

        ChessPiece blackKing = new King(0, 0, Color.BLACK);
        assertFalse(blackKing.isWhite());
    }

    @Test
    public void testIsValidMove1() {
        Board board = Board.getInstance();
        ChessPiece whiteKing = new King(4, 4, Color.WHITE);

        // Valid move
        assertTrue(whiteKing.isValidMove(5, 5, board));

        // Invalid move
        assertFalse(whiteKing.isValidMove(6, 6, board));
    }
}
