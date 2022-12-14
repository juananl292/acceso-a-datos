package main;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import dao.PersonajeDao;
import dao.UbjetoDao;
import pojo.Objeto;
import pojo.Personaje;

public class Main {

	public static void main(String[] args) {
		
		PersonajeDao personajeDao= new PersonajeDao();
		UbjetoDao objetoDao= new UbjetoDao();
		Personaje p1 = new Personaje("Cloud","H",100);
		Objeto o= new Objeto("Pala",2,p1);
		personajeDao.insertar(p1);
		objetoDao.insertar(o);
		
		
		/*Personaje p2= new Personaje("Goku","H",100);
		Personaje p3= new Personaje("Peach","M",100);
		
		
		
		Objeto o1= new Objeto("Escudo",4,p1);
		Objeto o2= new Objeto("Ropa",1,p2);
		Objeto o3= new Objeto("Baston",1,p2);
		Objeto o4= new Objeto("Nube",1,p3);
		Objeto o5= new Objeto("Paraguas",2,p3);
		Objeto o6= new Objeto("Guantes",3,p3);
		System.out.println("Personajes y objetos creados");
		
		TimeUnit.SECONDS.sleep(3);
			
		personajeDao.insertar(p1);
		personajeDao.insertar(p2);
		personajeDao.insertar(p3);
		System.out.println("Personajes insertados en base de datos, mostrando: ");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(personajeDao.buscarTodos());
		
		objetoDao.insertar(o);
		objetoDao.insertar(o1);
		objetoDao.insertar(o2);
		objetoDao.insertar(o3);
		objetoDao.insertar(o4);
		objetoDao.insertar(o5);
		objetoDao.insertar(o6);
		
		System.out.println("Objetos insertados en base de datos y a los personajes, mostrando: ");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(objetoDao.buscarTodos());*/
		
		
	
	}

}
