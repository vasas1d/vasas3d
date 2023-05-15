    // A GameController osztály felelős az interakciókért a játékos és a számítógép között a játék vezérlése során.
    
    
    /*
     * Az osztályt tovább lehetne bővíteni például azáltal, hogy a játékot menti és betölti, kezeli a játékosok nevét, ellenőrzi, hogy a játékosok időkorlátját betartják-e,
     *  és így tovább. Ezenkívül érdemes lehetne szétbontani az osztályt további felelősségi területek szerint. Például lehetne egy PlayerInputManager osztály,
     *   amely külön felel a játékosoktól bekért adatok kezeléséért, vagy egy GameStatusManager osztály, amely a játék állapotát kezeli.
     *    A cél az lenne, hogy az osztályok kevesebb dolgot csináljanak, és jobban elkülönüljenek egymástól.
     * 
    */
    
    //
    
    //
    
    package chess.game;
    

    import java.util.Scanner;
    
    public class GameController {
    
        private ChessGame chessGame;
    
        public GameController(ChessGame chessGame) {
            this.chessGame = chessGame;
        }
    
        public void start() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Játék kezdődik...");
            while (!chessGame.isGameOver()) {
                System.out.println("Aktuális kör: " + chessGame.getCurrentPlayerColor() + " játékos");
                System.out.println(chessGame.getBoard());
    
                String moveString = getMoveFromPlayer(scanner);
                boolean isValidMove = chessGame.parseAndMove(moveString);
    
                if (isValidMove) {
                    chessGame.switchPlayers();
                } else {
                    System.out.println("Érvénytelen lépés, próbáld újra!");
                }
            }
            System.out.println("Játék vége!");
        }
    
        private String getMoveFromPlayer(Scanner scanner) {
            return getMoveFromPlayer(scanner, "Lépjen kérem: ");
        }
    
        private String getMoveFromPlayer(Scanner scanner, String message) {
            System.out.print(message);
            return scanner.nextLine();
        }
    
       /* // lépés bevitelének engedélyezéséhez más forrásokból is, ja csak fölös
        public String getMoveFromPlayer() {
            return getMoveFromPlayer("Lépjen kérem: ");
        }*/
    
        public String getMoveFromPlayer(String message) {
            Scanner scanner = new Scanner(System.in);
            return getMoveFromPlayer(scanner, message);
        }
    }
