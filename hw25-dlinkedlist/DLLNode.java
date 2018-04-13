//T. Fabiha
//APCS2 pd 2
//HW #24a: On the DLL
//2018-03-26

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type T
 *****************************************************/

public class DLLNode<T> 
{
    private T _cargo;    //cargo may only be of type T
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    //constructor
    public DLLNode(DLLNode prev, T c, DLLNode next)
    {
	_prevNode = prev;
	_cargo = c;
	_nextNode = next;
    }

    //accessors
    public DLLNode getPrev()
    {
	return _prevNode;
    }

    public T getCargo()
    {
	return _cargo;
    }

    public DLLNode getNext()
    {
	return _nextNode;
    }

    //mutators
    public DLLNode setPrev(DLLNode p)
    {
	DLLNode tmp = _prevNode;
	_prevNode = p;
	return tmp;
    }

    public T setCargo(T c)
    {
	T tmp = _cargo;
	_cargo = c;
	return tmp;
    }

    public DLLNode setNext(DLLNode n)
    {
	DLLNode tmp = _nextNode;
	_nextNode = n;
	return tmp;
    }

    public static void main(String[] args)
    {}


}//end class DLLNode
