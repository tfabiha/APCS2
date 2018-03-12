//Clyde "Thluffy" Sinclair
//APCS2 pd0
//HW18 -- QuickSort
//2018-03-13t
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Calls QSortH method to sort the array.
 * QSortH(arr, left, right):
 *             1) If @param left is equal to @param right, then the range is 0 
 *                and you don't do anything.
 *                Else, @param left should be less than @param right and you
 *                continue.
 *             2) Perform partition within the given range at pivot point equal
 *                to the median of the range. The return value is now stored.
 *             3) Call QSortH to sort everything from @param left to one less
 *                than the stored number and everything from one more than the
 *                stored number to @param right. 
 *
 * 2a. Worst pivot choice and associated runtime: O(n*n)
 *     The worst pivot choice is one where the pivot value is one of the
 *     extremes in the range every time. In that case, QSortH will yield one
 *     range of 0, and another range full of every other unsorted number. 
 *    
 * 2b. Best pivot choice and associated runtime: O(nlogn)
 *     The best case is when it is already sorted, and so at every instance 
 *     where QSortH is called, the ranges it will be split into will be 
 *     approximately equal each time. And the work is distributed. 
 *
 * 3. Approach to handling duplicate values in array:
 *     There is no need to handle duplicate values in the array. It will be
 *     sorted either way. The first duplicate standing as the pivot position
 *     of QSortH will push the rest of the duplicates to the right. Then the
 *     process repeats. 
 *
 *****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    public static int partition( int[] arr, int left, int right, int pvtPos)
    {
	int pvtVal = arr[pvtPos];
	swap( pvtPos, right, arr);
	int storPos = left;

	for( int i = left; i < right; i++ )
	    {
		if ( arr[i] < pvtVal)
		    {
			swap( i, storPos, arr );
			storPos++;}
	    }
	swap(storPos,right,arr);
	return storPos;
    }//end partition

    public static void qsortH(int[] arr, int left, int right)
    {
	if (left < right)
	    {
		int pvtPos = (left + right) / 2;
		int storPos = partition(arr, left, right, pvtPos);

		qsortH(arr, left, storPos - 1);
		qsortH(arr, storPos + 1, right);
	    }
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d )
    { 
	qsortH(d, 0, d.length - 1);
    }

    //you may need a helper method...


    //main method for testing
    public static void main( String[] args )
    {
	

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
