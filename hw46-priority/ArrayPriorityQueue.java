//Team OneMonthLeft - T. Fabiha && Isaac Jon
//APCS2 pd2
//HW #46: Arrr, There Be Priorities Here Matey . . .
//2018-05-09 r

import java.util.ArrayList;

public class ArrayPriorityQueue<T> implements PriorityQueue<T>
{
    private ArrayList<T> _list;

    public ArrayPriorityQueue()
    {
	_list = new ArrayList<T>();
    }

    // worst case: O(n)
    // best case: O(1)
    public void add(T val) 
    {
	//if the array is empty or if the value is the smallest
	if (_list.size() == 0 || findAddPos(val) == _list.size())
	    _list.add(val);
	else
	    _list.add(findAddPos(val), val);
    }

    // runtime: O(n)
    private int findAddPos(T val)
    {
	//iterate through the array and find the placement of val
	for (int i = 0; i < _list.size(); i++)
	    if (((Comparable)_list.get(i)).compareTo((Comparable)val) < 0)
		return i;
	return _list.size();
    }

    // runtime: O(1)
    public boolean isEmpty()
    {
	return _list.size() == 0;
    }

    // runtime: O(1)
    public T peekMin()
    {
	return _list.get(_list.size()-1);
    }
    
    // runtime: O(1)
    public T removeMin()
    {
	return _list.remove(_list.size()-1);
    }

    public static void main(String[] args)
    {
	PriorityQueue<String> lance = new ArrayPriorityQueue<String>();
	System.out.println("adding foo");
	System.out.println("adding moo");
	lance.add("foo");
	lance.add("moo");
	System.out.println("removign item: "+lance.removeMin());
	System.out.println("adding goo");
	System.out.println("adding hoo");
	System.out.println("adding doo");
	lance.add("goo");
	lance.add("hoo");
	lance.add("doo");
	System.out.println("next item: "+lance.peekMin());
	System.out.println("removing item: "+lance.removeMin());
    }
}
