/*
* ID: V00759566 Zach White
* NAME: BasicAlignerTester.java
* DESCRIPTION: This is a tester made to test the output of all the methods in
* BasicAligner.java
* INPUT: None 
* OUTPUT: The output of the BasicAligner.java methods 
*/

public class BasicAlignerTester {
	
	public static void main(String args[]){
		
		//Test String array for BasicAligner.java
		String[] sequence = {"QWERTYUIOP", "UIO"};
		
		Aligner test = new BasicAligner(sequence);
		
		//Test 1: testing the alignment of the strings
		test.performAlignment();
		
		//Test 2: testing the number of errors of the alignment(if any)
		if (test.getNumErrors() == 0){
			System.out.println("Test 2: Passed");
		} else {
			System.out.println("Test 2: FAILED");
		}
		
		//Test 3: testing what is returned when calling the getSequence method at
		// at position 0 in the String array
		if (test.getSequence(0) == sequence[0]){
			System.out.println("Test 3: Passed");
		} else {
			System.out.println("Test 3: FAILED");
		}
		
		//Test 4: testing what is returned when calling the getSequence method at
		// at position 1 in the String array
		if (test.getSequence(1) == sequence[1]){
			System.out.println("Test 4: Passed");
		} else {
			System.out.println("Test 4: FAILED");
		}
		
		//Test 5: testing the output of the getOffSet method
		if (test.getOffset(1) == 6){
			System.out.println("Test 5: Passed");
		} else {
			System.out.println("Test 5: FAILED");
		}
	}
}