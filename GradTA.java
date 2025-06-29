package taPayrollManagerSystem;

/*
 * Name: Daniel Son
 * UID: 119710265
 * "I pledge on my honor that I have not given or received any unauthorized
 * assistance on this assessment."
 * 
 * This class represents an Graduate TA. This class inherits all of the
 * attributes of a TA. However, a GradTA has a unique variable, which is yearly
 * salary. The yearly salary is used to calculate a TA's paycheck.
 */

public class GradTA extends TA{
	
	private double yearlySalary;
	
	//EXPLANATION: constructor for creating a GradTA
	//PARAMETER: firstName, lastName, yearlySalary - used to instantiate object
	//RETURN: none
	public GradTA(String firstName, String lastName, double yearlySalary) {
		super(firstName, lastName);
		this.yearlySalary = yearlySalary;
	}
	
	//EXPLANATION: logs the number of projects a TA graded
	//PARAMETER: x - number of projects to add
	//RETURN: true if projects were successfully logged, false otherwise
	@Override
	public boolean addProjectsGraded(int x) {
		//checks if adding projects will go over the limit
		if (projectsGraded + x > 150) {
			return false;
		}
		projectsGraded += x;
		return true;
	}
	
	
	//EXPLANATION: calculates paycheck amount
	//PARAMETER: none
	//RETURN: paycheck amount
	@Override
	public double getPaycheckAmount() {
		return yearlySalary / 21;
	}
	
	//EXPLANATION: returns yearly salary
	//PARAMETER: none
	//RETURN: yearly salary
	public double getYearlySalary() {
		return yearlySalary;
	}
}