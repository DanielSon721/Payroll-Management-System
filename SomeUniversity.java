package taPayrollManagerSystem;

/*
 * Name: Daniel Son
 * UID: 119710265
 * "I pledge on my honor that I have not given or received any unauthorized
 * assistance on this assessment."
 * 
 * This class represents an arbitrary university. There are two methods in this
 * class, which can create new courses for the university. New courses can be
 * of type regular or differential, depending on how many TAs the course wants.
 */

public class SomeUniversity {
	
	//EXPLANATION: creates a Regular Course
	//PARAMETER: department, courseNumber, TAMaxNum - used to instantiate object
	//RETURN: none
    public static ARegularCourse createARegularCourse(String department,
    int courseNumber, int TAMaxNum) {
    	//checks for invalid inputs
    	if (department == null || department.isEmpty() ||
    	courseNumber < 100 || TAMaxNum < 1) {
    		return null;
    	}
    	//creates a new regular course
    	return new ARegularCourse(department, courseNumber, TAMaxNum);
    }
    
	//EXPLANATION: creates a Differential Course
	//PARAMETER: department, courseNumber, TAMaxNum - used to instantiate object
	//RETURN: none
    public static ARegularCourse createADifferentialCourse(String department,
    int courseNumber, int TAMaxNum) {
    	//checks for invalid inputs
    	if (department == null || department.isEmpty() ||
    	courseNumber < 100 || TAMaxNum < 1) {
    		return null;
    	}
    	//creates a new differential course
    	return new ADifferentialCourse(department, courseNumber, TAMaxNum);
    }
}