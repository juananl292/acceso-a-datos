package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a= new Animal ("Ardilla", "Bosque", 0.10);
		Animal b= new Animal ("mono", "Selva", 1.10);
		AnimalDAO.insertarAnimal(a);
		AnimalDAO.insertarAnimal(b);
		//AnimalDAO.deleteAllAnimal();
		AnimalDAO.deleteAnimalByNombre("mono");
		
		System.out.println(AnimalDAO.findById(7));
	}

}
