package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DatabaseConnection;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada>{
	private static Connection connection;
	@Override
	
	public ArrayList<Temporada> buscarTodos() {
		connection = openConnection();

		String query = "Select * from series";
		Temporada temporada = null;
		ArrayList<Temporada> listaTemporadas = new ArrayList<Temporada>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			
			while (rs.next()) {
				
			SerieDao serieDao=new SerieDao();
			Serie s=serieDao.buscarPorId(0);
			
				temporada = new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporadas"),
						rs.getString("titulo"),
						s);
				listaTemporadas.add(temporada);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaTemporadas;
		
	}
	
	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Temporada t) {
		connection = openConnection();
		String query= "insert into temporadas (num_temporadas,titulo,serie_id) values (?,?,?)";
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, t.getNum_temporada());
			ps.setString(2, t.getTitulo());
			ps.setInt(3, t.getSerie().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void modificar(Temporada temporada) {
connection = openConnection();
		
		String query="UPDATE temporadas SET id= ?, num_temporadas= ?, titulo= ?, serie_id= ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, temporada.getId());
			ps.setInt(2, temporada.getNum_temporada());
			ps.setString(3, temporada.getTitulo());
			ps.setInt(4, temporada.getSerie().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}

	@Override
	public void borrar(Temporada temporada) {
connection = openConnection();
		
		String query= "delete from temporadas where serie_id="+temporada.getSerie().getId();
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		closeConnection();
		
	}
	
}
