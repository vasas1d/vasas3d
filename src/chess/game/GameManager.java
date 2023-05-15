// GameManager.java: online játék szerver oldali részét valósítja meg
//az osztály a játéktáblával, a bábukkal, a játékosokkal és a játékosok pontszámával kapcsolatos dolgokat kezeli.
package chess.game;

public class GameManager {

    public static void main(String[] args) {
        ChessGame chessGame1 = new ChessGame();
        chessGame1.play();
    }
}

