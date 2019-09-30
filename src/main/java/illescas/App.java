package illescas;

import illescas.mastermind.Tablero;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String [] args) {
        Tablero principal = new Tablero();
        principal.start();
    }
}
