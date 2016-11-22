/*
* ID: V00759566 Zach White
* NAME: BasicAligner.java
* DESCRIPTION: This program takes in two strings and checks to see if the second string
* is inside the first string. If there isn't a perfect match, it will get the closest match
* farthest to the end of the first string.
* INPUT: An array of strings 
* OUTPUT: An alignment of the second string with the first string 
*/

public class BasicAligner implements Aligner {

	private String[] sequence;
	private char[][] cArray;
	private int highest;
	private int highestIndex;
	private int[] counter;
	
	/*
	* NAME: BasicAligner
	* PURPOSE: To turn the 1D string array into a 2D array of characters that are 
	* contained in the previous strings 
	* INPUT: An array of strings
	* OUTPUT: None
	*/
 
    public BasicAligner(String[] sequence) { 
    	
    	this.sequence = new String[sequence.length];
    	this.cArray = new char[sequence.length][sequence[0].length()];
    	
    	for (int i = 0; i < sequence.length; i++){
    		this.sequence[i] = sequence[i];
    		this.cArray[i] = sequence[i].toCharArray();
    	} 
    	
    }
	
	/*
	* NAME: performAlignment
	* PURPOSE: Alignes the second string with the first string 
	* INPUT: None
	* OUTPUT: None
	*/
	
	public void performAlignment() { 
		
		this.counter = new int[cArray[0].length-cArray[1].length+1];
		
		for (int i = 0; i<(cArray[0].length-cArray[1].length)+1; i++){
			for(int j = 0; j<cArray[1].length; j++){
				if (cArray[0][i+j] == cArray[1][j]){
					counter[i]++;
				}
			}
		}
		
		this.highest = 0;
		this.highestIndex = 0;
		
		for (int i = 0; i < counter.length; i++){
			if(highest <= counter[i]){
				this.highest = counter[i];
				highestIndex = i;
			}
		}
		
    }

	/*
	* NAME: getOffset
	* PURPOSE: Gets the number of characters that the required string must be shifted
	* to align with the other string
	* INPUT: Integer pointing to desired string 
	* OUTPUT: The number of spaces that the string must be shifted to match
	*/
	
	public int getOffset(int sequenceNumber) {
		
        return this.highestIndex;
    }
    
    /*
	* NAME: getSequence
	* PURPOSE: Gets the desired string in the array 
	* INPUT: Integer pointing to desired string 
	* OUTPUT: Desired string 
	*/

	public String getSequence(int sequenceNumber) {
        
        return this.sequence[sequenceNumber];
    }
    
    /*
	* NAME: getNumErrors
	* PURPOSE: Gets the number of errors between the first string and the second string 
	* (if any)
	* INPUT: none
	* OUTPUT: number of errors
	*/

	public int getNumErrors() {
        
        int numErrors = cArray[1].length-highest;
        
        return numErrors;
    }
    
    
}
