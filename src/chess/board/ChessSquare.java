package chess.board;

import chess.game.ChessMain;
import chess.pieces.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessSquare extends JPanel {
    private static final long serialVersionUID = 8179920994576419188L;
    private final int col;
    private final int row;
    private ChessPiece piece;

    public ChessSquare(int col, int row, BorderLayout layout) {
        super(layout, true);
        this.col = col;
        this.row = row;
        this.piece = null;
        addMouseListener(getMouseAdapter());
    }

    public void setPiece(ChessPiece piece) {
        if (piece == null) {
            return;
        }
        this.piece = piece;
        removeAll();
        ImageIcon image = new ImageIcon("src/images/" + piece.getImageFileName());
        JLabel pieceLabel = new JLabel(image);
        add(pieceLabel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public ChessPiece getPiece() {
        return this.piece;
    }

    public void removePiece() {
        this.piece = null;
        removeAll();
        repaint();
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    private MouseAdapter getMouseAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JPanel panel = (JPanel) e.getSource();
                ChessSquare target = null;
                if (panel instanceof ChessSquare) {
                    target = (ChessSquare) panel;
                } else if (panel.getParent() instanceof ChessSquare) {
                    target = (ChessSquare) panel.getParent();
                }
                if (target == null) {
                    return;
                }
                if (target.isEmpty()) {
                    // System.out.println("Üres mező !");
                } else {
                    // System.out.println(target.getPiece().getName());
                }
                if (ChessMain.activePiece != null) {
                    if (target.isEmpty()) {
                        // System.out.println("Üres mező !");
                        // System.out.println(ChessMain.activePiece);
                        target.setPiece(((ChessSquare) ChessMain.activePiece).getPiece());
                        ((ChessSquare) ChessMain.activePiece).removePiece();
                        ChessMain.activePiece = null;
                        ChessMain.boardPanel.repaint();
                    } else if (target.getPiece().getColor().compareTo((ChessMain.chessGame.getCurrentPlayerColor())) != 0) {
                        // System.out.println("Nem Üres mező !");
                        target.removePiece();
                        target.setPiece(((ChessSquare) ChessMain.activePiece).getPiece());
                        ((ChessSquare) ChessMain.activePiece).removePiece();
                        ChessMain.activePiece = null;
                        ChessMain.boardPanel.repaint();
                    }
                } else {
                    ChessMain.activePiece = target;
                }
            }
        };
    }
}
