package illescas.mastermind;

/**
 * Resultado
 */
public class Resultado {

    int negros;
    int blancos;


    public Resultado(int negros, int blancos) {
        this.negros = negros;
        this.blancos = blancos;
    }

    //TODO config
    public boolean haGanado() {
        return this.negros == 4;
    }

    public String toString() {
        return this.negros+ " blacks and "+ this.blancos+" whites";
    }
}
