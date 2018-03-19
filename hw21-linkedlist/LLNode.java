// Ying Xin Jiang, Nadine Jackson, T. Fabiha
// APCS2 pd 2
// HW #21c: Rockin’ Through the Night
// 2018-03-19

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String cargo;
    private LLNode next;

    // constructor 
    public LLNode()
    {
	cargo = "";
        next = null;
    }

    public LLNode(String c, LLNode n)
    {
	this();
	cargo = c;
	next = n;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
	return cargo;
    }

    public LLNode getNext()
    {
	return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String c)
    {
	String ret = c;
	cargo = c;
	return ret;
    }

    public LLNode setNext(LLNode n)
    {
	LLNode ret = n;
	next = n;
	return ret;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
	return "|"+cargo+"|o=|==> "+next;
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...
	LLNode traversible = new LLNode();
	//System.out.println(traversible);

	LLNode prongs = new LLNode("prongs", null);
	//System.out.println(prongs);
	LLNode wormtail = new LLNode("wormtail", prongs);
	//System.out.println(wormtail);
	LLNode padfoot = new LLNode("padfoot", wormtail);
	//System.out.println(padfoot);
	LLNode moony = new LLNode("moony", padfoot);
	System.out.println(moony);
	
    }//end main

}//end class LLNode
