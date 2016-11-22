/*
* ID: V00759566 Zach White
* Name: InfixCalc.java
* Description: This program is a calculator that converts a infix equation to a postfix 
* equation and then calculates it.
* Input: Infix expression.
* Output: Answer to expression.
*/


public class InfixCalc {
    
    /**
     * First ensure the arithmetic operations plus parentheses
     * are surrounded by spaces. Then go ahead and split up the
     * whole expression using spaces (i.e, the operands will be
     * nicely separated from everything else by at least a single
     * space). This will not work for negative numbers.
     */
    
    public static String[] tokenize(String s) {
        // Note the missing minus character...
        String symbols[] = {"\\(", "\\)", "\\+", "\\-", "\\*", "\\/",
            "\\^"};

        // First eliminate any quotation marks
        s = s.replaceAll("'", " ");
        s = s.replaceAll("\"", " ");

        // Now all operators or parentheses, surround the character
        // with a single space on either side.
        for (int i = 0; i < symbols.length; i++) {
            String regex = symbols[i];
            String replace = " " + regex + " ";
            s = s.replaceAll(regex, replace);
        }

        // Special case: If there is a unary minus, then then
        // what appears to the right of the symbol is whitespace
        // and a digit; what appears to the left whitespace
        // and a non-digit symbol.
        s = s.replaceAll("(^|([\\(\\+\\-\\*\\/]))\\s+\\-\\s+(\\d+)", "$1 -$3");

        // Eliminate extra whitespaces at start and end of the
        // transformed string. 
        s = s.trim();

        // Finally, take advantage of the whitespace to create an
        // array of strings where each item in the array is one
        // of the elements in the original string passed in to this
        // method.
        return s.split("\\s+");
    }
	
	/*
	* Name: evaluatePostfix
	* Description: This method calculates the postfix expression. 
	* Input: StringList
	* Output: Answer to the expression.
	*/

    public static String evaluatePostfix(StringList expr) {
        
        String answer = "4";
        int firstOp = 1;
        int secondOp = 1;
        String oper;
        StringStack operator = new StringStackRefBased();
        
        try{
        	for (int i = expr.getLength()-1; i >= 0; i--){
        		operator.push(expr.retrieve(i));
        	}
        
        	while (operator.isEmpty() == false){ 
        		if (isInt(operator.peek())){
        			firstOp = Integer.parseInt(operator.pop());
        		}
        		if (operator.isEmpty()){
        			break;
        		}
        		if (isInt(operator.peek())){
        			secondOp = Integer.parseInt(operator.pop());
        		}
        		
        		oper = operator.pop();
        		if(oper.equals("+")){
        			firstOp = firstOp+secondOp;
        			operator.push(""+firstOp);
        		} else if (oper.equals("/")){
        			firstOp = firstOp/secondOp;
        			operator.push(""+firstOp);
        		} else if (oper.equals("*")){
        			firstOp = firstOp*secondOp;
        			operator.push(""+firstOp);
        		} else if (oper.equals("-")){
        			firstOp = firstOp-secondOp;
        			operator.push(""+firstOp);
        		} else if (oper.equals("^")){
        			int temp = firstOp;
        			for (int i = 1; i < secondOp; i++){
        				temp *= firstOp;
        			}
        			firstOp = temp;
        			operator.push(""+firstOp);
        		}
        		answer = "" + firstOp;
        	}
        } catch (StringStackException e){
        	System.out.println(e);
        	e.printStackTrace();
        	System.exit(1);
        } catch (ArithmeticException a){
        	System.out.println(a);
        	System.exit(1);
        }
        
        
        return answer;
    }
	
	/*
	* Name: evaluateExpression
	* Description: Brings all methods together, acts like a center hub for calling methods.
	* Input: String expression
	* Output: answer to equation as a string.
	*/

    public static String evaluateExpression(String expr) {
		
		if (isBalanced(expr) == false){
			System.out.println("The string is unbalanced");
			System.exit(1);
		}
		String[] token = tokenize(expr);
		StringList post = toPostfix(token);
		String answer = evaluatePostfix(post);
        
        return answer;
    }
    
    /*
	* Name: isBalanced
	* Description: This method checks to see is the expression is balanced  
	* Input: String expression
	* Output: boolean 
	*/
    
    public static boolean isBalanced(String expr){
    	boolean balanced = false;
    	
    	String[] token = tokenize(expr);
    	
    	int nums = 0;
    	int chars = 0;
    	int open = 0;
    	int close = 0;
    	
    	for (int i = 0; i < token.length; i++){
    		if (isInt(token[i])){
    			nums++;
    		} else if (token[i].equals(")")) {
    			close++;
    		} else if (token[i].equals("(")) {
    			open++;
    		} else {
    			chars++;
    		}
    	}
    	
    	if (chars == nums-1 && open == close){
    		balanced = true;
    	} else {
    		balanced = false;
    	}
    	
    	return balanced;
    }
    
    /*
	* Name: isInt
	* Description: This method checks to see if the value is an int 
	* Input: string
	* Output: boolean
	*/
    
