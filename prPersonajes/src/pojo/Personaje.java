package pojo;

import java.util.ArrayList;

public class Personaje {
	private int id;
	private String nombre;
	private String sexo;
	private int vida;
	ArrayList<Objeto> objetos;
	public Personaje(String nombre, String sexo, int vida, ArrayList<Objeto> objetos) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.vida = vida;
		this.objetos = objetos;
	}
	public Personaje(int id, String nombre, String sexo, int vida, ArrayList<Objeto> objetos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.vida = vida;
		this.objetos = objetos;
	}

	public Personaje(int id, String nombre, String sexo, int vida) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.sexo = sexo;
		this.vida = vida;
	}
	public Personaje( String nombre, String sexo, int vida) {
		super();
		
		this.nombre = nombre;
		this.sexo = sexo;
		this.vida = vida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}
	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + ", vida=" + vida + ", objetos="
				+ objetos + "]";
	}
	
}
