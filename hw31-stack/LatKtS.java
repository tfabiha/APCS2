// T. Fabiha
// APCS2 pd2
// HW #31: Stack: What Is It Good For? 
// 2018-04-11 W

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	Latkes _stack = new Latkes(s.length()); //stack to store info in
	String _ret = ""; //stores return value

	//push all the elements in s into _stack from left to right
	for (int x = 0; x < s.length(); x++)
	    _stack.push(s.substring(x,x+1));

	//pop each element of _stack out and add it to the end of _ret
	//until there's nothing in _stack
	while (!(_stack.isEmpty()))
	    _ret += _stack.pop();

	return _ret; //flipped value
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	//at the most a stack will contain half the elements of s
	Latkes _stack = new Latkes(s.length()/2);

	//iterate through the string
	for (int x = 0; x < s.length(); x++)
	    {
		//stores the value of the string currently being looked at
		String i = s.substring(x,x+1); 

		//if it's an open paren then it should be pushed
		if (i.equals("{")  || i.equals("[") || i.equals("("))
		    _stack.push(i);

		///////////
		//for all closed parens there is nothing in _stack or if the
		//value popped immediately after does not match, then the
		//entire thing is false
		
		if (i.equals("}"))
		    if (_stack.isEmpty() || !(_stack.pop().equals("{")))
			return false;
	      
		if (i.equals("]"))
		    if (_stack.isEmpty() || !(_stack.pop().equals("[")))
			return false;
	      
		if (i.equals(")"))
		    if (_stack.isEmpty() || !(_stack.pop().equals("(")))
			return false;
	    }

	//if its still not empty then there is at least one open paren
	//which hasn't been matched
	if (!(_stack.isEmpty()))
	    return false;
	
	return true; //everything so far has matched
    }//end allMatched()


    //main method to test
    public static void main( String[] args )
    {
    
	System.out.println(flip("stressed")); //desserts
	System.out.println(allMatched( "({}[()])" )); //true
	System.out.println(allMatched( "([)]" ) ); //false
	System.out.println(allMatched( "(){([])}" ) ); //true
	System.out.println(allMatched( "](){([])}" ) ); //false
	System.out.println(allMatched( "(){([])}(" ) ); //false
	System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
