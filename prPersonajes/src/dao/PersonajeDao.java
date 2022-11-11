package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Objeto;
import pojo.Personaje;






public class PersonajeDao extends ObjetoDao implements InterfazDao<Personaje>{
	private static Connection connection;
	public PersonajeDao() {
		
	}
	@Override
	public ArrayList<Personaje> buscarTodos() {
		connection = openConnection();

		String query = "Select * from personajes";
		Personaje personaje = null;
		ArrayList<Personaje> listaPersonajes = new ArrayList<Personaje>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				personaje = new Personaje(rs.getInt("id"), 
						rs.getString("nombre"), 
						rs.getString("sexo"),
						rs.getInt("vida"));
				listaPersonajes.add(personaje);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return listaPersonajes;
	}

	@Override
	public Personaje buscarPorId(int i) {
		connection = openConnection();
		String query = "select * from personajes where id = ?";
		Statement statement;
		Personaje personaje = null;

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				personaje = new Personaje(rs.getInt("id"), 
						rs.getString("nombre"), 
						rs.getString("sexo"),
						rs.getInt("vida")
						);
				personaje.setObjetos(obtenerObjeto(personaje));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personaje;
	}
	
	
	public ArrayList<Objeto> obtenerObjeto(Personaje personaje){
		ArrayList<Objeto> objetos = new ArrayList<>();
		connection = openConnection();
		String query = "Select * From objetos Where personaje_id=?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, personaje.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Objeto objeto= new Objeto(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("cantidad"),
						personaje);
				objetos.add(objeto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objetos;
	}
	@Override
	public void insertar(Personaje t) {
		connection = openConnection();
		String query = "insert into personajes (nombre,sexo,vida)" + "values (?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2,t.getSexo());
			ps.setInt(3, t.getVida());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}

	@Override
	public void modificar(Personaje t) {
connection = openConnection();
		
		String query="UPDATE personajes SET nombre= ?, sexo= ?, vida= ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getSexo());
			ps.setInt(3, t.getVida());
			ps.setInt(4, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}

	@Override
	public void borrar(Personaje t) {
		// TODO Auto-generated method stub
		
	}

}
