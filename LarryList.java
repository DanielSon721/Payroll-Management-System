package taPayrollManagerSystem;

/*
 * Name: Daniel Son
 * UID: 119710265
 * "I pledge on my honor that I have not given or received any unauthorized
 * assistance on this assessment."
 * 
 * This class represents a LarryList. A LarryList is an array of Objects, and
 * it has many functions such as: adding an element, replacing an element, and
 * returning an element. The LarryList can also manipulate TA information such
 * as adding hours to a TA's number of office hours held, adding projects to a
 * TA's number of projects graded, and getting a TA's paycheck. The
 * LarryList can also resize to double its current size if the LarryList
 * belongs to a differential course.
 */

public class LarryList {

	private Object[] array;
	private int currentSize;
	
	//EXPLANATION: constructor for creating a LarryList
	//PARAMETER: capacity - used for size of the array
	//RETURN: none
	public LarryList(int capacity) {
		//checks for invalid inputs
		if (capacity < 1) {
			array = new Object[1];
		}
		else {
			array = new Object[capacity];
		}
		currentSize = 0;
	}
	
	//EXPLANATION: adds a new element to array
	//PARAMETER: newElement - element to be added
	//RETURN: true if element was added, false otherwise
	public boolean add(Object newElement) {
		//checks for invalid inputs
		if (newElement == null || (currentSize == array.length)) {
			return false;
		}
		array[currentSize++] = newElement;
		return true;
	}
	
	//EXPLANATION: replaces an element of the array
	//PARAMETER: pos - index to be replaced
	//PARAMETER: newElement - element to be added
	//RETURN: true if element was replaced, false otherwise
	public boolean set(int pos, Object newElt) {
		//checks for invalid inputs
		if (newElt == null || pos >= currentSize || pos < 0) {
			return false;
		}
		array[pos] = newElt;
		return true;
	}
	
	//EXPLANATION: returns maximum number of TAs allowed
	//PARAMETER: none
	//RETURN: array size
	public int getCurrCapacityAmt() {
		return array.length;
	}
	
	//EXPLANATION: determines if list of TAs is full
	//PARAMETER: none
	//RETURN: true if list is full, false otherwise
	public boolean isFull() {

		if (numCanBeAdded() == 0) {
			return true;
		}
		return false;
	}
	
	//EXPLANATION: returns how many more TAs can be added before reaching max
    //capacity
	//PARAMETER: none
	//RETURN: list size - current capacity
	public int numCanBeAdded() {
		return array.length - currentSize;
	}
	
	//EXPLANATION: returns an element of the array
	//PARAMETER: pos - index of element to be returned
	//RETURN: element at index pos, null if pos is invalid
	public Object get(int pos) {
		//checks for invalid inputs
		if (pos >= currentSize || pos < 0) {
			return null;
		}
		return array[pos];
	}
	
	//EXPLANATION: resizes array to double its current capacity
	//PARAMETER: none
	//RETURN: none
	public void resize() {
		//creates a new array with a size double that of current array size
		Object[] newArray = new Object[array.length * 2];
		//copies elements into new array
		for (int i = 0; i < currentSize; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	//EXPLANATION: logs the number of office hours a TA held
	//PARAMETER: index - index of TA to log hours for
    //PARAMETER: hours - number of hours to be logged for the TA
	//RETURN: true if numHours was successfully logged, false otherwise
	public boolean addHours(int index, int hours) {
		TA x = (TA) array[index];
		return x.addHoursWorked(hours);
	}
	
	//EXPLANATION: logs the number of projects a TA graded
	//PARAMETER: index - index of TA to log projects for
    //PARAMETER: numProjects - number of projects to be logged for the TA
	//RETURN: true if numProjects was successfully logged, false otherwise
	public boolean addProjectsGraded(int index, int numProjects) {
		TA x = (TA) array[index];
		return x.addProjectsGraded(numProjects);
	}
	
	//EXPLANATION: gets paycheck amount for a TA
	//PARAMETER: index - index of TA to get paycheck amount for
	//RETURN: paycheck amount
	public double getPaycheckAmount(int index) {
		return ((TA) array[index]).getPaycheckAmount();
	}
	
	//EXPLANATION: searches for the index of a TA
	//PARAMETER: firstName, lastName - used to identify the TA
	//RETURN: index of TA if found, -1 if TA is not found
	public int getIndex(String firstName, String lastName) {
		for (int i = 0; i < currentSize; i++) {
			TA x = (TA) array[i];
			if (x.nameMatches(firstName, lastName)) {
				return i;
			}
		}
		return -1;
	}
}