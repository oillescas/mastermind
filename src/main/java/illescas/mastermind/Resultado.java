package illescas.mastermind;

/**
 * Resultado
 */
public class Resultado {

    int negros;
    int blancos;
    boolean ganador;

    public Resultado(int negros, int blancos, boolean ganador) {
        this.negros = negros;
        this.blancos = blancos;
        this.ganador = ganador;
    }

    public boolean haGanado() {
        return this.ganador;
    }

    public String toString() {
        return this.negros+ " blacks and "+ this.blancos+" whites";
    }
}
