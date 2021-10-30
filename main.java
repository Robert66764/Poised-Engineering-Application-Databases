/*Research for the overdue date was conducted at the following links:
https://www.javatpoint.com/java-get-current-date
https://www.tutorialspoint.com/how-to-compare-two-dates-in-java
https://www.javatpoint.com/java-string-to-date
*/

//Importing Java libraries.
import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/** 
 *The main class includes various menus and provides functionality to the user. 
 *
 *<p> 
 *The main class includes various menus requesting user input about the project,
 *the customer, the contractor and the architect. 
 *<p>
 *
 *<p> 
 *The main method is used to produce the task that the user selects from the menu 
 *the options include adding a project, viewing all the projects, updating and finalizing projects,
 *viewing incomplete projects, viewing overdue projects and exiting from the menu. 
 *<p>
 */

//Creating the main class.
public class main {

	// Prompting the user to enter information.
	public static person getPerson(String type) {
		System.out.println("Please provide the first name of " + type);
		Scanner inputName = new Scanner(System.in);
		String name = inputName.nextLine();
		System.out.println("Please provide the last name of " + type);
		Scanner inputLastName = new Scanner(System.in);
		String lastName = inputLastName.nextLine();
		System.out.println("Please provide the telephone number. ");
		Scanner telephoneNumber = new Scanner(System.in);
		String newTelephoneNumber = telephoneNumber.nextLine();
		System.out.println("Please provide the email address. ");
		Scanner emailAddress = new Scanner(System.in);
		String newEmailAddress = emailAddress.nextLine();
		System.out.println("Please provide the physical address. ");
		Scanner physicalAddress = new Scanner(System.in);
		String newPhysicalAddress = physicalAddress.nextLine();

		// returning the attributes.
		return new person(name, lastName, newTelephoneNumber, newEmailAddress, newPhysicalAddress);
	}

	// Creating a method for the details of the project.
	public static project getProject() {
		System.out.println("Please provide the project number.");
		Scanner projNum = new Scanner(System.in);
		int newProjNum = projNum.nextInt();
		System.out.println("Please provide the project name.");
		Scanner projName = new Scanner(System.in);
		String newProjName = projName.nextLine();
		System.out.println("Please provide the building design.");
		Scanner buildingDesign = new Scanner(System.in);
		String newBuildingDesign = buildingDesign.nextLine();
		System.out.println("Please provide the physical address.");
		Scanner physicalAddress = new Scanner(System.in);
		String newPhysicalAddress = physicalAddress.nextLine();
		System.out.println("Please provide the ERF Number.");
		Scanner ERFNumber = new Scanner(System.in);
		Integer newERFNumber = ERFNumber.nextInt();
		System.out.println("Please provide the total fee.");
		Scanner totalFee = new Scanner(System.in);
		Double newTotalFee = totalFee.nextDouble();
		System.out.println("Please provide the total paid to date.");
		Scanner totalPaid = new Scanner(System.in);
		Double newTotalPaid = totalPaid.nextDouble();
		System.out.println("Please provide the due date of the project.(In the format of dd-mm-yyyy)");
		Scanner dueDate = new Scanner(System.in);
		String newDueDate = dueDate.nextLine();
		System.out.println("Is the project completed? (yes/no) ");
		Scanner finalized = new Scanner(System.in);
		String newFinalized = finalized.nextLine();
		System.out.println("Is the project overdue? (yes/no)");
		Scanner Overdue = new Scanner(System.in);
		String newOverdue = Overdue.nextLine();

		try {
			Date DueDate = new SimpleDateFormat("dd-MM-yyyy").parse(newDueDate);
		} catch (ParseException e) {
			System.out.println("Please enter the due date in the format: dd-mm-yyyy");
		}

		// getting the details of the customer, architect and contractor.
		person customer = getPerson("customer");
		person architect = getPerson("architect");
		person contractor = getPerson("contractor");

		/*
		 * Creating an if statement if no project name is provided then the project
		 * building and the customer's surname will be provided.
		 */
		if (newProjName.equals("")) {
			newProjName = newBuildingDesign + " " + customer.getLastName();
		}

		// returning the various variables.
		return new project(newProjNum, newProjName, newBuildingDesign, newPhysicalAddress, newERFNumber, newTotalFee,
				newTotalPaid, newDueDate, newFinalized, newOverdue, customer, architect, contractor);
	}

