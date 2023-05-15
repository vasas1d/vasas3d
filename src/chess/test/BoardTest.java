package chess.test;

import chess.board.Board;
import chess.pieces.Bishop;
import chess.pieces.ChessPiece;
import chess.pieces.Color;
import chess.pieces.Knight;
import chess.pieces.Pawn;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGetInstance() {
        Board board1 = Board.getInstance();
        Board board2 = Board.getInstance();
        assertEquals(board1, board2);
    }
    
    @Test
    public void testGetPiece() {
        Board board = Board.getInstance();
        
        // Helyes teszteset
        ChessPiece piece1 = board.getPiece(0, 0);
        assertNotNull(piece1);
        assertEquals(piece1.getColor(), Color.WHITE);
        assertEquals(piece1.getName(), "Rook");
        
        // Érvénytelen teszteset
        try {
            ChessPiece piece2 = board.getPiece(-1, 0);
            fail("Nem dobott kivételt, pedig érvénytelen koordinátákkal hívtuk meg a metódust.");
        } catch (IllegalArgumentException e) {
            // A kivétel dobása helyes
        }
    }
    
    @Test
    public void testSetPiece() {
        Board board = Board.getInstance();
        ChessPiece pawn = new Pawn(1, 1, Color.WHITE);
        
        // Helyes teszteset
        board.setPiece(pawn, 2, 2);
        ChessPiece piece1 = board.getPiece(2, 2);
        assertNotNull(piece1);
        assertEquals(piece1.getColor(), Color.WHITE);
        assertEquals(piece1.getName(), "Pawn");
        
        // Érvénytelen teszteset
        try {
            board.setPiece(pawn, -1, 0);
            fail("Nem dobott kivételt, pedig érvénytelen koordinátákkal hívtuk meg a metódust.");
        } catch (IllegalArgumentException e) {
            // A kivétel dobása helyes
        }
    }
    
    @Test
    public void testMovePiece() {
        Board board = Board.getInstance();
        ChessPiece pawn = board.getPiece(1, 1);
        board.movePiece(1, 1, 3, 1);
        assertNull(board.getPiece(1, 1));
        ChessPiece piece = board.getPiece(3, 1);
        assertNotNull(piece);
        assertEquals(piece, pawn);
    }

    @Test
    public void testGetLegalMoves() { // getLegalMoves() metódus helytelenül működik, !!!!!!!!!!
        Board board = Board.getInstance();
        ChessPiece bishop = board.getPiece(0, 2);
        assertNotNull(bishop);
        assertTrue(bishop instanceof Bishop);
        assertEquals(bishop.getLegalMoves(board).size(), 0); 
        board.setPiece(null, 0, 1); 
        ChessPiece knight = board.getPiece(0, 1);
        assertNotNull(knight);
        assertFalse(knight instanceof Bishop);
        assertTrue(knight.getLegalMoves(board).contains(board.getPiece(2, 0)));
        assertTrue(knight.getLegalMoves(board).contains(board.getPiece(2, 2)));
        assertTrue(knight.getLegalMoves(board).contains(board.getPiece(1, 3)));
        assertTrue(knight.getLegalMoves(board).contains(board.getPiece(3, 3)));
    }


    @Test
    public void testHasPieces() {
        Board board = Board.getInstance();
        assertTrue(board.hasPieces(Color.WHITE));
        assertTrue(board.hasPieces(Color.BLACK));
        board.removePiece(0, 0);
        assertTrue(board.hasPieces(Color.WHITE));
        assertTrue(board.hasPieces(Color.BLACK));
        board.removePiece(7, 7);
        assertTrue(board.hasPieces(Color.WHITE));
        assertFalse(board.hasPieces(Color.BLACK));
    }

    @Test
    public void testRemovePiece() {
        Board board = Board.getInstance();
        ChessPiece piece = board.getPiece(1, 0);
        assertNotNull(piece);
        board.removePiece(1, 0);
        assertNull(board.getPiece(1, 0));
        assertFalse(board.hasPieces(piece.getColor()));
    }


}
