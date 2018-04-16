// Team JiF - Jerry Ye, T. Fabiha
// APCS2 pd2
// HW #35: ...Nor Do Aussies
// 20118-04-16

import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar>
{
    private ArrayList<Quasar> _queue;
    private int _start;
    private int _end;
    private int _size;

    public ALQueue()
    {
	_queue = new ArrayList<Quasar>();
	_start = -1;
	_end = -1;
	_size = 0;
    }
    
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue()
    {
	if (_size ==0)
	    return null;

	_start += 1;
	_size -= 1;
	
	return _queue.set(_start - 1, null);
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x )
    {
	if (_start < 0)
	    {
	        _start = 0;
		_end = 0;
	    }
	else
	    {
		_end += 1;
	    }
	
	_size += 1;
	_queue.add(x);
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty()
    {
	return _size == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront()
    {
	if (_size == 0)
	    return null;
	
	return _queue.get(_start);
    }

    public static void sop(Object x)
    {
	System.out.println(x);
    }

    public static void main(String[] args)
    {
	Queue<String> cakeShop = new ALQueue<String>();

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
