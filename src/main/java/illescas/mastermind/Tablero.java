package illescas.mastermind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tablero
 */
public class Tablero {

    private static final int MAX_JUGADAS = 10;
    public Jugada jugadaSecreta;
    public ArrayList<JugadaPropuesta> jugadasPropuestas;
    private Scanner scanner;
    private Resultado resultado;

    public Tablero(){
        this.jugadasPropuestas = new ArrayList<JugadaPropuesta>();
        this.scanner = new Scanner(System.in);
    }

    public void start(){

        System.out.println("----- MASTERMIND -----");

        try {
            this.jugadaSecreta = new JugadaSecreta();
        } catch (Exception e) {
            //Nunca debe pasar por aquí
        }


        int num_movimientos = 0;
        boolean haGanado = false;
        //TODO config
        while (MAX_JUGADAS > num_movimientos && !haGanado) {
            System.out.println(this.jugadasPropuestas.size() + " attempt(s):");
            for (JugadaPropuesta fila : this.jugadasPropuestas) {
                System.out.println(fila);
            }
            System.out.println(this.jugadaSecreta);
            JugadaPropuesta propuesta = leerJugadaPropuesta("Propose a combination:");
            resultado = jugadaSecreta.checkJugada(propuesta);
            propuesta.setResultado(resultado);
            this.jugadasPropuestas.add(propuesta);
            haGanado = resultado.haGanado();
            num_movimientos++;
        }
        //Fin del juego
        this.scanner.close();
    }

    private JugadaPropuesta leerJugadaPropuesta(String mensaje) {
        JugadaPropuesta leida = null;
        System.out.println(mensaje);
        while(leida==null) {
            try {
                leida = this.leerJugada();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return leida;
    }

    private JugadaPropuesta leerJugada() throws Exception {

        String lectura = scanner.next();
        return new JugadaPropuesta(lectura);
    }


}
