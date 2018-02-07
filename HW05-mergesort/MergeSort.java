// T. Fabiha
// APCS2 pd2
// HW05--Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
// 2018-02-07

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
      If the number of stuff is 1, then just return that stuff.
      If the number of stuff is more than 1, divide the stuff in half, sort each 
half, and then merge the 2 sorted halves.
  ======================================*/

public class MergeSort
{
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
	int[] ret = new int[a.length + b.length];
	
	int posOfA = 0;
	int posOfB = 0;
	int place = 0;

        while (posOfA < a.length && posOfB < b.length)
	    {
		if (a[posOfA] < b[posOfB])
		    {
			ret[place] = a[posOfA];
			posOfA += 1;
		    }
		else
		    {
			ret[place] = b[posOfB];
			posOfB += 1;
		    }

		place += 1;
		//printArray(ret);
	    }


	int[] largerArr;
	int posOfLArr;
	if (posOfA < a.length)
	    {
		largerArr = a;
		posOfLArr = posOfA;
	    }
	else 
	    {
		largerArr = b;
		posOfLArr = posOfB; 
	    }

	for (int x = posOfLArr; x < largerArr.length; x++)
	    {
		ret[place] = largerArr[x];
		place += 1;
	    }

	return ret;
    }//end merge()


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr )
    {
	if (arr.length < 2)
	    {
		return arr;
	    }
	
	int[] a = subArray(arr, 0, arr.length / 2);
	int[] b = subArray(arr, arr.length / 2, arr.length);

	a = sort(a);
	b = sort(b);
	
	return merge(a,b);
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }

    public static int[] subArray(int[] org, int start, int end) {
	int[] ret = new int[end-start];
	int place = 0;
	for (int x = start; x < end; x++) {
	    ret[place] = org[x];
	    place += 1;
	}
	return ret;
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	
	  int[] arr0 = {0};
	  int[] arr1 = {1};
	  int[] arr2 = {1,2};
	  int[] arr3 = {3,4};
	  int[] arr4 = {1,2,3,4};
	  int[] arr5 = {4,3,2,1};
	  int[] arr6 = {9,42,17,63,0,512,23};
	  int[] arr7 = {9,42,17,63,0,9,512,23,9};

	  /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~	  
	  System.out.println("\nTesting mess-with-array method...");
	  printArray( arr3 );
	  mess(arr3);
	  printArray( arr3 );
	  
	  System.out.println("\nMerging arr1 and arr0: ");
	  printArray( merge(arr1,arr0) );
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	  /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	   
	  System.out.println("\nMerging arr4 and arr6: ");
	  printArray( merge(arr4,arr6) );
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	  
	  System.out.println("\nSorting arr4-7...");
	  printArray( sort( arr4 ) );
	  printArray( sort( arr5 ) );
	  printArray( sort( arr6 ) );
	  printArray( sort( arr7 ) );

	  
    }//end main()

}//end class MergeSort
