/*
* ID: V00759566 Zach White
* Name: TaskListTester.java
* Description: This program is meant to test TaskListRefBased.java
* Input: None
* Output: Results from tests
*/

public class TaskListTester {

	public static void main(String[] args){
		
		int numResult;
		boolean passResult;
		
		
		TaskList list = new TaskListRefBased();
		
		// Test 1: isEmpty() on new list 
		
		passResult = list.isEmpty();
		if (passResult){
			System.out.println("\nTest 1: (Empty list)----------------Passed \n");
		} else {
			System.out.println("\nTest 1: (Empty list)----------------Failed \n");
		}
		
		
		// Test 2: getLength of empty list 
		
		if (list.getLength() == 0){
			System.out.println("Test 2: (Length of empty list)------Passed \n");
		} else {
			System.out.println("Test 2: (Length of empty list)------Failed \n");
		}	
		
		
		// Test 3: getLength after inserting one task
		
		list.insert(new Task(1,40));
		int length = list.getLength();
		if (length == 1){
			System.out.println("Test 3: (Length after 1 insert)-----Passed \n");
		} else {
			System.out.println("Test 3: (Length after 1 insert)-----Failed \n");
		}
		
		// Test 4: isEmpty() after 1 insert 
		
		if (list.isEmpty() == false){
			System.out.println("Test 4: (Empty after 1 insert)------Passed \n");
		} else {
			System.out.println("Test 4: (Empty after 1 insert)------Failed \n");
		}
		
		
		// Test 5: retrieving task number after inserting one task 
		
		Task retrieve1 = list.retrieve(0);
		if (retrieve1.number == 40){
			System.out.println("Test 5: (Retrieve task #)-----------Passed \n");
		} else {
			System.out.println("Test 5: (Retrieve task #)-----------Failed \n");
		}
		
		
		// Test 6: retrieving task priority after inserting one task 
		
		if (retrieve1.priority == 1){
			System.out.println("Test 6: (Retrieve task priority)----Passed \n");
		} else {
			System.out.println("Test 6: (Retrieve task priority)----Failed \n");
		}
		
		// Test 7: sequence after insertion of 4 tasks
		
		list.insert(new Task(2,50));
		list.insert(new Task(3,30));
		list.insert(new Task(4,22));
		
		retrieve1 = list.retrieve(0);
		Task retrieve2 = list.retrieve(1);
		Task retrieve3 = list.retrieve(2);
		Task retrieve4 = list.retrieve(3);
		
		if (retrieve1.priority >= retrieve2.priority && retrieve2.priority >= retrieve3.priority && retrieve3.priority >= retrieve4.priority){
			System.out.println("Test 7: (Sequence after 4 inserts)--Passed \n");
		} else {
			System.out.println("Test 7: (Sequence after 4 inserts)--Failed \n");
		}
		
		// Test 8: removal of one node
	
		Task remove1 = list.remove(new Task(2,50));
		if (list.getLength() == 3){
			System.out.println("Test 8: (Remove one node)-----------Passed \n");
		} else {
			System.out.println("Test 8: (Remove one node)-----------Failed \n");
		}
		
		// Test 9: removal of head
		
		list.removeHead();
		if (list.getLength() == 2){
			System.out.println("Test 9: (Head Removal)--------------Passed \n");
		} else {
			System.out.println("Test 9: (Head Removal)--------------Failed \n");
		}
		
		// Test 10: sequence after removals
		
		retrieve1 = list.retrieve(0);
		retrieve2 = list.retrieve(1);
		
		if (retrieve1.priority == 3 && retrieve2.priority == 1){
			System.out.println("Test 10: (sequence after removals)--Passed \n");
		} else {
			System.out.println("Test 10: (sequence after removals)--Failed \n");
		}
	
	}

}