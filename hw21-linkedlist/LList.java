// Ying Xin Jiang, Nadine Jackson, T. Fabiha
// APCS2 pd 2
// HW #21c: Rockin’ Through the Night
// 2018-03-19

public class LList implements List {
    //instance vars
    private LLNode node;

    //constructors
    public LList()
    {
	node = new LLNode();
    }

    public LList(String c)
    {
	node = new LLNode(c, null);
    }
    
    //add node to list, containing input String as its data
    public boolean add( String x )
    {
	LLNode temp = node;
	node = new LLNode(x, temp);
	return true;
    }

    //return data in element at position i
    public String get( int i )
    {
	return getH(node, i);
    }

    public String getH(LLNode n, int i )
    {
	if (i == 0)
	    {
		return n.getCargo();
	    }
	return getH(n.getNext(), i-1);
    }

    //overwrite data in element at position i
    public String set( int i, String x )
    {
	return setH(node, i, x);
    }
 
    public String setH(LLNode n, int i, String x)
    {
	if (i == 0)
	    {
	        String temp = n.getCargo();
		n.setCargo(x);
		return temp;
	    }
	return setH(n.getNext(), i-1, x);
    }
  

    //return length of list
    public int size()
    {
	return sizeH(node);
    }

    public int sizeH(LLNode n)
    {
	if (n.getNext() == null)
	    {
		return 1;
	    }
	return 1 + sizeH(n.getNext());
    }

    public String toString()
    {
	return node.toString();
    }

    public static void main(String[] args)
    {
	LList converse = new LList("hi");
	//System.out.println(converse);
	converse.add("there");
	converse.add("new");
	converse.add("person");
	converse.add("what");
	converse.add("are");
	converse.add("you");
	converse.add("doing");
	System.out.println();
	System.out.println("the entire list:");
	System.out.println(converse);

	System.out.println();
	System.out.println("get item at index 0: "+converse.get(0));
	System.out.println("get item at index 2: "+converse.get(2));

	System.out.println();
	System.out.println("set item at index 0 to pie: "+converse.set(0, "pie"));
	System.out.println("set item at index 2 to lance: "+converse.set(2, "lance"));
	System.out.println("the entire list:");
	System.out.println(converse);

	System.out.println();
	System.out.println("the size of the list: "+converse.size());	
	
    }
}
