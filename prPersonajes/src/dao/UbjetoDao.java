package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Objeto;
import pojo.Personaje;



public class UbjetoDao extends ObjetoDao implements InterfazDao<Objeto>{
	private static Connection connection;
	@Override
	public ArrayList<Objeto> buscarTodos() {
		connection = openConnection();

		String query = "Select * from objetos";
		Objeto objeto = null;
		ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			
			while (rs.next()) {
				
			PersonajeDao personajeDao=new PersonajeDao();
			Personaje p=personajeDao.buscarPorId(0);
			
				objeto = new Objeto(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("cantidad"),
						p);
				listaObjetos.add(objeto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaObjetos;
	}

	@Override
	public Objeto buscarPorId(int i) {
		connection = openConnection();
		String query = "select * from objetos where id = ?";
		Statement statement;
		Objeto objeto= new Objeto();

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PersonajeDao personajeDao=new PersonajeDao();
				int id_o=rs.getInt("id"); 
				String nombre_o=rs.getString("nombre"); 
				int cantidad_o=rs.getInt("cantidad");
				int id_o_p=rs.getInt("personaje_id");
				Personaje p=personajeDao.buscarPorId(id_o_p);
				objeto=new Objeto(id_o,nombre_o,cantidad_o,p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//closeConnection();
		return objeto;
	}

	@Override
	public void insertar(Objeto t) {
		connection = openConnection();
		String query= "insert into objetos (nombre,cantidad,personaje_id) values (?,?,?)";
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setInt(2, t.getCantidad());
			ps.setInt(3, t.getPersonaje().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	

	@Override
	public void modificar(Objeto t) {
		
connection = openConnection();
		
		String query="UPDATE objetos SET id= ?, nombre= ?, cantidad= ?, personaje_id= ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getNombre());
			ps.setInt(3, t.getCantidad());
			ps.setInt(4, t.getPersonaje().getId());
			ps.setInt(5, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void borrar(Objeto objeto) {
connection = openConnection();
		
		
		String query= "delete from objetos where id="+objeto.getId();
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
		
	}
	public void borrarPorPersonaje(int personaje_id) {
		connection=openConnection();
		String query="delete from objetos where personaje_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, personaje_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();
	}

}
