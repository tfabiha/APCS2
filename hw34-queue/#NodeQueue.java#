//T. Fabiha
//APCS2 pd2
//HW #34: The English Do Not Wait In Line for Soup or Anything Else;
//2018-04-14

public class NodeQueue<Quasar> implements Queue<Quasar>
{
    LLNode<Quasar> _front;
    LLNode<Quasar> _back;
    int _size;

    public NodeQueue()
    {
	_front = null;
	_back = null;
	_size = 0;
    }
    
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue()
    {
	LLNode<Quasar> temp = _front;
	if (_size == 0)
	    return null;
	
	if (_size == 1)
	    {
		_front = null;
		_back = null;
	    }
	else
	    {
		_front = _front.getNext();
	    }

	_size -= 1;
	return temp.getValue();
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x )
    {
	LLNode<Quasar> temp = new LLNode<Quasar>(x, null);
	if (_size == 0)
	    {
	        _front = temp;
		_back = temp;
	    }
	else
	    {
		_back.setNext(temp);
		_back = temp;
	    }
	
	_size += 1;
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty()
    {
	return _size == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront()
    {
	return _front.getValue();
    }

    public static void sop(Object x)
    {
	System.out.println(x);
    }
    public static void  main(String[] args)
    {
	NodeQueue<String> cakeShop = new NodeQueue<String>();

	sop("Is the queue empty?: " + cakeShop.isEmpty());

	sop("Adding new customer Lance.");
	cakeShop.enqueue("Lance");

	sop("Is the queue empty?: " + cakeShop.isEmpty());

	sop("Adding new customer Keith.");
	cakeShop.enqueue("Keith");

	sop("Adding new customer Hunk.");
	cakeShop.enqueue("Hunk");

	sop("Adding new customer Pidge.");
	cakeShop.enqueue("Pidge");

	sop("Who is the next customer?: " + cakeShop.peekFront());
	sop("Serving the next customer "+cakeShop.dequeue()+".");
	
	sop("Who is the next customer?: " + cakeShop.peekFront());
	sop("Serving the next customer "+cakeShop.dequeue()+".");

	sop("Serving the next customer "+cakeShop.dequeue()+".");

	sop("Serving the next customer "+cakeShop.dequeue()+".");
	
	sop("Serving the next customer "+cakeShop.dequeue()+".");
	
	sop("Is the queue empty?: " + cakeShop.isEmpty());
	
    }
}
