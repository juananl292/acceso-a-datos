package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Objeto;

public class UbjetoDao extends ObjetoDao implements InterfazDao<Objeto>{
	private static Connection connection;
	@Override
	public ArrayList<Objeto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Objeto buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
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
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void borrar(Objeto t) {
		// TODO Auto-generated method stub
		
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
