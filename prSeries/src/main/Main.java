package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		SerieDao serieDao= new SerieDao();
		//Serie serie2 = new Serie("Los Rugrats",7,"HBO");
//		serieDao.insertar(serie);
		//System.out.println(serieDao.buscarPorId(1));
		//Serie serie= serieDao.buscarPorId(1);	
		//System.out.println(serie);
		//serie.setTitulo("paprica");
//		System.out.println( serie.getTitulo());
		//serieDao.modificar(serie);
//		System.out.println(serieDao.buscarPorId(1));
		//Temporada t1 = new Temporada(1,"Temporada 1", serie);
//		Temporada t2 = new Temporada(2,"Temporada 2", serie);
//		
		//TemporadaDao temporadaDao= new TemporadaDao();
		//Temporada tempo=temporadaDao.buscarPorId(15);
		//temporadaDao.borrar(tempo);
		//temporadaDao.insertar(t1);
		//temporadaDao.insertar(t2);
		
		//Serie los_simpson =serieDao.buscarPorId(1); 
		//Serie s=serieDao.buscarPorId(5);
		//Temporada t1= new Temporada(1,"simpsons season 1",s);
//		Temporada t2= new Temporada(1,"simpsons season 2",s);
//		Temporada t3= new Temporada(1,"simpsons season 3",s);
//		temporadaDao.insertar(t1);
//		temporadaDao.insertar(t2);
//		temporadaDao.insertar(t3);
		//temporadaDao.borrarPorSerie(2);
		//serieDao.borrar(s);
		ArrayList<Serie>series=serieDao.buscarTodos();
		
		for(Serie serie:series) {
			System.out.println("Serie: "+ serie.getTitulo());
			for(Temporada temporada:serie.getTemporadas()) {
				System.out.println("Temporada: "+temporada.getTitulo());
			}
		}
		
	}

}
