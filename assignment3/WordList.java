/*
* ID: V00759566 Zach White
* Name: WordList.java
* Description: This program is a Word list manipulator.
* Input: Information for inserting, removing or retrieving certain nodes for the list.
* Output: Desired operators for the list including; if the list is empty, length of list
* removal of head, and retrieval of string.
*/

public class WordList {

	WordListNode head;

    public WordList() {
		head = null;
		
    }
    
    /*
	* Name: getLength
	* Description: This method gets the length of the list. 
	* Input: No input.
	* Output: Length of list.
	*/

    public int getLength() {
        
        int length = 0;
        WordListNode curr = head;
       	
       	if (isEmpty()){
       		length = 0;
       	} else {
        	while (curr.next != null){
        		length++;
        		curr = curr.next;
        	}
        	length += 1;
        }
        
        return length;
    }
    
    /*
	* Name: isEmpty
	* Description: Determines whether the list is empty or not. 
	* Input: No input.
	* Output: True if empty, false if there is a node present. 
	*/

    public boolean isEmpty() {
        
        if (this.head == null){
        	return true;
        } else {
        	return false;
        }
    }
	
	/*
	* Name: removeHead
	* Description: Replaces the head of the list with the next node in line.
	* Input: No input.
	* Output: Head node.
	*/

    public void removeHead() {
       
       	WordListNode curr = null;
       
        if (isEmpty()){
        	System.exit(1);
        } else {
        	curr = this.head.next;
        	this.head = curr;
        }
    }
    
    /*
	* Name: insertHead
	* Description: Inserts a node in the head position
	* Input: Desired string for insertion 
	* Output: No output. 
	*/

    public void insertHead(WordListNode word) {
        
        WordListNode curr = word;
        WordListNode temp = null;
    
        curr.next = this.head;
        head = curr;
    }
    
    /*
	* Name: retrieve
	* Description: Retrieves desired string 
	* Input: Integer of node a desired position in list
	* Output: Desired string 
	*/ 
	
    public String retrieve(int i) {
        
        WordListNode curr = this.head;
        if (i < getLength()){
       	
        	for (int j = 0; j < i; j++){
       		 	curr = curr.next;
        	}
        	String word = curr.word;
        	return word;
        } else {
        	return null;
        }
    }
    
    public static void main(String[] args){
    	
    	int numResult;
		boolean passResult;
		
		
		WordList list = new WordList();
		
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
		
		
		// Test 3: getLength after inserting one string
		
		list.insertHead(new WordListNode("Hello"));
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
		
		
		// Test 5: retrieving String after 1 insert
		String retrieve = list.retrieve(0);
		if (retrieve == "Hello"){
			System.out.println("Test 5: (Retrieve string)-----------Passed \n");
		} else {
			System.out.println("Test 5: (Retrieve string)-----------Failed \n");
		}
		
		// Test 6: removal of head
		
		list.removeHead();
		if (list.getLength() == 0){
			System.out.println("Test 6: (Head Removal)--------------Passed \n");
		} else {
			System.out.println("Test 6: (Head Removal)--------------Failed \n");
		}
    }
}