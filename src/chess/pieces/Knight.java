package chess.pieces;

import chess.board.Board;

public class Knight extends ChessPiece {

    //private Board board = Board.getInstance(); // Board objektum lekérése

    public Knight(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }

    public Knight() {
        super();
    }
    
    @Override
    public boolean isWhite() {
        return color == Color.WHITE;
    }
    
    @Override
    public String getImageFileName() {
        return isWhite() ? "KnightWhite.png" : "KnightBlack.png";
    }

    @Override
    public boolean isValidMove(int x, int y, Board board) {
        int dx = Math.abs(x - getXPosition());
        int dy = Math.abs(y - getYPosition());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public String getName() {
        return "Knight";
    }
    
    @Override
    public boolean isAttacking(int x, int y, Board board) {
        int dx = Math.abs(x - getXPosition());
        int dy = Math.abs(y - getYPosition());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

}
