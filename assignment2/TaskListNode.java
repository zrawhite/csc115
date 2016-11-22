/*
* ID: V00759566 Zach White
* Name: TaskListNode.java
* Description: This program creates task nodes for linked lists.
* Input: Desired task.
* Output: A node with a priority, number, and a pointer to another node.
*/

class TaskListNode {
    Task task;
    TaskListNode next;

    TaskListNode(Task task) {
        this.task = task;
        this.next = null;
    }
}