    public static boolean isInt(String input){
    	try {
    		Integer.parseInt(input);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    /*
	* Name: toPostfix
	* Description: This method turns the infix expression into a postfix expression
	* Input: Array of strings
	* Output: StringList
	*/
    
    public static StringList toPostfix(String[] tokens){
    	
    	StringList operant = new StringList(); 
    	StringStack operator = new StringStackRefBased();
    	
    	for (int i = 0; i < tokens.length; i++){
    		try{
    			if (isInt(tokens[i])){
    				operant.insertTail(tokens[i]);
    			} else if (tokens[i].equals("(")){
    				operator.push(tokens[i]);
    			} else if (tokens[i].equals(")")){
    				while (operator.peek().equals("(") == false){
    					operant.insertTail(operator.pop());
    				}
    				String useless = operator.pop();
    			} else if (operator.isEmpty()){
    				operator.push(tokens[i]);
    			} else if (precedence(tokens[i]) == precedence(operator.peek())){
    				operator.push(tokens[i]);
    				operant.insertTail(operator.pop());
    			} else if (precedence(tokens[i]) < precedence(operator.peek())){
    				operant.insertTail(operator.pop());
    				operator.push(tokens[i]);
    			} else {
    				operator.push(tokens[i]);
    			}
    			if (operator.isEmpty() == false){
    				//System.out.println(operator.peek());
    			}
    		} catch (StringStackException e){
    			System.out.println(e);
    			System.exit(1);
    		}
    	}
    	
    	try{
    		while(operator.isEmpty() == false){
    			operant.insertTail(operator.pop());
    		}
    	} catch (StringStackException e) {
    		System.out.println(e);
    		System.exit(1);
    	}
    	return operant;
    }
    
    /*
	* Name: precedence
	* Description: This method determines the precedence of the operator
	* Input: String
	* Output: Integer
	*/
    
    public static int precedence(String operator){
    	
    	int priority = 0; 
    	
    	if (operator.equals("/")){
    		priority = 3;
    	} else if (operator.equals("*")) {
    		priority = 4;
    	} else if (operator.equals("+")) {
    		priority = 2;
    	} else if (operator.equals("-")) {
    		priority = 1;
    	} else if (operator.equals("^")){
    		priority = 5;	
    	}
    	
    	return priority;
    }
 
    public static void main(String args[]) {
        if (args.length < 1) {
            System.err.println("usage: java InfixCalc '<expression>'");
            System.exit(1);
        }

        System.out.println(evaluateExpression(args[0]));
        
        //Test 1: Testing tokenize method 
        
        String [] test1 = tokenize("3+4");
        int x = 0;
        if (test1[0].equals("3")){
        	x++;
        }
        if (test1[1].equals("+")){
        	x++;
        }
        if (test1[2].equals("4")){
        	x++;	
        }
        
        if (x == 3){
        	System.out.println("Test 1 (tokenize): Passed");
        } else {
        	System.out.println("Test 1 (tokenize): Failed");
        }
        
        //Test 2: Testing evaluatePostfix
        
        StringList test2 = new StringList();
        test2.insertTail("3");
        test2.insertTail("4");
        test2.insertTail("+");
        String a = evaluatePostfix(test2);
        if (a.equals("7")){
        	System.out.println("Test 2 (evaluatePostfix): Passed");
        } else {
			System.out.println("Test 3 (evaluatePostfix): Failed");
        }
        
        //Test 3: Testing isBalanced when string is balanced
        
        if (isBalanced("(3+5)*(6-9)")){
        	System.out.println("Test 3 (isBalanced [y]): Passed");
        } else {
        	System.out.println("Test 3 (isBalanced [y]): Failed");
        }
        
        //Test 4: Testing isBalanced when string isn't balanced 
        
        if (isBalanced("(3+5)))))") == false){
        	System.out.println("Test 4 (isBalanced [n]): Passed");
        } else {
        	System.out.println("Test 4 (isBalanced [n]): Failed");
        }
        
        //Test 5: Testing isInt when string is an integer
        
        if (isInt("5")){
        	System.out.println("Test 5 (isInt [y]): Passed");
        } else {
        	System.out.println("Test 5 (isInt [y]): Failed");
        }
        
        //Test 6: Testing isInt when string isn't an integer
        
        if (isInt("a") == false){
        	System.out.println("Test 6 (isInt [n]): Passed");
        } else {
        	System.out.println("Test 6 (isInt [n]): Failed");
        }
        
        //Test 7: Testing toPostfix
        
        StringList test7 = toPostfix(test1);
        String b = test7.retrieve(0);
        String c = test7.retrieve(1);
        String d = test7.retrieve(2);
        
        if (b.equals("3") && c.equals("4") && d.equals("+")){
        	System.out.println("Test 7 (toPostfix): Passed");
        } else {
        	System.out.println("Test 7 (toPostfix): Failed");
        }
        
        
        //Test 8: Testing precedence of /
        
        int test8 = precedence("/");
        if(test8 == 3){
        	System.out.println("Test 8 (precedence /): Passed");
        } else {
        	System.out.println("Test 8 (precedence /): Failed");
        }
        
        //Test 9: Testing precedence of *
        
        int test9 = precedence("*");
        if(test9 == 4){
        	System.out.println("Test 8 (precedence *): Passed");
        } else {
        	System.out.println("Test 8 (precedence *): Failed");
        }
        
        //Test 10: Testing precedence of +
        
        int test10 = precedence("+");
        if(test10 == 2){
        	System.out.println("Test 10 (precedence +): Passed");
        } else {
        	System.out.println("Test 10 (precedence +): Failed");
        }

    }
}
