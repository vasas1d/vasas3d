package chess.pieces;

import chess.board.Board;

public class Rook extends ChessPiece{
	//private Board board = Board.getInstance(); // Board objektum lekérése

	public Rook(){
	    super();
	}

	public Rook(int xPosition, int yPosition, Color color) {
	    super(xPosition, yPosition, color);
	}
	
	    @Override
	    public boolean isWhite() {
	        return color == Color.WHITE;
	    }
	
        public String getImageFileName() {
            return isWhite() ? "RookWhite.png" : "RookBlack.png";
        }

	@Override
	public boolean isValidMove(int x, int y, Board board) {
	    // A vezér csak vízszintes vagy függőleges irányban mozoghat
	    if (x == getXPosition() || y == getYPosition()) {
	        int dx = Integer.compare(x, getXPosition());
	        int dy = Integer.compare(y, getYPosition());
	        for (int i = 1; i < Math.max(Math.abs(dx), Math.abs(dy)); i++) {
	            int xPos = getXPosition() + i * dx;
	            int yPos = getYPosition() + i * dy;
	            // Ha bábu van az úton, akkor a vezér nem tud tovább menni
	            if (board.getPiece(xPos, yPos) != null) {
	                return false;
	            }
	        }
	        // Ha üres az út, vagy az úton lévő bábu színétől eltérő a vezér színe, akkor a vezér tud mozogni az adott mezőre
	        ChessPiece piece = board.getPiece(x, y);
	        if (piece == null || piece.getColor() != getColor()) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public String getName() {
	    return "Rook";
	}
	
	@Override
	public boolean isAttacking(int x, int y, Board board) {
	    // A bástya csak vízszintesen vagy függőlegesen támadhat meg egy másik mezőt
	    if (x == getXPosition() || y == getYPosition()) {
	        int dx = Integer.compare(x, getXPosition());
	        int dy = Integer.compare(y, getYPosition());
	        for (int i = 1; i < Math.max(Math.abs(dx), Math.abs(dy)); i++) {
	            int xPos = getXPosition() + i * dx;
	            int yPos = getYPosition() + i * dy;
	            // Ha bábu van az úton, akkor a bástya nem tud tovább menni, és nem támadhatja meg a célmezőt
	            if (board.getPiece(xPos, yPos) != null) {
	                return false;
	            }
	        }
	        // Ha üres az út, vagy az úton lévő bábu színétől eltérő a bástya színe, akkor a bástya támadja a célmezőt
	        ChessPiece piece = board.getPiece(x, y);
	        if (piece == null || piece.getColor() != getColor()) {
	            return true;
	        }
	    }
	    return false;
	}


}