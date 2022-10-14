package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a= new Animal ("Ardilla", "Bosque", 0.10);
		AnimalDAO.insertarAnimal(a);
	}

}
