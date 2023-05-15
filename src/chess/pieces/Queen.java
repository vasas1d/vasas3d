package chess.pieces;

import chess.board.Board;
import static chess.pieces.util.PieceUtils.isOnBoard;

public class Queen extends ChessPiece{

    public Queen(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }

    public Queen(){
        super();
    }
    
    @Override
    public boolean isWhite() {
        return color == Color.WHITE;
    }
    
    @Override
    public String getImageFileName() {
        return isWhite() ? "QueenWhite.png" : "QueenBlack.png";
    }

    @Override
    public boolean isValidMove(int x, int y, Board board) {
        if (x == getXPosition() && y == getYPosition()) {
            return false; // A királynő nem változtatja a pozícióját
        }

        if (!isOnBoard(x, y)) {
            return false; // Az új pozíció azon kívül van, mint a játéktábla
        }

        int dx = Math.abs(x - getXPosition());
        int dy = Math.abs(y - getYPosition());

        // Lépés csak vízszintesen, függőlegesen vagy átlósan lehetséges
        if (!(dx == 0 || dy == 0 || dx == dy)) {
            return false;
        }

        int xDir = Integer.signum(x - getXPosition());
        int yDir = Integer.signum(y - getYPosition());

        int i = getXPosition() + xDir;
        int j = getYPosition() + yDir;

        while (i != x || j != y) {
            if (Board.getInstance().getPiece(i, j) != null) {
                return false; // Ütközés másik bábuval
            }
            i += xDir;
            j += yDir;
        }

        return true;
    }

    @Override
    public String getName() {
        return "Queen";
    }
    
    public boolean isAttacking(int x, int y, Board board) {
	    if (x == getXPosition() && y == getYPosition()) {
	        return false; // A királynő nem támadja a saját pozícióját
	    }

	    if (!isOnBoard(x, y)) {
	        return false; // Az új pozíció azon kívül van, mint a játéktábla
	    }

	    int dx = Math.abs(x - getXPosition());
	    int dy = Math.abs(y - getYPosition());

	    // A királynő támadása akkor érvényes, ha az célmező a vízszintes, függőleges vagy átlós vonalán van
	    if (!(dx == 0 || dy == 0 || dx == dy)) {
	        return false;
	    }

	    int xDir = Integer.signum(x - getXPosition());
	    int yDir = Integer.signum(y - getYPosition());

	    int i = getXPosition() + xDir;
	    int j = getYPosition() + yDir;

	    while (i != x || j != y) {
	        if (board.getPiece(i, j) != null) {
	            return false; // Az útvonalon másik bábu van, nem támadható
	        }
	        i += xDir;
	        j += yDir;
	    }

	    return true;
	}

}
