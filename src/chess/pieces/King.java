/* nincs sakk adás a francia sakkban. sakk és matt sincs így. nincs enpasszant és sánc. 
A király csak egy mezőt léphet bármelyik irányba, feltéve hogy az adott mező üres, vagy ott ellenfél bábu áll.
A király nem léphet olyan mezőre, ahol azonos szín bábja áll.
Ha az adott mezőn ellenfél bábuja áll, a király leüti azt.*/

package chess.pieces;
//import static chess.pieces.util.PieceUtils.isOnBoard;
import chess.board.Board;
import chess.pieces.util.PieceUtils;

public class King extends ChessPiece {

    public King(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }

    public King() {
        super();
    }
    
    @Override
    public boolean isWhite() {
        return color == Color.WHITE;
    }
    
    @Override
    public String getImageFileName() {
        return isWhite() ? "KingWhite.png" : "KingBlack.png";
    }

    @Override
    public boolean isValidMove(int x, int y, Board board) {
        if (x == getXPosition() && y == getYPosition()) {
            return false; // A király nem változtatja a pozícióját
        }

        if (!PieceUtils.isOnBoard(x, y)) {
            return false; // Az új pozíció azon kívül van, mint a játéktábla
        }

        int dx = Math.abs(x - getXPosition());
        int dy = Math.abs(y - getYPosition());

        // A király csak egy mezőt léphet
        if (dx > 1 || dy > 1) {
            return false;
        }

        // Ellenőrizzük, hogy a célmezőn nincs-e saját báb
        ChessPiece pieceAtNewPos = board.getPiece(x, y);
        if (pieceAtNewPos != null && pieceAtNewPos.getColor() == getColor()) {
            return false;
        }

        return true;
    }


    @Override
    public String getName() {
        return "King";
    }
    
    @Override
    public boolean isAttacking(int x, int y, Board board) {
        // A király csak azokra a mezőkre támad, amelyek egy lépés távolságra vannak tőle
        int dx = Math.abs(x - getXPosition());
        int dy = Math.abs(y - getYPosition());
        if (dx <= 1 && dy <= 1) {
            // Ha a célmezőn ellenfél bábu van, akkor azt támadja
            ChessPiece pieceAtNewPos = board.getPiece(x, y);
            return pieceAtNewPos != null && pieceAtNewPos.getColor() != getColor();
        }
        return false;
    }

}
