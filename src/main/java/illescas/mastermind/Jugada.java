package illescas.mastermind;

import java.util.Arrays;

/**
 * Jugada
 */
public class Jugada {

    public Color[] fichas;
    private final static int NUMERO_POSICIONES = 4;

    public Jugada(String fichas) throws Exception {
        if(fichas.length() != this.NUMERO_POSICIONES){
            throw new Exception("Wrong proposed combination length");
        }
        this.fichas = new Color[Jugada.NUMERO_POSICIONES];
        for (int i = 0; i < fichas.length(); i++){
            this.fichas[i] = Color.valueOf(Character.toString(fichas.charAt(i)).toUpperCase());
        }
    }

    public Resultado checkJugada(Jugada prueba) {

        int blancos = chekBlancos(prueba);
        int negros = checkNegros(prueba);

        return new Resultado(blancos, negros);
    }

    private int chekBlancos(Jugada prueba){

        int contador = 0;

        for (int i = 0; i < fichas.length; i++) {
            Color fichaSecreta = this.fichas[i];
            Color fichaJugada = prueba.fichas[i];
            if(fichaSecreta.equals(fichaJugada)){
                contador++;
            }
        }

        return contador;
    }


    // TODO refactor
    private int checkNegros(Jugada prueba){
        int contador = 0;

        for (int i = 0; i < fichas.length; i++) {
            Color fichaSecreta = this.fichas[i];
            int aciertoFila = 0;
            for (int j = 0; j < prueba.fichas.length; j++) {
                Color fichaJugada = prueba.fichas[j];
                if(j==i && fichaSecreta.equals(fichaJugada)) {
                    aciertoFila = 0;
                    j = prueba.fichas.length;
                } else if(fichaJugada.equals(fichaSecreta)) {
                    aciertoFila = 1;
                }
            }
            contador += aciertoFila;
        }

        return contador;
    }


    public String toString() {
        String salida = "";
        for (int i = 0; i < this.fichas.length; i++) {
            salida= salida + fichas[i];
        }

        return salida;
    }
}
