package chess.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess.board.Board;
//import chess.game.IllegalMoveException;
//import chess.game.Move;
import chess.pieces.Bishop;
import chess.pieces.Color;
import chess.pieces.Pawn;

public class BishopTest {
    
    @Test
    public void testIsValidMove() {
        Board board = Board.getInstance();
        Bishop bishop = new Bishop(3, 3, Color.WHITE);
        board.setPiece(bishop, 3, 3);

        // Valid moves
	assertTrue(bishop.isValidMove(1, 1, board));
	assertTrue(bishop.isValidMove(1, 5, board));
	assertTrue(bishop.isValidMove(5, 1, board));
	assertTrue(bishop.isValidMove(5, 5, board));

	// Invalid moves
	assertFalse(bishop.isValidMove(3, 2, board));
	assertFalse(bishop.isValidMove(2, 3, board));
	assertFalse(bishop.isValidMove(4, 3, board));
	assertFalse(bishop.isValidMove(3, 4, board));
	assertFalse(bishop.isValidMove(4, 4, board));

	// Move to an occupied square
	Pawn pawn = new Pawn(2, 2, Color.WHITE);
	board.setPiece(pawn, 2, 2);
	assertFalse(bishop.isValidMove(2, 2, board));
    }


    
    @Test
    public void testIsAttacking() {
        Board board = Board.getInstance();
        Bishop bishop = new Bishop(3, 3, Color.WHITE);
        board.setPiece(bishop, 3, 3);

        // Attacking moves
        assertTrue(bishop.isAttacking(1, 1, board));
        assertTrue(bishop.isAttacking(1, 5, board));
        assertTrue(bishop.isAttacking(5, 1, board));
        assertTrue(bishop.isAttacking(5, 5, board));

        // Non-attacking moves
        assertFalse(bishop.isAttacking(3, 2, board));
        assertFalse(bishop.isAttacking(2, 3, board));
        assertFalse(bishop.isAttacking(4, 3, board));
        assertFalse(bishop.isAttacking(3, 4, board));
        assertFalse(bishop.isAttacking(4, 4, board));

        // Attacking moves with capturing
        Pawn pawn = new Pawn(1, 1, Color.BLACK);
        board.setPiece(pawn, 1, 1);
        assertTrue(bishop.isAttacking(1, 1, board));
        board.removePiece(1, 1);
        board.setPiece(pawn, 2, 2);
        assertTrue(bishop.isAttacking(2, 2, board));
    }
    
}
