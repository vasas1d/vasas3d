// Az isOnBoard metódus meghatározza, hogy egy adott koordináta (x, y) a sakktáblán belül van-e vagy sem. A metódus igazzal tér vissza, ha mindkét koordináta legalább 0 és legfeljebb 7, ami a 8x8-as sakktáblán belüli érvényes koordináták tartománya.
package chess.pieces.util;

public class PieceUtils {

    public static boolean isOnBoard(int x, int y) {
        return (x >= 0 && x <= 7 && y >= 0 && y <= 7);
    }

}
