package taPayrollManagerSystem;

/*
 * Name: Daniel Son
 * UID: 119710265
 * "I pledge on my honor that I have not given or received any unauthorized
 * assistance on this assessment."
 * 
 * This class represents an object of a Regular Course. A regular course
 * contains variables regarding the department, course number, and how many TAs
 * the course can have. This class can be used for TAs logging their office
 * hours, logging graded projects, and getting their paycheck amount.
 */

public class ARegularCourse {
	
	private String department;
	private int courseNumber;
	protected LarryList TAList;
	
	//EXPLANATION: constructor for creating a Regular Course
	//PARAMETER: department, courseNumber, TAMaxNum - used to instantiate object
	//RETURN: none
    public ARegularCourse(String department, int courseNumber, int TAMaxNum) {
        this.department = department;
        this.courseNumber = courseNumber;
        TAList = new LarryList(TAMaxNum);
    }
    
	//EXPLANATION: returns course name
	//PARAMETER: none
	//RETURN: course name
    public String getCourseName() {
        return department + " " + courseNumber;
    }
    
	//EXPLANATION: creates a UGTA
	//PARAMETER: firstName, lastName, hourlySalary - used to instantiate object
	//RETURN: true if UGTA is added, false otherwise
    public boolean addUGTA(String firstName, String lastName,
    double hourlySalary) {
    	//checks for invalid inputs
        if (firstName == null || firstName.isEmpty() || lastName == null ||
        lastName.isEmpty() || hourlySalary <= 0 ||
        TAList.getIndex(firstName, lastName) != -1) {
        	return false;
        }
        //creates a new UGTA
        return TAList.add(new UGTA(firstName, lastName, hourlySalary));
    }
    
	//EXPLANATION: creates a GradTA
	//PARAMETER: firstName, lastName, hourlySalary - used to instantiate object
	//RETURN: true if GradTA is added, false otherwise
    public boolean addGradTA(String firstName, String lastName,
    double yearlySalary) {
    	//checks for invalid inputs
        if (firstName == null || firstName.isEmpty() || lastName == null ||
        lastName.isEmpty() || yearlySalary <= 0 ||
        TAList.getIndex(firstName, lastName) != -1) {
        	return false;
        }
        //creates a new GradTA
        return TAList.add(new GradTA(firstName, lastName, yearlySalary));
    }
    
	//EXPLANATION: returns maximum TA amount
	//PARAMETER: none
	//RETURN: list size
    public int getTACapacity() {
        return TAList.getCurrCapacityAmt();
    }
    
	//EXPLANATION: returns how many more TAs can be added before reaching max
    //capacity
	//PARAMETER: none
	//RETURN: list size - current capacity
    public int extraCapacity() {
        return TAList.numCanBeAdded();
    }
    
	//EXPLANATION: logs the number of office hours a TA held
	//PARAMETER: firstName, lastName - used to identify which TA to add hours to
    //PARAMETER: numHours - number of hours to be logged for the TA
	//RETURN: true if numHours was successfully logged, false otherwise
    public boolean holdSomeOfficeHours(String firstName, String lastName,
    int numHours) {
    	//checks for invalid inputs
    	if (firstName == null || firstName.isEmpty() || lastName == null ||
    	lastName.isEmpty() || numHours < 1||
    	TAList.getIndex(firstName, lastName) == -1) {
    		return false;
    	}
    	return TAList.addHours(TAList.getIndex(firstName, lastName), numHours);
    }
    
	//EXPLANATION: returns number of office hours a TA held
	//PARAMETER: firstName, lastName - used to identify which TA's office hours
    //to return
	//RETURN: number of office hours held
    public int numOfficeHoursHeld(String firstName, String lastName) {
    	//checks for invalid inputs
    	if (firstName == null || firstName.isEmpty() || lastName == null ||
    	lastName.isEmpty() || TAList.getIndex(firstName, lastName) == -1) {
    		return -1;
    	}
    	TA x = (TA) TAList.get(TAList.getIndex(firstName, lastName));
    	return x.getHoursWorked();
    }
    
	//EXPLANATION: logs the number projects a TA graded
	//PARAMETER: firstName, lastName - used to identify which TA to add projects
    //to
    //PARAMETER: numProjects - number of projects to be logged for the TA
	//RETURN: true if numProjects was successfully logged, false otherwise
    public boolean gradeProjects(String firstName, String lastName,
    int numProjects) {
    	//checks for invalid inputs
    	if (firstName == null || firstName.isEmpty() || lastName == null ||
    	lastName.isEmpty() || numProjects < 1 || numProjects % 2 == 1 ||
    	TAList.getIndex(firstName, lastName) == -1) {
    		return false;
    	}
    	return TAList.addProjectsGraded(TAList.getIndex(firstName, lastName),
    	numProjects);
    }
    
	//EXPLANATION: returns number of projects a TA graded
	//PARAMETER: firstName, lastName - used to identify which TA's number of
    //projects to return
	//RETURN: number of projects graded
    public int numProjectsGraded(String firstName, String lastName) {
    	//checks for invalid inputs
    	if (firstName == null || firstName.isEmpty() || lastName == null ||
    	lastName.isEmpty() || TAList.getIndex(firstName, lastName) == -1) {
    		return -1;
    	}
    	TA x = (TA) TAList.get(TAList.getIndex(firstName, lastName));
        return x.getProjectsGraded();
    }
    
	//EXPLANATION: gets a TA's paycheck amount
	//PARAMETER: firstName, lastName - used to identify which TA's paycheck
    //amount to return
	//RETURN: TA's paycheck amount
    public double getPaycheckAmount(String firstName, String lastName) {
    	//checks for invalid inputs
    	if (firstName == null || firstName.isEmpty() || lastName == null ||
    	lastName.isEmpty() || TAList.getIndex(firstName, lastName) == -1) {
    		return -1;
    	}
        return TAList.getPaycheckAmount(TAList.getIndex(firstName, lastName));
    }
}