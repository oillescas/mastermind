package illescas.mastermind;

public enum Color
{
    R("red","r"),
    B("blue","b"),
    Y("yellow","y"),
    G("green","g"),
    O("orange","o"),
    P("purple","p");

    private String nombre;
    private String clave;

	private Color (String nombre, String clave){
        this.nombre = nombre;
        this.clave = clave;
	}

	public String getNombre(){
        return this.nombre;
    }

    public String toString(){
        return clave;
    }
}
