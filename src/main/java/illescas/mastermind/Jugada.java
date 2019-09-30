package illescas.mastermind;


/**
 * Jugada
 */
public class Jugada {

    public Color[] fichas;
    final static int NUMERO_POSICIONES = 4;

    public Jugada(String fichas) throws Exception {
        if(fichas.length() != this.NUMERO_POSICIONES){
            throw new Exception("Wrong proposed combination length");
        }
        this.fichas = new Color[Jugada.NUMERO_POSICIONES];
        try {
            for (int i = 0; i < fichas.length(); i++){
                this.fichas[i] = Color.valueOf(Character.toString(fichas.charAt(i)).toUpperCase());
            }
        } catch (IllegalArgumentException e) {
            throw new Exception("Wrong colors, they must be: rbygop");
        }
    }


    public String toString() {
        String salida = "";
        for (int i = 0; i < this.fichas.length; i++) {
            salida= salida + fichas[i];
        }

        return salida;
    }
}
