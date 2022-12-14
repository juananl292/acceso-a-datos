package pojo;

public class Objeto {
	private int id;
	private String nombre;
	private int cantidad;
	private Personaje personaje;
	public Objeto(String nombre, int cantidad, Personaje personaje) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.personaje = personaje;
	}
	public Objeto(int id,String nombre, int cantidad, Personaje personaje) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.personaje = personaje;
	}
	public Objeto() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Personaje getPersonaje() {
		return personaje;
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Objeto id=" + this.id + ", nombre=" + this.nombre + ", cantidad=" + this.cantidad + "\n";
	}
	
	
	
}
