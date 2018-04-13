// Team Oreo - Isaac Jon & T. Fabiha
// APCS2 pd2
// HW #26: DeIteratour
// 2018-03-27

/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWorkAL 
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) 
    { 
	for (int each : L)
	    {
		if (each == key)
		    return true;
	    }

	return false;
    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) 
    {
	Iterator it = L.iterator();
        while (it.hasNext())
	    {
		if (it.next() == key)
		    return true;
	    }

	return false;
    }

    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) 
    {
	List<Integer> ret = new ArrayList<Integer>();
	
	for (int each : L)
	    {
		if (each%2 == 1)
		    ret.add(each);
	    }

	return ret;
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) 
    { 
	List<Integer> ret = new ArrayList<Integer>();
	Iterator it = L.iterator();

	while (it.hasNext())
	    {
		int x = (int) it.next();
		if (x%2 == 1)
		    ret.add(x);
	    }

	return ret;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) 
    { 
	Iterator it = L.iterator();

	while (it.hasNext())
	    {
		if (((int) it.next()) % 2 == 0)
		    it.remove();
	    }

    }

    public static void printArray(List<Integer> L)
    {
	String ret = "[";

	for (int each : L)
	    {
		ret += " " + each + ",";
	    }

	ret = ret.substring(0,ret.length()-1) + " ]";
	System.out.println(ret);
    }

    public static void main( String [] args ) 
    {
	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...

	
	// a) using a FOREACH loop


	// b) explicitly using an iterator


	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);

	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);
/*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class ItrWork

