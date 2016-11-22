/*
* ID: V00759566 Zach White
* Name: WordListNode.java
* Description: This program creates string nodes for linked lists.
* Input: Desired String.
* Output: A node with a string and a pointer to another node.
*/

class WordListNode {
    String word;
    WordListNode next;

    WordListNode(String word) {
        this.word = word;
        this.next = null;
    }
}