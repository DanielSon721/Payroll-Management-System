package taPayrollManagerSystem;

/*
 * Name: Daniel Son
 * UID: 119710265
 * "I pledge on my honor that I have not given or received any unauthorized
 * assistance on this assessment."
 * 
 * This class represents an object of a Differential Course. A differential
 * course has all the same attributes as a regular course. It contains
 * variables regarding the department, course number, and how many TAs the
 * course can have. This class can be used for TAs logging their office
 * hours, logging graded projects, and getting their paycheck amount. However,
 * differential courses can have an unlimited number of TAs.
 */

public class ADifferentialCourse extends ARegularCourse {
	
	//EXPLANATION: constructor for creating a Differential Course
	//PARAMETER: department, courseNumber, TAMaxNum - used to instantiate object
	//RETURN: none
	public ADifferentialCourse(String department, int courseNumber,
	int TAMaxNum) {
		super(department, courseNumber, TAMaxNum);
	}
	
	//EXPLANATION: creates a UGTA, can resize TA maximum if needed
	//PARAMETER: firstName, lastName, hourlySalary - used to instantiate object
	//RETURN: true if UGTA is added, false otherwise
	@Override
    public boolean addUGTA(String firstName, String lastName,
    double hourlySalary) {
		//checks for invalid inputs
        if (firstName == null || firstName.isEmpty() || lastName == null ||
        lastName.isEmpty() || hourlySalary <= 0 ||
        TAList.getIndex(firstName, lastName) != -1) {
        	return false;
        }
        //resizes array to fit more TAs
        if (TAList.isFull()) {
        	TAList.resize();
        }
        //creates a new UGTA
        return TAList.add(new UGTA(firstName, lastName, hourlySalary));
    }
	
	//EXPLANATION: creates a GradTA, can resize TA maximum if needed
	//PARAMETER: firstName, lastName, hourlySalary - used to instantiate object
	//RETURN: true if GradTA is added, false otherwise
	@Override
    public boolean addGradTA(String firstName, String lastName,
    double yearlySalary) {
		//checks for invalid inputs
        if (firstName == null || firstName.isEmpty() || lastName == null ||
        lastName.isEmpty() || yearlySalary <= 0 ||
        TAList.getIndex(firstName, lastName) != -1) {
        	return false;
        }
        //resizes array to fit more TAs
        if (TAList.isFull()) {
        	TAList.resize();
        }
        //creates a new GradTA
        return TAList.add(new GradTA(firstName, lastName, yearlySalary));
    }
}