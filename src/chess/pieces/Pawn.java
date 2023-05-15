// en passzant szabály nincs vagy megegyezés alapján

package chess.pieces;

import chess.board.Board;

public class Pawn extends ChessPiece{

    //private Board board = Board.getInstance();

    public Pawn(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }

    public Pawn() {
        super();
    }
    
    @Override
    public boolean isWhite() {
        return color == Color.WHITE;
    }
    
    @Override
    public String getImageFileName() {
        return isWhite() ? "PawnWhite.png" : "PawnBlack.png";
    }

    @Override
    public boolean isValidMove(int x, int y, Board board) {
        if (y == getYPosition()) { // A gyalog csak előre léphet
            int dy = x - getXPosition();
            if (getColor() == Color.WHITE && dy == -1 || getColor() == Color.BLACK && dy == 1) {
                // A gyalog csak egy mezővel léphet előre, kivéve az első lépésnél, amikor két mezővel is léphet
                if (Math.abs(dy) == 1 || Math.abs(getYPosition() - y) == 2) {
                    // A gyalog csak akkor üthet meg másik bábut, ha az átlósan áll a közelében
                    ChessPiece piece = board.getPiece(x, y);
                    if (piece != null && piece.getColor() != getColor()) {
                        return true;
                    }
                    // A gyalog kiválaszthat egy másik bábut, ha eléri az ellenkező oldalt
                    if (getColor() == Color.WHITE && x == 0 || getColor() == Color.BLACK && x == 7) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return "Pawn";
    }
    
    //függvény, amely megadja, hogy a gyalog támadja-e a megadott koordinátán lévő bábut
    @Override
    public boolean isAttacking(int x, int y, Board board) {
        int dy = y - getYPosition();
        if (getColor() == Color.WHITE && dy == -1 || getColor() == Color.BLACK && dy == 1) {
            int dx = Math.abs(x - getXPosition());
            if (dx == 1) {
                ChessPiece piece = board.getPiece(x, y);
                if (piece != null && piece.getColor() != getColor()) {
                    return true;
                }
            }
        }
        return false;
    }

}
