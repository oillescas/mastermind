package illescas.mastermind;

/**
 * Resultado
 */
public class Resultado {

    int negros;
    int blancos;
    boolean esGanador;

    public Resultado(int negros, int blancos, boolean esGanador) {
        this.negros = negros;
        this.blancos = blancos;
        this.esGanador = esGanador;
    }

    public boolean haGanado() {
        return this.esGanador;
    }

    public String toString() {
        return this.negros+ " blacks and "+ this.blancos+" whites";
    }
}
