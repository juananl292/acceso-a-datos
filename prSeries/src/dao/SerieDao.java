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

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {

	private static Connection connection;

	public SerieDao() {

	}

	//Buscar todas las series
	public ArrayList<Serie> buscarTodos() {
		connection = openConnection();

		String query = "Select * from series";
		Serie serie = null;
		ArrayList<Serie> listaSeries = new ArrayList<Serie>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), 
						rs.getString("titulo"), 
						rs.getInt("edad"),
						rs.getString("plataforma"));
				listaSeries.add(serie);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return listaSeries;
	}

	@Override
	public Serie buscarPorId(int i) {
		connection = openConnection();
		String query = "select * from series where id = ?";
		Statement statement;
		Serie serie = null;

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), 
						rs.getString("titulo"), 
						rs.getInt("edad"),
						rs.getString("plataforma")
						);
				serie.setTemporadas(obtenerTemporada(serie));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return serie;
	}

	@Override
	public void insertar(Serie serie) {
		// TODO Auto-generated method stub
		connection = openConnection();
		String query = "insert into series (titulo,edad,plataforma)" + "values (?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	@Override
	public void modificar(Serie serie) {
		
		connection = openConnection();
		
		String query="UPDATE series SET titulo= ?, edad= ?, plataforma= ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ps.setString(2, serie.getTitulo());
			ps.setInt(3, serie.getEdad());
			ps.setString(4, serie.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}
	
	public ArrayList<Temporada> obtenerTemporada(Serie serie){
		ArrayList<Temporada> temporadas = new ArrayList<>();
		connection = openConnection();
		String query = "Select * From temporadas Where serie_id=?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(0, serie.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Temporada temporada= new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporadas"),
						rs.getString("titulo"),
						serie);
				temporadas.add(temporada);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temporadas;
	}
	
	

	@Override
	public void borrar(Serie t) {
		connection = openConnection();
		
		String query= "delete from series where serie_id="+temporada.getSerie().getId();
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
