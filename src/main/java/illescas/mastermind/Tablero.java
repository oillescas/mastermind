package illescas.mastermind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tablero
 */
public class Tablero {

    private static final int MAX_JUGADAS = 10;
    public JugadaSecreta jugadaSecreta;
    public ArrayList<JugadaPropuesta> jugadasPropuestas;
    private Scanner scanner;
    private Resultado resultado;

    public Tablero(){
        inicializarTablero();
    }

    private void inicializarTablero() {
        this.jugadasPropuestas = new ArrayList<JugadaPropuesta>();
        this.scanner = new Scanner(System.in);
    }

    public void play(){
        boolean continuar = true;
        while(continuar) {
            start();
            System.out.println("Do you want to continue? (s/n):");
            String entrada = scanner.next();
            continuar = "s".equals(entrada) || "S".equals(entrada);
            inicializarTablero();
        }
        this.scanner.close();
    }

    public void start(){

        System.out.println("----- MASTERMIND -----");

        try {
            this.jugadaSecreta = new JugadaSecreta();
        } catch (Exception e) {
            //Nunca debe pasar por aquí
        }

        boolean haGanado = false;

        pintarTablero();

        while (MAX_JUGADAS > this.jugadasPropuestas.size()  && !haGanado) {
            JugadaPropuesta propuesta = leerJugadaPropuesta("Propose a combination:");
            resultado = jugadaSecreta.checkJugada(propuesta);
            propuesta.setResultado(resultado);
            this.jugadasPropuestas.add(propuesta);
            haGanado = resultado.haGanado();
            pintarTablero();
        }

        if(haGanado){
            System.out.println("You've won!!! ;-)");
        } else {
            System.out.println("You've lost!!! :-(");
        }
    }

    private void pintarTablero() {
        System.out.println(this.jugadasPropuestas.size() + " attempt(s):");
        for (JugadaPropuesta fila : this.jugadasPropuestas) {
            System.out.println(fila);
        }
        System.out.println(this.jugadaSecreta);
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
