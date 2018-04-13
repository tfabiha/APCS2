/* Team Aliens (Tabassum Fabiha, Kyle Tau)
   APCS2 pd 2
   HW17 -- So So Fast
   2018-03-09 */

public class FastSelect 
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
    //--------------^  HELPER METHODS  ^--------------

    public static int partition( int[] arr, int left, int right, int pvtPos)
    {
	int pvtVal = arr[pvtPos];
	swap( pvtPos, right, arr);
	int storPos = left;

	for( int i = left; i < right; i++ )
	    {
		if ( arr[i] <= pvtVal)
		    {
			swap( i, storPos, arr );
			storPos++;}
	    }
	swap(storPos,right,arr);
	return storPos;
    }//end mysterion

    /* findY makes use of recursion to find the y-th smallest value in O(nlogn) time (findYH is the helper function in which the recursion takes place)
     * 
     * Steps for Algo:
     *      1. Use partition with the range of the entire array at the item at index
     *         y-1.
     *      2. If the return value is y-1, then the item at index y-1 is the yth
     *         smallest, and you should stop here.
     *      3. If the return value is greater than y-1, then partition again with the
     *         range of the previous left-most index up to the return value-1 at
     *         point y-1. Repeat from step 2.
     *      5. If the return value is less than y-1, then partition again with the 
     *         range of the return value+1 up to the previous right-most index at 
     *         point y-1. Repeat from step 2.
     *
     * Execution Time:
     *      It is O(nlogn), because in the worst case senario, the number of 
     *      recursive calls will be O(n), but for partition, the range will
     *      be one less each time, which is O(logn).
     *
     *      The best case scenario is O(n), because partition has to be done
     *      at least once to determine that the item at y-1 is at it's final
     *      position.
     */
    public static int findY(int y, int[] arr)
    {
	if (y > arr.length || y <= 0)
	    {
		System.out.println("There's no "+y+"th number in the array");
		return -1;
	    } //no yth element
	
	return findYH(arr, 0, arr.length - 1, y); //call helper
    }

    public static int findYH(int[] arr, int left, int right, int y)
    {
	int storPos = partition(arr, left, right, y - 1);

	if (storPos == y - 1)
	    {
		return arr[storPos]; 
	    }
	else if (storPos > y - 1)
	    {
		return findYH(arr, left, storPos - 1, y); //left half
	    }
	else
	    {
		return findYH(arr, storPos + 1, right, y); //right half
	    }
    }
    
    //main method for testing
    public static void main( String[] args )
    {
	//init test arrays of magic numbers
	int[] arr1 = {343,8,17,21,69};
	int[] arr2 = {1,28,33,4982,37};
	int[] arr3 = {7,1,5,12,3,4,6,8,10,15};

	System.out.println("Test Cases:");
	System.out.println("==============================");
	System.out.println("Array 1: [343, 8, 17, 21, 69]");
	System.out.println("Sorted Array 1: [8, 17, 21, 69, 343]");
	System.out.println("1st smallest element: "+findY(1,arr1)+"<= worst case scenario");//8
	System.out.println("5th smallest element: "+findY(5,arr1));//343
	System.out.println("==============================");
	System.out.println("Array 2: [1, 28, 33, 4982, 37]");
	System.out.println("Sorted Array 2: [1, 28, 33, 37, 4982]");
	System.out.println("2nd smallest element: "+findY(2,arr2)+"<= best case scenario");//28
	System.out.println("4th smallest element: "+findY(4,arr2));//37
	System.out.println("==============================");
	System.out.println("Array 3: [7, 1, 5, 12, 3, 4, 6, 8, 10, 15]");
	System.out.println("Sorted Array 3: [1, 3, 4, 5, 6, 7, 8, 10, 12, 15]");
	System.out.println("4th smallest element: "+findY(4,arr3));//5
	System.out.println("7th smallest element: "+findY(7,arr3));//8
	System.out.println("100th smallest element: "+findY(100,arr3));//error
	System.out.println("==============================");
    }//end main

}//end class FastSelect
