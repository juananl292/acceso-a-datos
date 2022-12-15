package main;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import dao.PersonajeDao;
import dao.UbjetoDao;
import pojo.Objeto;
import pojo.Personaje;

public class Main {

	public static void main(String[] args) {
		
		
		try {
		
		PersonajeDao personajeDao= new PersonajeDao();
		UbjetoDao objetoDao= new UbjetoDao();
		personajeDao.vaciarTablas();
	
		Personaje p1 = new Personaje("Himaguari","M",100);
		Personaje p2= new Personaje("Goku","H",100);
		Personaje p3= new Personaje("Peach","M",100);
		
		
		personajeDao.insertar(p1);
		personajeDao.insertar(p2);
		personajeDao.insertar(p3);
		
		
		p1=personajeDao.buscarPorId(1);
		p2=personajeDao.buscarPorId(2);
		p3=personajeDao.buscarPorId(3);
		
		Objeto o= new Objeto("Pala",2,p1);
		Objeto o1= new Objeto("Escudo",4,p1);
		Objeto o2= new Objeto("Ropa",1,p2);
		Objeto o3= new Objeto("Baston",1,p2);
		Objeto o4= new Objeto("Diadema",1,p3);
		Objeto o5= new Objeto("Paraguas",2,p3);
		Objeto o6= new Objeto("Guantes",3,p3);
		System.out.println("Personajes y objetos creados");
		System.out.println("------------------------------------------------");
		System.out.println("Personajes insertados en base de datos, mostrando: ");
		System.out.println(personajeDao.buscarTodos());		
		objetoDao.insertar(o);
		objetoDao.insertar(o1);
		objetoDao.insertar(o2);
		objetoDao.insertar(o3);
		objetoDao.insertar(o4);
		objetoDao.insertar(o5);
		objetoDao.insertar(o6);
		System.out.println("------------------------------------------------");
		System.out.println("Objetos insertados en base de datos, mostrando: ");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(objetoDao.buscarTodos());
		System.out.println("------------------------------------------------");
		System.out.println("Buscamos un personaje por nombre que es unique en base de datos:..Buscando Goku:");
		System.out.println(personajeDao.buscarPorNombre("Goku"));
		System.out.println("------------------------------------------------");
		System.out.println("ahora le vamos a cambiar el nombre a Goku por Midoriya y lo vamos a mostrar de la base de datos");
		p2.setNombre("Midoriya");
		personajeDao.modificar(p2);
		System.out.println(personajeDao.buscarPorNombre("Midoriya"));
		System.out.println("------------------------------------------------");
		System.out.println("A continuacion vamos a mostrar los objetos que tiene el personaje: Pecah");
		System.out.println("Mostrando:....");
		System.out.println(personajeDao.obtenerObjeto(p3));
		System.out.println("------------------------------------------------");
		System.out.println("Ahora vamos a borrar a un personaje de la base de datos: Borrando Himaguari...");
		personajeDao.borrar(p1);
		System.out.println("Personajes de la base de datos actual:");
		System.out.println(personajeDao.buscarTodos());
		System.out.println("Vamos a buscar un objeto por su id: Buscando Baston de Goku que ha sido modificado con el nombre de Midoriya");
		System.out.println(objetoDao.buscarPorId(4));
		System.out.println("Modificando cantidad de bastones a 3..");
		o3=objetoDao.buscarPorId(4);
		o3.setCantidad(3);
		objetoDao.modificar(o3);
		System.out.println(objetoDao.buscarPorId(4));
		System.out.println("------------------------------------------------");
		System.out.println("Vamos a borrar un objeto: Borrando Baston...");
		o3=objetoDao.buscarPorId(4);
		objetoDao.borrar(o3);
		System.out.println("Mostrando Objetos de base de datos actual:...");
		System.out.println(objetoDao.buscarTodos());
		System.out.println("------------------------------------------------");
		System.out.println("Ahora vamos a borrar los objetos del personaje, en este caso la diadema de Peach:..Borrando..");
		p3=personajeDao.buscarPorId(3);
		objetoDao.borrarPorPersonaje(p3.getId());
		System.out.println(objetoDao.buscarTodos());
		System.out.println("-------------------------\n"+
				"|                        |\n"+
				"|      =======           |\n"+
				"|      ||      ||\\    || |\n"+
				"|      ||== || ||  \\  || |\n"+
				"|      ||   || ||    \\|| |\n"+
				"--------------------\n");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
	}

}
