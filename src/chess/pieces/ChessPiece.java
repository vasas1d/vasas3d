package chess.pieces;

import chess.board.Board;
import chess.game.Move;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPiece {

    protected int xPosition;
    protected int yPosition;
    protected Color color;

    /**
     * Üres konstruktor a ChessPiece osztályhoz.
     */
    // akár kivenni?!
    public ChessPiece() {
    }

    /**
     * Konstruktor a ChessPiece osztályhoz, amely beállítja a bábu koordinátáit és színét. Vagyis elhelyezi a pályán.
     * @param xPosition a bábu X koordinátája
     * @param yPosition a bábu Y koordinátája
     * @param color a bábu színe
     */
    public ChessPiece(int xPosition, int yPosition, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    /**
     * Absztrakt metódus, amely meghatározza, hogy a bábu támad-e az adott koordinátára.
     * @param x a cél vagy megtámadott bábu x koordinátája
     * @param y a cél vagy megtámadott bábu y koordinátája
     * @param board a jelenlegi tábla
     * @return igaz, ha az adott bábu támadja a megadott pozíciót az általa definiált szabályok alapján, különben hamis
     */
    public abstract boolean isAttacking(int x, int y, Board board);
     
    /**
     * Absztrakt metódus, amely visszaadja, hogy a bábu fehér-e vagy sem. Vagyis a figura színét.
     * @return igaz, ha a bábu fehér, egyébként hamis
     */
    //Visszaadja, hogy a bábu fehér-e vagy sem.
    public abstract boolean isWhite();

    /**
     * Absztrakt metódus, amely visszaadja a bábu képének a fájlnevét karakterlánc formában.
     * @return a bábu képének a fájlneve 
     */
    //Visszaadja a bábu képének a fájlnevét. 
    public abstract String getImageFileName();

    /**
     * Absztrakt metódus, amely vizsgálja, hogy a bábu adott célmezőre történő lépése érvényes-e a francia sakk szabályok szerint.
     * @param x a cél mező X koordinátája
     * @param y a cél mező Y koordinátája
     * @param board a jelenlegi tábla
     * @return igaz, ha a lépés érvényes, egyébként hamis
     */
    //Vizsgálja, hogy a bábu adott célmezőre történő lépése érvényes-e.
    public abstract boolean isValidMove(int x, int y, Board board);

    /**
     * Metódus, amely visszaadja a bábunak az összes lehetséges érvényes (jelenlegi) lépését. [Figyelve az ütéskényszerekre.]
     * @param board a jelenlegi tábla
     * @return az összes lehetséges érvényes lépés listája
     */
    //Visszaadja a bábunak az összes lehetséges érvényes lépését.
    public List<Move> getLegalMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (isValidMove(x, y, board)) {
                    legalMoves.add(new Move(xPosition, yPosition, x, y));
                }
            }
        }

        return legalMoves;
    }

    //Visszaadja a bábu nevét. metódus felesleges, mert minden bábu rendelkezik a color és a type adattagokkal, ezekből a színből és a típusból könnyen meg lehet határozni a bábu nevét.
    public abstract String getName();

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Metódus, amely visszaadja, hogy a paraméterben megadott mezők közötti útvonalon van-e akadály.
     * @param fromX a kiinduló mező X koordinátája
     * @param fromY a kiinduló mező Y koordinátája
     * @param toX a cél mező X koordinátája
     * @param toY a cél mező Y koordinátája
     * @param board a jelenlegi tábla
     * @return igaz, amennyiben az útvonalon nincs akadály, különben hamis
     */
    //Az isPathBlocked függvény ellenőrzi, hogy az adott útvonalon van-e akadály a bábu és a célmező között.
    public static boolean isPathBlocked(int fromX, int fromY, int toX, int toY, Board board) {
        if (toX < 0 || toX > 7 || toY < 0 || toY > 7) {
            return true;
        }
        int dx = Integer.compare(toX, fromX);
        int dy = Integer.compare(toY, fromY);

        int x = fromX + dx;
        int y = fromY + dy;

        while (x != toX || y != toY) {
            if (board.getPiece(x, y) != null) {
                return true;
            }
            x += dx;
            y += dy;
        }

        return false;
    }   
    
    /**
    * Megadja a megadott pozíción lévő figurát a sakktábláról.
    @param x a vizsgált pozíció vízszintes koordinátája/ x kordináta
    @param y a vizsgált pozíció függőleges koordinátája/ y kordináta
    @param board a vizsgált tábla
    @return a megadott pozícióban lévő sakkfigura, vagy null, ha a pozíció üres
    */
    //Visszaadja az adott mezőn lévő bábut.
    // hibakezelés ?
    public static ChessPiece getPiece(int x, int y, Board board) {
        return board.getBoard()[x][y];
    }
    
    //Beállítja a bábut az adott mezőre a táblán.
    /*public void setPiece(int x, int y, Board board) {
        board.setPiece(this, x, y);
    }*/
}
