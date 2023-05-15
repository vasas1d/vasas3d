/* A Move osztály egy lépést reprezentál a sakktáblán. A Move osztály tartalmaz négy adattagot, amelyek tárolják a kezdő és végpozíció koordinátáit az x és y tengelyen.
 Az osztály egy konstruktort tartalmaz, amely beállítja ezeket az adattagokat a paraméterek alapján, és négy getter metódust, amelyek visszaadják ezeket az értékeket.
A Move osztály kifejezetten erre a célra lett tervezve, hogy a játékmenetben használják, és hogy könnyen lehetővé tegye az egyes lépések kezelését és nyomon követését. 
Az osztály további funkcionalitása nem része a kódnak. */

package chess.game;

public class Move {

    private final int fromX;
    private final int fromY;
    private final int toX;
    private final int toY;

    public Move(int fromX, int fromY, int toX, int toY) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }

    public int getFromX() {
        return fromX;
    }

    public int getFromY() {
        return fromY;
    }

    public int getToX() {
        return toX;
    }

    public int getToY() {
        return toY;
    }

}
