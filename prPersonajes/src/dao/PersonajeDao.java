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
		ArrayList<Objeto>objetos=new ArrayList<Objeto>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				personaje = new Personaje(rs.getInt("id"), 
						rs.getString("nombre"), 
						rs.getString("sexo"),
						rs.getInt("vida"),
						objetos
						);
				
				String query_objeto="select * from objetos where personaje_id=?";
				PreparedStatement ps_objetos = connection.prepareStatement(query_objeto);
				ps_objetos.setInt(1, rs.getInt("id"));
				ResultSet rs_objetos = ps_objetos.executeQuery();

				while (rs_objetos.next()) {
					Objeto objeto = new Objeto(
							rs_objetos.getInt("id"), 
							rs_objetos.getString("nombre"),
							rs_objetos.getInt("cantidad"),
							personaje
							);
					objetos.add(objeto);
				}
				
				personaje.setObjetos(objetos);
				listaPersonajes.add(personaje);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return listaPersonajes;
	}
	public Personaje buscarPorNombre(String nombre) {
		connection = openConnection();
		String query = "select * from personajes where nombre = ?";
		Statement statement;
		Personaje personaje = null;

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
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
		closeConnection();
		return personaje;
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
		closeConnection();
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
	public void borrar(Personaje personaje) {
		
		int personaje_id = personaje.getId();

		UbjetoDao temp = new UbjetoDao();
		temp.borrarPorPersonaje(personaje_id);

		connection = openConnection();
		String query = "delete from personajes where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, personaje_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}
	public void vaciarTablas() {
		connection = openConnection();
		String query = "TRUNCATE TABLE objetos";
		try {
			Statement st= connection.prepareStatement(query);
			st.executeUpdate(query);
			String query2 = "TRUNCATE TABLE objetos";
			 st= connection.prepareStatement(query2);
			st.executeUpdate(query2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

}
