import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *This is a class to read from the database.
 *
 *<p> 
 *The methods perform various tasks such as viewing all the projects,
 *viewing the incomplete projects, viewing the overdue projects, viewing all of the projects,
 *viewing specific projects, viewing the project number as well as viewing the project name.
 *<p>
 *
 *<p> Furthermore, updates of the total paid to date by the customer, finalization of a project and the completion date are all accomplished by these methods.
 * The calculation of the  invoice is another task of one of the methods.  
 * <p>
 */

public class JDBCReader {

	// Declaring variables.
	private Statement statement;
	private Connection connection;
	ResultSet results;

	// Creating the constructor.
	public JDBCReader() {

		// Connecting to the SQL database.
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS", "root", "Chinatown69!");
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to view the incomplete projects.
	public void viewIncompleteProject() {

		// A query to the database to select all the projects that have not been
		// finalized.
		String query = "select * from poisedatabase where finalized = 'no';";

		try {
			results = statement.executeQuery(query);

			// Displaying a message to the user.
			System.out.println(
					("(Project Number, Project Name, Building Design, Physical Address, ERF Number, Total Fee,Total paid to date, Due date, Finalized, Overdue)"));
			while (results.next()) {

				// Displaying each column values of the project.
				System.out.println(results.getInt("ProjectNumber") + ", " + results.getString("ProjectName") + ", "
						+ results.getString("BuildingDesign") + ", " + results.getString("PhysicalAddress") + ", "
						+ results.getInt("ERFNumber") + ", " + results.getDouble("TotalFee") + ", "
						+ results.getDouble("TotalPaidToDate") + ", " + results.getString("DueDate") + ", "
						+ results.getString("Finalized") + ", " + results.getString("Overdue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method for the overdue projects from the database.
	public void viewOverDueProject() {

		// A query to the database where the projects are overdue.
		String query = "select * from poisedatabase where Overdue = 'yes';";

		try {
			results = statement.executeQuery(query);

			// Displaying a message to the user.
			System.out.println(
					("(Project Number, Project Name, Building Design, Physical Address, ERF Number, Total Fee,Total paid to date, Due date, Finalized, Overdue)"));
			while (results.next()) {

				// Displaying the column values to the user.
				System.out.println(results.getInt("ProjectNumber") + ", " + results.getString("ProjectName") + ", "
						+ results.getString("BuildingDesign") + ", " + results.getString("PhysicalAddress") + ", "
						+ results.getInt("ERFNumber") + ", " + results.getDouble("TotalFee") + ", "
						+ results.getDouble("TotalPaidToDate") + ", " + results.getString("DueDate") + ", "
						+ results.getString("Finalized") + ", " + results.getString("Overdue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to view all the projects.
	public void viewAllProjects() {

		// A query to select all the projects from the project database.
		String query = "select * from poisedatabase;";

		try {
			results = statement.executeQuery(query);

			// Displaying a message to the user.
			System.out.println(
					("(Project Number, Project Name, Building Design, Physical Address, ERF Number, Total Fee,Total paid to date, Due date, Finalized, Overdue, Completion Date)"));
			while (results.next()) {

				// Displaying the column values to the user.
				System.out.println(results.getInt("ProjectNumber") + ", " + results.getString("ProjectName") + ", "
						+ results.getString("BuildingDesign") + ", " + results.getString("PhysicalAddress") + ", "
						+ results.getInt("ERFNumber") + ", " + results.getDouble("TotalFee") + ", "
						+ results.getDouble("TotalPaidToDate") + ", " + results.getString("DueDate") + ", "
						+ results.getString("Finalized") + ", " + results.getString("Overdue") + ", "
						+ results.getString("CompletionDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to view the project based on the project number.
	public void viewSpecificProject(int n) {

		// A query to select a specific project with an associated project number,
		String query = "select * from poisedatabase where ProjectNumber = " + Integer.toString(n);

		try {
			results = statement.executeQuery(query);

			// Displaying a message to the user.
			System.out.println(
					("(Project Number, Project Name, Building Design, Physical Address, ERF Number, Total Fee,Total paid to date, Due date, Finalized, Overdue)"));
			while (results.next()) {

				// Displaying the column values to the user.
				System.out.println(results.getInt("ProjectNumber") + ", " + results.getString("ProjectName") + ", "
						+ results.getString("BuildingDesign") + ", " + results.getString("PhysicalAddress") + ", "
						+ results.getInt("ERFNumber") + ", " + results.getDouble("TotalFee") + ", "
						+ results.getDouble("TotalPaidToDate") + ", " + results.getString("DueDate") + ", "
						+ results.getString("Finalized") + ", " + results.getString("Overdue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to view only the project numbers from the database.
	public void viewProjectNumber() {

		// A query to select the project number from the project database.
		String query = "select ProjectNumber from poisedatabase;";
		try {
			results = statement.executeQuery(query);

			// Displaying a message to the user.
			System.out.println("Project Numbers:");
			while (results.next()) {
				{
					// Displaying the column numbers to the user.
					System.out.println(results.getInt("ProjectNumber"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to select the Project Name.
	public void viewProjectName() {

		// A query to the database to select only the project name from the database.
		String query = "select ProjectName from poisedatabase;";
		try {
			results = statement.executeQuery(query);

			// Displaying a message to the user.
			System.out.println("Project Names:");
			while (results.next()) {
				{
					// Displaying the project names to the user.
					System.out.println(results.getString("ProjectName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to view the project based on the project name.
	public void viewSpecificProjectName(String str) {

		// A query to the database to select the projects based upon the project name.
		String query = "select * from poisedatabase where ProjectName = " + "'" + str + "'";

		try {
			results = statement.executeQuery(query);

			// Displaying a message to the user.
			System.out.println(
					("(Project Number, Project Name, Building Design, Physical Address, ERF Number, Total Fee,Total paid to date, Due date, Finalized, Overdue)"));
			while (results.next()) {

				// Displaying the column values to the user.
				System.out.println(results.getInt("ProjectNumber") + ", " + results.getString("ProjectName") + ", "
						+ results.getString("BuildingDesign") + ", " + results.getString("PhysicalAddress") + ", "
						+ results.getInt("ERFNumber") + ", " + results.getDouble("TotalFee") + ", "
						+ results.getDouble("TotalPaidToDate") + ", " + results.getString("DueDate") + ", "
						+ results.getString("Finalized") + ", " + results.getString("Overdue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to update the total paid to date.
	public void updateTotalPaidToDate(double tp, int prj) {

		// A query to the database to update the total paid to the database when the
		// user inputs a specific project number.
		String query = "update poisedatabase set TotalPaidToDate = " + tp + " where ProjectNumber = " + prj;

		try {
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to update the project to finalized.
	public void updateFinalized(String f, int prj) {

		// A query to the databse to update a project to finalized based upon the
		// project number.
		String query = "update poisedatabase set Finalized = " + "'" + f + "'" + " where ProjectNumber = " + prj;

		try {
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to update the completion date if the project is finalized.
	public void updateCompletionDate(String comp, int prj) {

		// A query to the database to update the completion date based upon a project
		// number.
		String query = "update poisedatabase set CompletionDate = " + "'" + comp + "'" + " where ProjectNumber = "
				+ prj;
		try {
			int rowsAffected = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to close the statement, connection and results objects.
	public void close() {
		try {
			statement.close();
			connection.close();
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method used to calculate the invoice.
	public void calculatingInvoice(int n) {

		// Selecting the projects based upon the specific project number.
		String query = "select * from poisedatabase where ProjectNumber = " + Integer.toString(n);

		try {
			results = statement.executeQuery(query);

			while (results.next()) {

				// Accessing the column values in this case it is total fee and total paid to
				// date.
				double totalfee = results.getDouble("TotalFee");
				double totalPaidToDate = results.getDouble("TotalPaidToDate");

				// A variable for the invoice calculation.
				double invoice = totalfee - totalPaidToDate;

				// If the invoice is equal to 0 then no invoice can be generated.
				if (invoice == 0) {
					System.out.println("No invoice can be generated becuase the full amount has been paid.");
				}

				// If the invoice is not equal to 0 then an invoice amount is generated.
				else if (invoice != 0) {
					System.out.println("The invoice amount is: R " + invoice);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// A method to view the customer's details based upon the project number.
	public void viewCustomerDetails(int n) {

		// A query to the database to select all of the customer details based upon a
		// project number.
		String query = "select * from customer where ProjectNumber = " + Integer.toString(n);

		try {
			results = statement.executeQuery(query);

			// A message to the user about the customer's details.
			System.out.println(
					("(First Name,Last Name, Telephone Number,Email Address,Physical Address,Project Number)"));
			while (results.next()) {

				// Displaying each column value of the customer.
				System.out.println(results.getString("FirstName") + ", " + results.getString("LastName") + ", "
						+ results.getString("TelephoneNumber") + ", " + results.getString("EmailAddress") + ", "
						+ results.getString("PhysicalAddress") + ", " + results.getInt("ProjectNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

