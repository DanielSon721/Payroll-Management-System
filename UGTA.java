package taPayrollManagerSystem;

/*
 * Name: Daniel Son
 * UID: 119710265
 * "I pledge on my honor that I have not given or received any unauthorized
 * assistance on this assessment."
 * 
 * This class represents an Undergraduate TA. This class inherits all of the
 * attributes of a TA. However, an UGTA has a unique variable, which is hourly
 * salary. The hourly salary is used to calculate a TA's paycheck.
 */

public class UGTA extends TA {
	
	private double hourlySalary;
	
	//EXPLANATION: constructor for creating a UGTA
	//PARAMETER: firstName, lastName, hourlySalary - used to instantiate object
	//RETURN: none
	public UGTA(String firstName, String lastName, double hourlySalary) {
		super(firstName, lastName);
		this.hourlySalary = hourlySalary;
	}
	
	//EXPLANATION: logs the number of office hours a TA held
	//PARAMETER: x - number of hours to add
	//RETURN: true if hours were successfully logged, false otherwise
	@Override
	public boolean addHoursWorked(int x) {
		//checks if adding hours will go over the limit
		if (hoursWorked + x > 20) {
			return false;
		}
		hoursWorked += x;
		return true;
	}
	
	//EXPLANATION: logs the number of projects a TA graded
	//PARAMETER: x - number of projects to add
	//RETURN: true if projects were successfully logged, false otherwise
	@Override
	public boolean addProjectsGraded(int x) {
		//checks if adding projects will go over the limit
		if (projectsGraded + x > (20 - hoursWorked) * 2) {
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
		return (hoursWorked + (projectsGraded / 2)) * hourlySalary;
	}
	
	//EXPLANATION: returns hourly salary
	//PARAMETER: none
	//RETURN: hourly salary
	public double getHourlySalary() {
		return hourlySalary;
	}
}