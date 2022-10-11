package notizbuch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public void readDatabase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://192.168.64.2:3306/notizbuch","root","");
					// .getConnection("jdbc:mysql://192.168.64.2:3306/notizbuch?" + "user=root"/*&password=sqluserpw"*/);
					
	
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from notizbuch.notizen");
			writeResultSet(resultSet);
	
			// PreparedStatements can use variables and are more efficient
			preparedStatement = connect
					.prepareStatement("insert into  notizbuch.notizen values (default, ?)");
			// "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
			// Parameters start with 1
			preparedStatement.setString(1, "Test");
			preparedStatement.executeUpdate();
	
			preparedStatement = connect
					.prepareStatement("SELECT * from notizbuch.notizen");
			resultSet = preparedStatement.executeQuery();
			writeResultSet(resultSet);
	
			// Remove again the insert comment
			preparedStatement = connect.prepareStatement("delete from notizbuch.notizen where id= ? ; ");
			preparedStatement.setString(1, "2");
			preparedStatement.executeUpdate();
	
			resultSet = statement.executeQuery("select * from notizbuch.notizen");
			writeMetaData(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		// Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("Zeige Metadaten: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
		System.out.println("\n\n");
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		System.out.println("Zeige SQL-Antwort:");
		while (resultSet.next()) {
			String note = resultSet.getString("id");
			System.out.println("Note: " + note);
		}
		System.out.println("\n\n");
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
