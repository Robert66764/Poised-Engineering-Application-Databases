//Creating a Person class and the associated variables.

/**
 * This class is used to generate the details of the customer. 
 * 
 * <p> There are also specific methods of the customer that provide the 
 * details of the customer in a different format. 
 * <p>
 *
 */
public class person {
	String name;
	String lastName;
	String telephoneNumber;
	String emailAddress;
	String physicalAddress;

	// Creating the constructor
	public person(String name, String lastName, String telephoneNumber, String emailAddress, String physicalAddress) {
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
		this.lastName = lastName;
	}

	// Creating the getters and setters.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String TelephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	// Creating the toFile method.
	public String toFile() {
		return "'"+name+"'" + ", " + "'"+lastName+"'" + ", " + "'"+telephoneNumber+"'" + ", " + "'"+emailAddress+"'" + ", " + "'"+physicalAddress+"' , ";
	}

	// Creating the toString method.
	public String toString() {
		return "First Name: " + name + "\n" + "Last Name: " + lastName + "\n" + "Telephone Number: " + telephoneNumber
				+ "\n" + "Email Address: " + emailAddress + "\n" + "Physical Address: " + physicalAddress;
	}
}
