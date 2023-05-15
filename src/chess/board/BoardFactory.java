// BoardFactory osztály egy sakktáblát hoz létre, és beállítja az összes bábuját a helyes pozícióba
package chess.board;

import chess.pieces.*;

public class BoardFactory {

    public static ChessPiece[][] generateBoard() {
        ChessPiece[][] pieces = new ChessPiece[8][8];

        for (int i = 0; i < 8; i++) {
            Pawn whitePawn = new Pawn();
            putPieceOnBoard(1, i, Color.WHITE, whitePawn, pieces);
            Pawn blackPawn = new Pawn();
            putPieceOnBoard(6, i, Color.BLACK, blackPawn, pieces);
        }

        putRooksOnBoard(pieces);
        putKingOnBoard(pieces);
        putQueenOnBoard(pieces);
        putKnightOnBoard(pieces);
        putBishopOnBoard(pieces);


        return pieces;
    }

    private static void putBishopOnBoard(ChessPiece[][] pieces) {
        putPieceOnBoard(0, 2, Color.WHITE, new Bishop(), pieces);
        putPieceOnBoard(0, 5, Color.WHITE, new Bishop(), pieces);
        putPieceOnBoard(7, 2, Color.BLACK, new Bishop(), pieces);
        putPieceOnBoard(7, 5, Color.BLACK, new Bishop(), pieces);
    }

    private static void putKnightOnBoard(ChessPiece[][] pieces) {
        putPieceOnBoard(0, 1, Color.WHITE, new Knight(), pieces);
        putPieceOnBoard(0, 6, Color.WHITE, new Knight(), pieces);

        putPieceOnBoard(7, 1, Color.BLACK, new Knight(), pieces);
        putPieceOnBoard(7, 6, Color.BLACK, new Knight(), pieces);
    }

    private static void putQueenOnBoard(ChessPiece[][] pieces) {
        putPieceOnBoard(0, 3, Color.WHITE, new Queen(), pieces);
        putPieceOnBoard(7, 3, Color.BLACK, new Queen(), pieces);
    }

    private static void putKingOnBoard(ChessPiece[][] pieces) {
        putPieceOnBoard(0, 4, Color.WHITE, new King(), pieces);
        putPieceOnBoard(7, 4, Color.BLACK, new King(), pieces);
    }

    private static void putRooksOnBoard(ChessPiece[][] pieces) {
        putPieceOnBoard(0, 0, Color.WHITE, new Rook(), pieces);
        putPieceOnBoard(0, 7, Color.WHITE, new Rook(), pieces);

        putPieceOnBoard(7, 0, Color.BLACK, new Rook(), pieces);
        putPieceOnBoard(7, 7, Color.BLACK, new Rook(), pieces);
    }

    private static void putPieceOnBoard(int x, int y, Color color, ChessPiece piece, ChessPiece[][] pieces) {
	    if (x >= 0 && x < pieces.length && y >= 0 && y < pieces[0].length) {
	        piece.setXPosition(x);
	        piece.setYPosition(y);
	        piece.setColor(color);

	        pieces[x][y] = piece;
	    } else {
	        throw new IllegalArgumentException("Érvénytelen mező: (" + x + ", " + y + ")");
	    }
	}


}
