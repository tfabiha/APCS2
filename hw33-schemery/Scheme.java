// T. Fabiha
// APCS2 pd2
// HW #33: What a Racket
// 2018-04-13 F

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *    1) Split input string and put it into an array.
 *    2) Create a stack.
 *    3) Iterate through the array.
 *    4) If you come across anything that isn't a ")" push it into the stack.
 *    5) If you come across a ")":
 *       a) Pop every number off and put it into a temporary stack.
 *       b) Store the operand.
 *       c) Put the operand and temporary stack into unload.
 *          (1) Pop from the temporary stack and let it equal the answer
 *          (2) Until you peek into the temporary stack and see a ")" keep
 *              doing the operand on the answer and a number popped from the 
 *              stack
 *          (3) Return answer.
 *       d) Push the number that you get back to the original stack.
 *    6) Pop from the original stack and return it.
 * 
 * STACK OF CHOICE: LLStack by T. Fabiha because the runtime for each method 
 * of LLStack is O(1). 
 ******************************************************/

public class Scheme
{
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] _exprArray = expr.split("\\s+");
	Stack<String> _stack = new LLStack<String>();

	//iterate through the array
	for (int i = 0; i < _exprArray.length; i++)
	    {		
		String _temp = _exprArray[i]; //contains an element of the array
		
		if (!_temp.equals(")")) //if the element isn't )
			_stack.push(_temp);
		else //if the element is )
		    {
			Stack<String> _tempStack = new LLStack<String>();
			int op = 0;

			//unload needs ) at the very bottom
			_tempStack.push(")"); 

			for (String s = _stack.pop();
			     !s.equals("("); //signals end of expression
			     s = _stack.pop())

			    {
				if (isNumber(s))
				    _tempStack.push(s);
				else
				    {
					if (s.equals("+"))
					    op = 1;
					if (s.equals("-"))
					    op = 2;
					if (s.equals("*"))
					    op = 3;
				    }
			    }
			//the number evaluated must be pushed back into the
			//stack so that if there are other other expressions
			//to evaluate they can be evaluated
			_stack.push(unload(op,_tempStack));
		    }
	    }
	//at the very end there should only be one remaining element in
	//the stack
	return _stack.pop(); 
    }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	int ans = Integer.parseInt(numbers.pop());

	//) signals the end of all the numbers
	while (!numbers.peek().equals(")"))
	    {	
		int x = Integer.parseInt(numbers.pop());
		
		if (op == 1)
		    ans += x;
		if (op == 2)
		    ans -= x;
		if (op == 3)
		    ans *= x;
	    }

	return Integer.toString(ans);
    }//end unload()


  
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
	try {
	    Integer.parseInt(s);
	    return true;
	}
	catch( NumberFormatException e ) {
	    return false;
	}
    }



    //main method for testing
    public static void main( String[] args )
    {

	
	  String zoo1 = "( + 4 3 )";
	  System.out.println(zoo1);
	  System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	  //...7
	  
	  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	  System.out.println(zoo2);
	  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	  //...17
	  
	  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	  System.out.println(zoo3);
	  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	  //...29
	  
	  String zoo4 = "( - 1 2 3 )";
	  System.out.println(zoo4);
	  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	  //...-4
/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
