package de.dhbw.javaproject.notizverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import de.dhbw.javaproject.notizverwaltung.model.Notiz;


public class DBAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public List<Notiz> getNotizen() throws Exception {
		try {
			
			List<Notiz> notizListe = new LinkedList<Notiz>();
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/notizbuch?" + "user=root");
			
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from notizbuch.notizen");
			
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String inhalt = resultSet.getString("notiz");
				
				Notiz notiz = new Notiz();
				notiz.setID(Integer.parseInt(id));
				notiz.setInhalt(inhalt);
				
				notizListe.add(notiz);
			}
			
			return notizListe;
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public void updateNotiz(int id, String inhalt) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/notizbuch?" + "user=root");
			
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			statement.executeUpdate("UPDATE notizbuch.notizen SET notiz='" + inhalt + "' WHERE id = " + id + ";");
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public void addNotiz(String notiz) throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/notizbuch?" + "user=root");
			
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			statement.executeUpdate("INSERT INTO notizbuch.notizen values (default, '" + notiz + "' );");
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}