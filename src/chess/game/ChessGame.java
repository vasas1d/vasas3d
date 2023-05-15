//játék logikáját valósítja meg. a játékosok számára biztosítja, hogy interakcióba lépjenek a játéktáblával.

package chess.game;

import chess.board.Board;
import chess.pieces.ChessPiece;
import chess.pieces.Color;
import chess.pieces.util.PieceUtils;

import java.util.Scanner;

public class ChessGame {

    private final Board board;
    private Color currentPlayerColor;

    public ChessGame() {
        this.board = Board.getInstance();
        this.currentPlayerColor = Color.WHITE;
    }

    public Color getCurrentPlayerColor() {
        return currentPlayerColor;
    }

    public Board getBoard() {
        return this.board;
    }


    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Játék kezdődik...");

        while (!isGameOver()) {
            System.out.println("Aktuális kör: " + currentPlayerColor + " játékos");

            System.out.println(board.toString());

            String moveString = getMoveFromPlayer(scanner);

            Move move = parseMove(moveString);
            boolean isValidMove = validateMove(move);

            if (isValidMove) {
                executeMove(move);
                switchPlayers();
            } else {
                System.out.println("Érvénytelen lépés, próbáld újra!");
            }
        }

        System.out.println("Játék vége!");
    }

    public static String getMoveFromPlayer(Scanner scanner) {
        System.out.print("Lépjen kérem: ");
        return scanner.nextLine();
    }

    private static Move parseMove(String moveString) {

        if (moveString == null || !moveString.matches("[a-h][1-8]\\s[a-h][1-8]")) {
            return null;
        }

        int fromX = moveString.charAt(0) - 'a';
        int fromY = Character.getNumericValue(moveString.charAt(1)) - 1;
        int toX = moveString.charAt(3) - 'a';
        int toY = Character.getNumericValue(moveString.charAt(4)) - 1;

        return new Move(fromX, fromY, toX, toY);
    }

    //    ellenőrizzük, hogy érvényes lépés-e
    private boolean validateMove(Move move) {

        if (move == null) {
            return false;
        }

        if (!PieceUtils.isOnBoard(move.getFromX(), move.getFromY())
                || !PieceUtils.isOnBoard(move.getToX(), move.getToY())) {
            return false;
        }

        ChessPiece piece = board.getPiece(move.getFromX(), move.getFromY());
        if (piece == null || piece.getColor() != currentPlayerColor) {
            return false;
        }

        if (!piece.isValidMove(move.getToX(), move.getToY(), board)) {
            return false;
        }

        return true;
    }

    //végrehajtja a lépést
    private void executeMove(Move move) {
        ChessPiece piece = board.getPiece(move.getFromX(), move.getFromY());
        if (piece == null) {
            throw new IllegalStateException("A kiindulási mezőn nincs bábu!");
        }
        board.movePiece(move.getFromX(), move.getFromY(), move.getToX(), move.getToY());
    }


    public boolean isGameOver() {
        boolean whiteHasPieces = board.hasPieces(Color.WHITE);
        boolean blackHasPieces = board.hasPieces(Color.BLACK);

        return !whiteHasPieces || !blackHasPieces;
    }

    public void switchPlayers() {
        if (currentPlayerColor == Color.WHITE) {
            currentPlayerColor = Color.BLACK;
        } else {
            currentPlayerColor = Color.WHITE;
        }
    }

    public boolean parseAndMove(String moveString) { // a lenti parseAndMove és tryMove összevonásával.
        Move move = parseMove(moveString);
        if (move == null) {
            return false;
        }
        boolean isValidMove = validateMove(move);
        if (isValidMove) {
            executeMove(move);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean movePiece(int startX, int startY, int endX, int endY) {
	    Move move = new Move(startX, startY, endX, endY);
	    if (!validateMove(move)) {
	        return false;
	    }
	    executeMove(move);
	    return true;
	}



}
