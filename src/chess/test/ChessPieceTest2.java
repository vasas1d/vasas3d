// IsValidMove teszt
package chess.test;


import static org.junit.Assert.*;
import org.junit.Test;

import chess.board.Board;
import chess.pieces.Color;
import chess.pieces.ChessPiece;
import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Bishop;


public class ChessPieceTest2 {

    	@Test
	public void testBishopIsValidMove() {
		// Given
		Board board = Board.getInstance();
		ChessPiece bishop = new Bishop(3, 3, Color.WHITE);
		board.setPiece(bishop, 3, 3);
		
		// When
		boolean result1 = bishop.isValidMove(5, 5, board); // átlósan
		boolean result2 = bishop.isValidMove(4, 4, board); // átlósan
		boolean result3 = bishop.isValidMove(5, 4, board); // nem átlósan
		boolean result4 = bishop.isValidMove(3, 5, board); // nem átlósan
		
		// Then
		assertTrue(result1);
		assertTrue(result2);
		assertFalse(result3);
		assertFalse(result4);
	}
	
	@Test
	public void testKingIsValidMove() {
	    // Given
	    Board board = Board.getInstance();
	    ChessPiece king = new King(3, 3, Color.WHITE);
	    board.setPiece(king, 3, 3);
	    ChessPiece enemyPiece = new Pawn(3, 4, Color.BLACK);
	    board.setPiece(enemyPiece, 3, 4);
	    ChessPiece ownPiece = new Pawn(4, 4, Color.WHITE);
	    board.setPiece(ownPiece, 4, 4);
	    
	    // When
	    boolean result1 = king.isValidMove(3, 4, board); // egy mezővel felfelé
	    boolean result2 = king.isValidMove(4, 4, board); // egy mezővel jobbra-felfelé
	    boolean result3 = king.isValidMove(5, 3, board); // egy mezővel jobbra
	    boolean result4 = king.isValidMove(4, 2, board); // egy mezővel jobbra-lefelé
	    boolean result5 = king.isValidMove(3, 2, board); // egy mezővel lefelé
	    boolean result6 = king.isValidMove(2, 2, board); // egy mezővel balra-lefelé
	    boolean result7 = king.isValidMove(1, 3, board); // egy mezővel balra
	    boolean result8 = king.isValidMove(2, 4, board); // egy mezővel balra-felfelé
	    boolean result9 = king.isValidMove(4, 3, board); // több mint egy mezőre
	    boolean result10 = king.isValidMove(1, 1, board); // nem érvényes mező
	    boolean result11 = king.isValidMove(3, 4, board); // ellenfél bábút üt le
	    boolean result12 = king.isValidMove(4, 4, board); // saját bábút nem üt le
	    
	    // Then
	    assertTrue(result1);
	    assertTrue(result2);
	    assertTrue(result3);
	    assertTrue(result4);
	    assertTrue(result5);
	    assertTrue(result6);
	    assertTrue(result7);
	    assertTrue(result8);
	    assertFalse(result9);
	    assertFalse(result10);
	    assertTrue(result11);
	    assertFalse(result12);
	}

	
}