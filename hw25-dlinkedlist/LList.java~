//T. Fabiha
//APCS2 pd 2
//HW #24b: On the DLL
//2018-03-26

public class LList implements List
{
    //instant variables
    DLLNode _head;
    DLLNode _tail;
    int _size;

    //constructor
    public LList()
    {
        _head = null;
	_tail = null;
	_size = 0;
    }
    
    //add node containing input String to end of list
    public boolean add( String x )
    {
	DLLNode newNode = new DLLNode(null, x, null);

	if (_head == null)
	    {
		_head = newNode;
		_tail = newNode;
	    }
	else
	    {
		newNode.setPrev(_tail);
		newNode.getPrev().setNext(newNode);
		_tail = newNode;
	    }
	_size++;
	return true;
    }

    //inserts a node containing s at position I
    public void add( int i, String s )
    {
	DLLNode newNode = new DLLNode(null, s, null);
	if (i == _size)
	    {
		add(s);
	    }
	else if (i == 0)
	    {
		newNode.setNext(_head);
		newNode.getNext().setPrev(newNode);
		_head = newNode;
		_size++;
	    }
	else
	    {
		newNode.setPrev(getNode(i-1));
		newNode.setNext(getNode(i));
		newNode.getPrev().setNext(newNode);
		newNode.getNext().setPrev(newNode);
		_size++;
	    }
    }

    public DLLNode getNode( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode retVal;
	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp;
	return retVal;
    }
    
    //removes the node at position i and returns its cargo
    public String remove( int i )
    {
	DLLNode tmp = getNode(i);

	if (i == 0)
	    {
		tmp.getNext().setPrev(null);
		_head = tmp.getNext();
	    }
	else if (i == _size - 1)
	    {
		tmp.getPrev().setNext(null);
		_tail = tmp.getPrev();
	    }
	else
	    {
		tmp.getPrev().setNext(tmp.getNext());
		tmp.getNext().setPrev(tmp.getPrev());
	    }
	_size--;
	return tmp.getCargo();
    }

    //return data in element at position i
    public String get( int i )
    {
	return getNode(i).getCargo();
    }

    //overwrite data in element at position i
    public String set( int i, String x )
    {
        return getNode(i).setCargo(x);
    }

    //return length of list
    public int size()
    {
	return _size;
    }

    public String toString()
    {
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }
    
    public static void main(String[] args)
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james );

	james.add(0,"whut");
	System.out.println( "...after add(0,whut): " );
	System.out.println( james );

	james.add(4,"phat");
	System.out.println( "...after add(4,phat): " );
	System.out.println( james );

	System.out.println( "...after remove last: " 
			    + james.remove( james._size-1) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );
    }

}
