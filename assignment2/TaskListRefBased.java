/*
* ID: V00759566 Zach White
* Name: TaskListRefBased.java
* Description: This program is a task list manipulator that implements the Tasklist 
* interface. 
* Input: Information for inserting, removing or retrieving certain nodes for the list.
* Output: Desired operators for the list including; if the list is empty, length of list
* removal of task, and retrieval of task.
*/

public class TaskListRefBased implements TaskList {

	TaskListNode head;

    public TaskListRefBased() {
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
        TaskListNode curr = head;
       	
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

    public Task removeHead() {
       
       	TaskListNode curr = null;
       
        if (isEmpty()){
        	return null;
        } else {
        	curr = this.head.next;
        	this.head = curr;
			Task result = new Task(curr.task.priority, curr.task.number);
			return result;
        }
    }
    
	/*
	* Name: remove
	* Description: removes desired node from the list.
	* Input: Desired task for removal. 
	* Output: Removed task.
	* Note: This method was closely replicated from IntergerListRefBased.java, created by 
	* Dr. Mike Zastre.  
	*/
    
    public Task remove(Task t) {
        
        TaskListNode temp = new TaskListNode(t);
        TaskListNode prev = null;
        TaskListNode curr = this.head;

        while (curr != null) {
            if (temp.task.priority < curr.task.priority) {
                prev = curr;
                curr = curr.next;
            } else {
                break;
            }
        }

        if (curr == null) {
            return null;
        }

        if (prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        return t;
        
    }
	
	/*
	* Name: insert
	* Description: Inserts a node in order of task priority
	* Input: Desired task for insertion 
	* Output: No output.
	* Note: This method was closely replicated from IntergerListRefBased.java, created by 
	* Dr. Mike Zastre.  
	*/

    public void insert(Task t) {
        
        TaskListNode temp = new TaskListNode(t);
        TaskListNode prev = null;
        TaskListNode curr = this.head;

        while (curr != null) {
            if (temp.task.priority <= curr.task.priority) {
                prev = curr;
                curr = curr.next;
            } else {
                break;
            }
        }
        
        TaskListNode newNode = new TaskListNode(t);
        newNode.next = curr;

        if (prev == null) {
            head = newNode;
            if (getLength() == 1){
            	newNode.next = null;
            }
        } else {
            prev.next = newNode; 
        }
        
    }
	
	/*
	* Name: retrieve
	* Description: Retrieves desired task from task list
	* Input: Integer of node a desired position in list
	* Output: Desired task 
	*/
	
    public Task retrieve(int i) {
        
        TaskListNode curr = this.head;
        if (i < getLength()){
       	
        	for (int j = 0; j < i; j++){
       		 	curr = curr.next;
        	}
        	Task task = new Task(curr.task.priority, curr.task.number);
        	return task;
        } else {
        	return null;
        }
    }








}
