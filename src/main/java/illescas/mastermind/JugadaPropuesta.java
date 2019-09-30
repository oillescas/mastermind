package illescas.mastermind;

/**
 * JugadaPropuesta
 */
public class JugadaPropuesta extends Jugada {

    public Resultado result;

    public JugadaPropuesta(String fichas) throws Exception {
        super(fichas);
    }

    public Resultado getResultado(){
        return this.result;
    }

    public void setResultado(Resultado resultado){
        this.result = resultado;
    }

    public String toString() {
        return super.toString() + "--> "+ result;
    }
}
