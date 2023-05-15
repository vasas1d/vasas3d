package chess.test;

import static org.junit.jupiter.api.Assertions.*;

import chess.board.BoardFactory;
import chess.pieces.ChessPiece;
import org.junit.jupiter.api.Test;

public class BoardFactoryTest_OK {

    @Test
    public void testGenerateBoard() {
        ChessPiece[][] pieces = BoardFactory.generateBoard();

        // Check that there are 32 pieces on the board
        int numPieces = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieces[i][j] != null) {
                    numPieces++;
                }
            }
        }
        assertEquals(32, numPieces);

        // Check that each player has 16 pieces
        int numWhitePieces = 0;
        int numBlackPieces = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieces[i][j] != null) {
                    if (pieces[i][j].isWhite()) {
                        numWhitePieces++;
                    } else {
                        numBlackPieces++;
                    }
                }
            }
        }
        assertEquals(16, numWhitePieces);
        assertEquals(16, numBlackPieces);
    }
}
