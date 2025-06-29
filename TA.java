package taPayrollManagerSystem;

/*
 * Name: Daniel Son
 * UID: 119710265
 * "I pledge on my honor that I have not given or received any unauthorized
 * assistance on this assessment."
 * 
 * This class represents a TA. This class has two subclasses (UGTA and GradTA)
 * which specifies if a TA is an undergraduate student or a graduate student.
 * This class contains variables that are common between both undergraduate and
 * graduate TAs, including: first name, last name, hours worked, and projects
 * graded. This class contains methods that can manipulate a TA object, such as
 * adding hours worked, adding projects graded, and calculating paycheck.
 */

public abstract class TA {
	
	private String firstName;
	private String lastName;
	protected int hoursWorked;
	protected int projectsGraded;
	
	//EXPLANATION: constructor for creating a TA
	//PARAMETER: firstName, lastName - used to instantiate object
	//RETURN: none
	public TA(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = 0;
		this.projectsGraded = 0;
	}
	
	//EXPLANATION: checks if inputed firstName and lastName matches that of the
	//current object - used for the getIndex() method in LarryList.java
	//PARAMETER: firstName, lastName - used to check if name matches
	//RETURN: true if name matches, false otherwise
	public boolean nameMatches(String firstName, String lastName) {
		if (this.firstName.equals(firstName) &&
		this.lastName.equals(lastName)) {
			return true;
		}
		return false;
	}
	
	//EXPLANATION: logs the number of office hours a TA held, overridden in
	//UGTA
	//PARAMETER: x - number of hours to add
	//RETURN: true if hours were successfully logged, false otherwise
	public boolean addHoursWorked(int x) {
		hoursWorked += x;
		return true;
	}
	
	//EXPLANATION: logs the number of projects a TA graded, overridden in UGTA
	//and GradTA classes
	//PARAMETER: x - number of projects to add
	//RETURN: true if projects were successfully logged, false otherwise
	public abstract boolean addProjectsGraded(int x);
	
	//EXPLANATION: returns number of hours worked
	//PARAMETER: none
	//RETURN: number of hours worked
	public int getHoursWorked() {
		return hoursWorked;
	}
	
	//EXPLANATION: returns number of projects graded
	//PARAMETER: none
	//RETURN: number of projects graded
	public int getProjectsGraded() {
		return projectsGraded;
	}
	
	//EXPLANATION: calculates paycheck amount, overridden in UGTA and GradTA
	//classes
	//PARAMETER: none
	//RETURN: paycheck amount
	public abstract double getPaycheckAmount();
}