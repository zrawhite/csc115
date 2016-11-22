/*
* ID: V00759566 Zach White
* Name: Anagrammer.java
* Description: This program is takes a word and then searches through a given library of 
* of potential words that have the same amount of matching letters
* Input: A string of words, a phrase and a integer that determines the amount of words in 
* the anagram 
* Output: Words that match the amount of matching letters in the primary phrase 
*/

public class Anagrammer {
	
	private String[] dictionary1 = null;
	private String phrase1 = null;
	private int maxWords1 = 0;
	
	public Anagrammer(String dictionary[], String phrase, int maxWords){
		
		this.dictionary1 = dictionary;
		this.phrase1 = phrase;
		this.maxWords1 = maxWords;
	}
	
	/*
	* Name: generate
	* Description: This method gets initiates variables and calls the recursive method that
	* creates the anagram
	* Input: No input.
	* Output: No output.
	*/
	
	public void generate(){
		
		WordList words = new WordList();
		AlphabetStats phraseStats = new AlphabetStats(phrase1);
		findAnagram(words, phraseStats);
		
	}
	
	/*
	* Name: findAnagram 
	* Description: This is a recursive method that searches through a given library to find
	* anagrams of the given phrase. 
	* Input: A Word list and a library of words
	* Output: Anagrams
	*/
	
	private void findAnagram(WordList words, AlphabetStats phraseStats){
		
		String word = null;
		
		if (phraseStats.isEmpty() && words.getLength() == maxWords1) {
			for(int i = 0; i < maxWords1; i++){
				String print = words.retrieve(i);
				System.out.print(print+", ");
			}
			System.out.println();
			return;
		} 
		
		for (int i = 0; i < dictionary1.length; i++){
			word = dictionary1[i];
			AlphabetStats newWord = new AlphabetStats(word);
			if (phraseStats.contains(newWord)){
				WordListNode insert = new WordListNode(word);
				
				words.insertHead(insert);
				phraseStats.subtract(newWord);
				
				findAnagram(words, phraseStats);
				
				phraseStats.add(newWord);
				words.removeHead();
			}
		}
	}
	
	public static void main(String[] args){
		
		String[] test = {"may","june","july"};
		
		Anagrammer a = new Anagrammer(test, "mayyluj", 2);
		
		//Test 1: Testing to see if you can create a node.
		
		WordListNode test1 = new WordListNode("Test");
		if (test1.word == "Test"){
			System.out.println("Test 1: Passed");
		} else {
			System.out.println("Test 1: Failed");
		}
		
		//Test 2: Testing to see if you can insertHead.
		
		WordList test2 = new WordList();
		test2.insertHead(test1);
		if (test2.retrieve(0) == "Test"){
			System.out.println("Test 2: Passed");
		} else {
			System.out.println("Test 2: Failed");
		}
		
		//Test 3: Testing to see if you can removeHead.
		
		test2.removeHead();
		if(test2.isEmpty()){
			System.out.println("Test 3: Passed");
		} else {
			System.out.println("Test 3: Failed");
		}
		
		//Test 4: Testing to see if the array was created
		
		int count = 0;
		if (a.dictionary1[0] == "may"){
			count++;
		}
		if (a.dictionary1[1] == "june"){
			count++;
		}
		if (a.dictionary1[2] == "july"){
			count++;
		}
			
		if (count == 3){
			System.out.println("Test 4: Passed");
		} else {
			System.out.println("Test 4: Failed");
		}
		
		//Test 5: Testing to see if the string phrase was created 
		
		if (a.phrase1 == "mayyluj"){
			System.out.println("Test 5: Passed");
		} else {
			System.out.println("Test 5: Failed");
		}
		
		//Test 6: Testing to see if the maxWords int was created
		
		if (a.maxWords1 == 2){
			System.out.println("Test 6: Passed");
		} else {
			System.out.println("Test 6: Failed");
		}
		
	} 

}