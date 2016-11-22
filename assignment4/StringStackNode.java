/*
* ID: V00759566 Zach White
* Name: StringStackNode.java
* Description: This program creates string nodes for linked list.
* Input: Desired String.
* Output: A node with a string and a pointer to another node.
*/

class StringStackNode {
    String word;
    StringStackNode next;

    StringStackNode(String word) {
        this.word = word;
        this.next = null;
    }
}