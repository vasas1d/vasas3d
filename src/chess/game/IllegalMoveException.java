package chess.game;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(String message) {
        super(message);
    }
    
    public static IllegalMoveException invalidCastling() {
        return new IllegalMoveException("A játékban nincs sáncolás.");
    }
    
    public static IllegalMoveException invalidEnPassant() {
        return new IllegalMoveException("A játékban nincs en passant szabály.");
    }
    
    public static IllegalMoveException pawnDoubleMoveNotAllowed() {
        return new IllegalMoveException("A gyalog nem léphet ismét 2 mezőt.");
    }
    
    public static IllegalMoveException mandatoryCapture() {
        return new IllegalMoveException("A jelenlegi helyzetben egy vagy több ütés elérhető, kötelező végrehajtani.");
    }
}
