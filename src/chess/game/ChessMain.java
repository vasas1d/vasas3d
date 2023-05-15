//sakkjáték grafikus felhasználói felületét valósítja meg, amely a megjelenítést végzi, és a játékosok által végrehajtott lépéseket megjeleníti a sakk-táblán

package chess.game;

import chess.board.BoardFactory;
import chess.board.ChessSquare;
import chess.pieces.ChessPiece;

import javax.swing.*;
import java.awt.*;

public class ChessMain {
    private final JFrame frame;
    public static JPanel boardPanel;
    private final JPanel whitePanel;
    private final JPanel blackPanel;

    public static ChessGame chessGame;

    public static Component activePiece;

    public ChessMain() {
        frame = new JFrame("French Chess Game");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel = new JPanel(new GridLayout(8, 8)) {
            /**
	     * 
	     */
	    private static final long serialVersionUID = 3035925409233610275L;

	    @Override
            public Dimension getPreferredSize() {
                Dimension dim = super.getPreferredSize();
                int size = Math.min(dim.width, dim.height);
                return new Dimension(size, size);
            }
        };
        boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        whitePanel = new JPanel(new GridLayout(1, 8));
        whitePanel.setBackground(Color.WHITE);

        blackPanel = new JPanel(new GridLayout(1, 8));
        blackPanel.setBackground(Color.WHITE);

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(whitePanel, BorderLayout.NORTH);
        frame.add(blackPanel, BorderLayout.SOUTH);

        chessGame = new ChessGame();

        createChessboard();
        addPieces();

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);

    }

    private static void createChessboard() {
        boolean isWhite = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessSquare squarePanel = new ChessSquare(i, j, new BorderLayout());
                squarePanel.setVisible(true);
                squarePanel.setBackground(isWhite ? Color.WHITE : Color.GRAY);
                boardPanel.add(squarePanel);
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
    }

    private static void addPieces() {
        ChessPiece[][] pieces = BoardFactory.generateBoard();

        // fehér bábuk létrehozása, felül a tisztek
        for (int i = 0; i < 8; i++) {
            ChessSquare squarePanel = (ChessSquare) boardPanel.getComponent(i);
            squarePanel.setPiece(pieces[0][i]);
        }

        //  fehér gyalogok
        for (int i = 8; i < 16; i++) {
            ChessSquare squarePanel = (ChessSquare) boardPanel.getComponent(i);
            squarePanel.setPiece(pieces[1][i - 8]);
        }
        // fekete gyalogok
        for (int i = 48; i < 56; i++) {
            ChessSquare squarePanel = (ChessSquare) boardPanel.getComponent(i);
            squarePanel.setPiece(pieces[6][i - 48]);
        }
        // fekete bábok
        for (int i = 56; i < 64; i++) {
            ChessSquare squarePanel = (ChessSquare) boardPanel.getComponent(i);
            squarePanel.setPiece(pieces[7][i - 56]);
        }

        //+ további mezők valamerre a leütött báboknak

    }
    
    public static void updateBoard(int startX, int startY, int endX, int endY) {
	    // Frissítjük a kezdő- és célmezőt a felhasználói felületen
	    ChessSquare startSquare = (ChessSquare) boardPanel.getComponent(startX * 8 + startY);
	    ChessSquare endSquare = (ChessSquare) boardPanel.getComponent(endX * 8 + endY);

	    // Áthelyezzük a bábut a célmezőre
	    ChessPiece piece = startSquare.getPiece();
	    endSquare.setPiece(piece);
	    startSquare.setPiece(null);

	    // Frissítjük a bábuk pozícióját
	    piece.setXPosition(endX);
	    piece.setYPosition(endY);

	    // Frissítjük a felhasználói felületet
	    endSquare.repaint();
	    startSquare.repaint();
	}



    public static void main(String[] args) {

        new ChessMain();

    }
}
