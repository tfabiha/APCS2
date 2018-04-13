//T. Fabiha
//APCS2 pd2
//HW #32: Leon Leonwood Stack    
//2018-04-11 R

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>
{
    LinkedList<PANCAKE> _stack;
    int _stackSize;

    public LLStack() // O(1)
    {
	_stack = new LinkedList<PANCAKE>();
	_stackSize = 0;
    }
    
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty() // O(1)
    {
	return _stackSize == 0;
    }

    //Return top element of stack without popping it.
    public PANCAKE peek() // O(1)
    {
	if (isEmpty())
	    return null;

	return _stack.getFirst();
    }

    //Pop and return top element of stack.
    public PANCAKE pop() // O(1)
    {
	_stackSize -= 1;
	return _stack.removeFirst();
    }

    //Push an element onto top of this stack.
    public void	push( PANCAKE x ) // O(1)
    {
	_stack.addFirst(x);
	_stackSize += 1;
    }
    
    public static void main(String[] args)
    {}
}
					 
