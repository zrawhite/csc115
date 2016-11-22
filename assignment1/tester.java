/* BasicAlignerTester.java
* Zach White
* V00759566
* Made to test BasicAligner.java
*/

public class tester {
	
	public static void main(String args[]){
		
		//Test String array below
		String[] sequence = {"GCAGCAGCUPOI", "POI"};
		
		Aligner list = new BasicAligner(sequence);
		
		//Test 1: testing the alignment of the strings
		list.performAlignment();
	}
}