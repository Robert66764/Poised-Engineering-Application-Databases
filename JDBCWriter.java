
//Importing the java libraries.
import java.sql.*;
import java.util.*;

/**
 * This class is used to write to the database. 
 * 
 * <p> The architect,customer,contractor and project data
 * is written to the database. 
 * <p>
 * 
 * @author Robert Lindsay
 *
 */

//The JDBC Writer class to write to the database.
public class JDBCWriter {

	// Objects of the JDBC.
	private Statement statement;
	private Connection connection;
	project proj;

	// Creating the constructor.
	public JDBCWriter(project p) {

		// Creating object of the project.
		proj = p;

		// Connecting to the SQL database.
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS", "root", "Chinatown69!");
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.addNewProject();
		this.addNewArchitect();
		this.addNewContractor();
		this.addNewCustomer();
	}

	// A method to execute the update to the project database.
	public void addNewProject() {
		try {
			statement.executeUpdate(proj.toDatabase());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to execute the update to the architect database.
	public void addNewArchitect() {
		try {
			statement.executeUpdate(proj.toArchitectDataBase());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to execute the update to the contractor database.
	public void addNewContractor() {
		try {
			statement.executeUpdate(proj.toContractorDataBase());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to execute the update to the customer database.
	public void addNewCustomer() {
		try {
			statement.executeUpdate(proj.toCustomerDataBase());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


	

