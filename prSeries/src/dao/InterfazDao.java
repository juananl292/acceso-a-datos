package dao;

import java.util.ArrayList;

public interface InterfazDao<T> {
	/**
	 * Muestra todos los objetos T de la base de datos
	 * 
	 * @return Un ArrayList de objetos T 
	 */
	public ArrayList<T> buscarTodos();
	/**
	 * Muestra el objeto T con el id especificado
	 * 
	 * @param i 	el id del objeto T o 
	 * @return 		un objeto T 
	 */
	public T buscarPorId(int i);
	/**
	 * Insertar el objeto recibido en la base de datos
	 * 
	 * @param t un objeto T 
	 */
	public void insertar(T t);
	/**
	 * Actualiza el objeto T de la base de datos 
	 * 
	 * @param t		un objeto T 
	 */
	
	public void modificar(T t);
	/**
	 * Elimina el objeto T de la base de datos
	 * 
	 * @param t		un objeto T 
	 */
	public void borrar(T t);
	
	
}
