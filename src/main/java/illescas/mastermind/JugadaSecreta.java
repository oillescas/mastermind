package illescas.mastermind;

import java.util.Random;

/**
 * JugadaSecreta
 */
public class JugadaSecreta  extends Jugada {

    public JugadaSecreta() throws Exception {
        super(jugadaAleatoria());
    }


    private static String jugadaAleatoria() {
        String jugada = "";
        for (int i = 0; i < Jugada.NUMERO_POSICIONES; i++) {
            Color a = Color.values()[numeroAleatorio()];
            jugada = jugada+a.getClave();
        }
        return jugada;
    }


    public String toString() {
        return "****";
    }

    public Resultado checkJugada(Jugada prueba) {

        int blancos = chekBlancos(prueba);
        int negros = checkNegros(prueba);
        boolean ganador = blancos == this.NUMERO_POSICIONES;

        return new Resultado(blancos, negros, ganador);
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

    private static int numeroAleatorio() {
        Random r = new Random();
        return r.nextInt(Color.values().length-1) + 0;
    }

}
