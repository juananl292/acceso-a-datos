package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AnimalDAO {
	private static Connection connection;
	//Buscar animal por id
	
	public static Animal findById (int id) {
		
		connection = openConnection();
		String query="select * from animales where id = ?";
		Statement statement;
		Animal animal=null;
		
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
		while(rs.next()) {
			 animal= new Animal(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("habitat"),
					rs.getDouble("peso_aproximado"));
		}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
		
		return animal;
	}
	
	//Borrar un animal segun nombre
	public static void deleteAnimalByNombre(String nombre) {
		connection = openConnection();
		String query="delete from animales where nombre = '" + nombre + "'";
		Statement statement;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
	}
	
	
	//Borrar todos los animales
	public static void deleteAllAnimal() {
		connection = openConnection();
		
		String query="delete from animales";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
	}
	
	
	
	
	//Insertar un animal
	public static void insertarAnimal(Animal animal) {
		connection = openConnection();
		String query= "insert into animales (nombre, habitat, peso_aproximado )values(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setDouble(3, animal.getPeso_aproximado());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection =dbConnection.getConnection();
		return connection;
	}
	private static void closeConnection() {
		
		try {
			connection.close();
			connection=null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
