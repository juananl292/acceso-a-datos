package main;

import dao.SerieDao;
import pojo.Serie;

public class Main {

	public static void main(String[] args) {
		Serie serie = new Serie("Los Simpsons",7,"Disney Plus");
		SerieDao serieDao= new SerieDao();
		serieDao.insertar(serie);
		

	}

}