	// Creating the main method.
	public static void main(String args[]) {

		while (true) {

			// Displaying a menu to the user.
			System.out.println("\nPlease select an option from the menu.");
			System.out.println("1 - Add Project");
			System.out.println("2 - View Project List");
			System.out.println("3 - Update and finalize project details");
			System.out.println("4 - Projects overdue");
			System.out.println("5 - View Incomplete Projects");
			System.out.println("6 - View a specific project");
			System.out.println("7 - Exit");

			// Creating user input.
			Scanner inputMenu = new Scanner(System.in);
			Integer inputMenuChoice = inputMenu.nextInt();

			// If the user selects 1 from the menu a new project will be created.
			if (inputMenuChoice == 1) {
				project projectInfo = getProject();
			}

			// Viewing the project List if the user selects 2 from the menu.
			else if (inputMenuChoice == 2) {

				// Displaying a message to the user.
				System.out.println("All the projects:");
				JDBCReader projectAll = new JDBCReader();
				projectAll.viewAllProjects();

				projectAll.close();
			}

			// Updating to the file if the user selects 3.
			else if (inputMenuChoice == 3) {

				// Creating a JDBC Reader object.
				JDBCReader projSelection = new JDBCReader();

				// Displaying a message to the user.
				System.out.println("All projetcs:\n");

				projSelection.viewAllProjects();
				projSelection.close();

				/*
				 * Creating a menu for various options to select as well as a scanner for user
				 * input.
				 */
				System.out.println("\nPlease select an option from the menu.\n");
				System.out.println("1 - Change the total amount of the fee paid to date.\n");
				System.out.println("2 - Finalise existing projects.");
				Scanner userInput = new Scanner(System.in);
				String newUserInput = userInput.nextLine();

				// Asking the user to enter the project number.
				System.out.println("\nPlease enter the Project Number.");
				Scanner inputNum = new Scanner(System.in);
				int newInputNum = inputNum.nextInt();

				projSelection = new JDBCReader();

				// Calling the method to view a specific project based upon the project number.
				projSelection.viewSpecificProject(newInputNum);
				projSelection.close();

				// If the user selects 1 then the total fee is updated.
				if (newUserInput.equals("1")) {
					System.out.print("\nHow much of the total fee would you like to be paid ? (Example: R100,00) \nR");
					Scanner userInputFeePaid = new Scanner(System.in);

					// Creating a try-catch block if the user does not enter a number.
					try {

						double newUserInputFeePaid = userInputFeePaid.nextDouble();

						// Creating an objection.
						projSelection = new JDBCReader();

						// Passing parameters to the method to update the total paid to date.
						projSelection.updateTotalPaidToDate(newUserInputFeePaid, newInputNum);

					} catch (Exception e) {
						System.out.println("Error: Please enter the number again. (EG: R100,00)");
					}

					// Displaying a message to the user.
					System.out.println("Please enter 1 for a Project Invoice");
					Scanner inputFee = new Scanner(System.in);
					String newInputFee = inputFee.nextLine();

					// Generating the invoice.
					if (newInputFee.equals("1")) {

						// Calling the method to calculate the invoice.
						projSelection.calculatingInvoice(newInputNum);

						// Calling the method to view the customer's details.
						projSelection.viewCustomerDetails(newInputNum);
					}
				}

				// If the user selects 2 then the project is finalized.
				if (newUserInput.equals("2")) {
					System.out.println("Would you like  to finalize the project. (yes/no)");
					Scanner inputFinalization = new Scanner(System.in);
					String newInputFinalization = inputFinalization.nextLine();

					if (newInputFinalization.equals("yes")) {
						projSelection = new JDBCReader();
						projSelection.updateFinalized(newInputFinalization, newInputNum);

						System.out.println("What is the completion date ? (Please enter as dd-mm-yyyy)");
						Scanner inputCompletionDate = new Scanner(System.in);
						String newInputCompletionDate = inputCompletionDate.nextLine();

						projSelection = new JDBCReader();
						projSelection.updateCompletionDate(newInputCompletionDate, newInputNum);
					}
				}
			}

			// Displaying the overdue date if the user selects 4.
			else if (inputMenuChoice == 4) {

				// Displaying a message to the user.
				System.out.println("The following projects are overdue:");

				// Creating an object for the JDBC reader.
				JDBCReader jdbcOverdue = new JDBCReader();
				jdbcOverdue.viewOverDueProject();
				jdbcOverdue.close();
			}

			else if (inputMenuChoice == 5) {

				// Displaying a message to the user.
				System.out.println("The following projects are incomplete:");

				// Creating an object for the JDBC reader.
				JDBCReader jdbc = new JDBCReader();

				// Calling the method to view the incomplete projects.
				jdbc.viewIncompleteProject();

				jdbc.close();
			}

			// If the menu choice is 6 then the following will happen.
			else if (inputMenuChoice == 6) {

				// Displaying a message to the user to input a project number or a project name.
				System.out.println("Please enter the 1:Project Number or 2:Project Name.");
				Scanner inputChoice = new Scanner(System.in);
				int newInputChoice = inputChoice.nextInt();

				if (newInputChoice == 1) {

					// Creating a JDBC Reader object.
					JDBCReader projectSelection = new JDBCReader();

					// Invoking the method to display all of the project numbers;
					projectSelection.viewProjectNumber();

					// Asking the user to enter the project number.
					System.out.println("\nPlease enter the Project Number.");
					Scanner inputNum = new Scanner(System.in);
					int newInputNum = inputNum.nextInt();

					// Calling the method to view a specific project based upon the project number.
					projectSelection.viewSpecificProject(newInputNum);

					// Closing the connection,statement and results.
					projectSelection.close();
				}

				// If the user selects the project name then the following will happen.
				if (newInputChoice == 2) {

					// Creating a JDBC Reader Object.
					JDBCReader projSelection = new JDBCReader();
					projSelection.viewProjectName();

					// Asking the user to enter the project name.
					System.out.println("\nPlease enter the Project Name.");
					Scanner inputName = new Scanner(System.in);
					String newInputName = inputName.nextLine();

					// Calling the method to view a specific project based upon the project name.
					projSelection.viewSpecificProjectName(newInputName);
				}
			}

			// Exiting the program if the user selects 7.
			else if (inputMenuChoice == 7) {

				// Displaying a message to the user when the program is exited.
				System.out.println("\nThank you for using the app. Goodbye");
				break;
			}

			// Displaying a message to the user.
			System.out.println("\nSuccessfuly Updated to the database.\n");

			// Displaying a message to the user
			System.out.println("Welcome to the Poised Engineering App.");
			System.out.println("I shall require a few details.");
		}
	}
}
