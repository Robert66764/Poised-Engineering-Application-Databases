
/**
 * This class is used for the project details.
 * 
 * <p> The methods are designed to insert data into the database
 * about the project, customer, architect and the contractor. 
 * <p>
 *
 */

//Creating the class Project and the variables associated with it.
public class project {
	int projNum;
	String projName;
	String buildingDesign;
	String physicalAddress;
	int ERFnumber;
	double totalFee;
	double totalpaidtoDate;
	String dueDate;
	String finalized;
	String Overdue;

	// Objects of the person class
	person customer;
	person architect;
	person contractor;

	// Creating the constructor for the class project.
	public project(int projNum, String projName, String buildingDesign, String physicalAddress, int ERFnumber,
			double totalFee, double totalpaidtoDate, String dueDate, String finalized, String Overdue, person customer,
			person architect, person contractor) {
		this.projNum = projNum;
		this.projName = projName;
		this.buildingDesign = buildingDesign;
		this.physicalAddress = physicalAddress;
		this.ERFnumber = ERFnumber;
		this.totalFee = totalFee;
		this.totalpaidtoDate = totalpaidtoDate;
		this.dueDate = dueDate;
		this.customer = customer;
		this.architect = architect;
		this.contractor = contractor;
		this.finalized = finalized;
		this.Overdue = Overdue;
		new JDBCWriter(this);
	}

	// The getters and setters of the project.
	public int getProjNum() {
		return projNum;
	}

	public person getCustomer() {
		return customer;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getBuildingDesign() {
		return buildingDesign;
	}

	public void setBuildingDesign(String buildingDesign) {
		this.buildingDesign = buildingDesign;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public int getERFnumber() {
		return ERFnumber;
	}

	public void setERFnumber(int eRFnumber) {
		ERFnumber = eRFnumber;
	}

	public void setProjNum(int projNum) {
		this.projNum = projNum;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public person getArchitect() {
		return architect;
	}

	public person getContractor() {
		return contractor;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public double getTotalpaidtoDate() {
		return totalpaidtoDate;
	}

	public void setTotalpaidtoDate(double totalpaidtoDate) {
		this.totalpaidtoDate += totalpaidtoDate;
	}

	public String getFinalized() {
		return finalized;
	}

	public void setFinalized(String finalized) {
		this.finalized = finalized;
	}

	public String getOverdue() {
		return Overdue;
	}

	public void setOverdue(String overdue) {
		Overdue = overdue;
	}

	// Creating a toFile Method.
	public String toFile() {
		return projNum + ", " + projName + ", " + buildingDesign + ", " + physicalAddress + ", " + ERFnumber + ", "
				+ totalFee + ", " + totalpaidtoDate + ", " + dueDate + ", " + finalized + "\n" + customer.toFile()
				+ "\n" + architect.toFile() + "\n" + contractor.toFile();
	}

	// A method to insert the data into the project database.
	public String toDatabase() {
		String outs = "INSERT INTO PoiseDataBase (ProjectNumber, ProjectName, BuildingDesign, PhysicalAddress, ERFNumber, TotalFee, TotalPaidToDate, DueDate, Finalized, Overdue) values(";
		outs += projNum;
		outs += ", '" + projName + "'";
		outs += ", '" + buildingDesign + "'";
		outs += ", '" + physicalAddress + "'";
		outs += ", " + ERFnumber;
		outs += ", " + totalFee;
		outs += ", " + totalpaidtoDate;
		outs += ", '" + dueDate + "'";
		outs += ", '" + finalized + "'";
		outs += ", '" + Overdue + "'";
		outs += ")";
		return outs;
	}

	// A method to insert data into the architect database.
	public String toArchitectDataBase() {
		String output = "INSERT INTO architect (FirstName, LastName, TelephoneNumber, EmailAddress, PhysicalAddress,ProjectNumber) values(";
		output += architect.toFile();
		output += projNum + " )";
		return output;
	}

	// A method to insert data into the contractor database.
	public String toContractorDataBase() {
		String out = "INSERT INTO contractor(FirstName, LastName, TelephoneNumber, EmailAddress,PhysicalAddress,ProjectNumber) values(";
		out += contractor.toFile();
		out += projNum + " )";
		return out;
	}

	// A method to insert data into the customer database.
	public String toCustomerDataBase() {
		String outsput = "INSERT INTO customer(FirstName,LastName, TelephoneNumber, EmailAddress, PhysicalAddress,ProjectNumber) values(";
		outsput += customer.toFile();
		outsput += projNum + " )";
		return outsput;
	}
}