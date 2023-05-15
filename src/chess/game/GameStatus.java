//A GameStatus enum osztály felelős az aktuális játékállapot követéséért és tárolásáért

package chess.game;

public enum GameStatus {
    IN_PROGRESS, 	 // IN_PROGRESS: a játék folyamatban van
    DRAW, 			 // DRAW: döntetlen állapot
    CHECKMATE,       // CHECKMATE: egy játékosnak elfogytak a bábjai, a játék véget ért
    STALEMATE		 // STALEMATE: a játék egy olyan állapotban van, hogy az egyik játékos sem tudja lépni a következő lépésével, a játék véget ért
}
