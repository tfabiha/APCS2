// Team Dyno - Aleksandra Koroza, T. Fabiha
// APCS2 pd2
// HW #36: Now Let’s Consider You Lot at Fake Terry’s
// 2018-04-18 w

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
    //instance variables
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    { 
	_front = null;
	_end = null;
	_size = 0;

    }//end default constructor


    public void enqueue( T enQVal ) 
    {
	LLNode<T> temp = new LLNode<T>(enQVal, null);
	if (_size == 0)
	    {
	        _front = temp;
		_end = temp;
	    }
	else
	    {
		//sample();
		_end.setNext(temp);
		_end = temp;
	    }

	sample();
	_size += 1;

    }//end enqueue()


    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    { 
	LLNode<T> temp = _front;
	
	if (_size == 1)
	    {
		_front = null;
		_end = null;
	    }
	else
	    _front = _front.getNext();

	_size -= 1;
	return temp.getValue();
    }//end dequeue()


    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * 1. If random value (rand) returned is 0, leave queue unchanged
     * 2. Iterate from the front of the queue up to the element preceding rand
     * 3. Set pointer from end to the front
     * 4. Set front to the target value (using getNext()) and set pointer to null
     * 5. Set end to the value preceding rand
     *
     * Algorithm relies on the creation of a temporary circle and promptly breaking it
     * up with pointers pointing to null. 
     ******************************************/
    public void sample () 
    {
	int rand = (int) (Math.random() * _size);

	// if rand is 0, then _front isn't changed
	if (rand == 0)
	    return;

	// _end will be the node that temp comes to
	// _front will be temp's next node 
	LLNode<T> temp = _front;
	for (int x = 0; x < rand; x++)
	    temp = temp.getNext();

	_end.setNext(_front);// connects the link of nodes into a circle

	// breaking up the circle!!!
	_front = temp.getNext(); 
	temp.setNext(null);
	_end = temp;
	
    }//end sample()


    public boolean isEmpty() 
    {
	return _size == 0;
    } //O(1)


    // print each node, separated by spaces
    public String toString() 
    { 

	//return _front.getValue() + " " + _front.getNext().toString();

	String retVal="";
	LLNode<T> _itr = _front;
	for (int i=0;i<_size;i++){
	    retVal+= _itr.getValue()+ " ";
	    _itr= _itr.getNext();}
	return retVal; 
    }


    //end toString()



    //main method for testing
    public static void main( String[] args )
    {
	

	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  //System.out.println("\nnow dequeuing fr empty queue..."); 
	  //System.out.println( PirateQueue.dequeue() );
/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class RQueue
