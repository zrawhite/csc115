/*
* ID: V00759566 Zach White
* Name: StringStackRedBased.java
* Description: This program contains methods to control a reference based stack.
* Input: Strings to insert onto the stack
* Output: Item on the top of the stack.
*/

public class StringStackRefBased implements StringStack {
    
    StringStackNode head = null;
    
    /*
	* Name: isEmpty
	* Description: Determines whether the stack is empty
	* Input: No input.
	* Output: boolean.
	*/
    
    public boolean isEmpty(){
    	if (this.head == null){
    		return true;
    	} else {
    		return false;
    	}
    }

    /*
	* Name: pop
	* Description: Removes the node from the top of the list and returns if to where it was called. 
	* Input: No input.
	* Output: String.
	*/
	
    public String pop() throws StringStackException{
    	
    	if (isEmpty()){
    		throw new StringStackException("Invalid operation, nothing to pop.");
    	}
    	
    	String temp = this.head.word;
    	StringStackNode curr = head.next;
    	this.head = curr ;
    	
    	return temp;
    }

    /*
	* Name: popAll
	* Description: Removes all nodes from the stack.
	* Input: No input.
	* Output: No output.
	*/
	
    public void popAll(){
    	this.head = null;
    }

  	/*
	* Name: push
	* Description: This method inserts the desired node onto the top of the stack.
	* Input: String.
	* Output: No output.
	*/
	
    public void push(String item) throws StringStackException{
    	
    	StringStackNode curr = new StringStackNode(item);
    
        curr.next = this.head;
        head = curr;
    }


    /*
	* Name: peek
	* Description: This method allows you to look at the node at the top of the stack
	* without disturbing the stack.
	* Input: No input.
	* Output: String.
	*/
	
    public String peek() throws StringStackException{
    	
    	if (isEmpty()){
    		throw new StringStackException("Invalid operation, nothing to peek at.");
    	}
    	String temp = this.head.word;
    	
    	return temp;
    }
}