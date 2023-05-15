package chess.test;

import static org.junit.Assert.*;
import org.junit.Test;

import chess.board.Board;
import chess.pieces.ChessPiece;
import chess.pieces.Color;
import chess.pieces.Knight;
import chess.pieces.Pawn;


public class KnightTest1 {

    @Test
    public void testKnightIsValidMove() {
        // Given
        Board board = Board.getInstance();
        ChessPiece knight = new Knight(3, 3, Color.WHITE);
        board.setPiece(knight, 3, 3);
        ChessPiece ownPiece = new Pawn(4, 5, Color.WHITE);
        board.setPiece(ownPiece, 4, 5);
        ChessPiece enemyPiece = new Pawn(2, 2, Color.BLACK);
        board.setPiece(enemyPiece, 2, 2);

        // When
        boolean result1 = knight.isValidMove(5, 4, board); // jobbra-két-lefelé
        boolean result2 = knight.isValidMove(4, 5, board); // jobbra-egy-fel
        boolean result3 = knight.isValidMove(4, 1, board); // jobbra-egy-lefel
        boolean result4 = knight.isValidMove(2, 1, board); // balra-egy-lefel
        boolean result5 = knight.isValidMove(2, 5, board); // balra-egy-fel
        boolean result6 = knight.isValidMove(1, 4, board); // balra-két-lefel
        boolean result7 = knight.isValidMove(5, 2, board); // jobbra-két-fel
        boolean result8 = knight.isValidMove(1, 2, board); // balra-két-fel
        boolean result9 = knight.isValidMove(3, 5, board); // nem megengedett mező
        boolean result10 = knight.isValidMove(4, 4, board); // saját bábút nem üt le
        boolean result11 = knight.isValidMove(2, 2, board); // ellenfél bábút üt le

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
    }
}
