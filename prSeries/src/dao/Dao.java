package dao;

import java.util.ArrayList;

public interface Dao<T> {
	
	public ArrayList<T> buscarTodos();
	
	public T buscarPorId(int i);
	
	public void insertar(T t);
	
	public void modificar(T t);
	
	public void borrar(T t);
	
	
}
