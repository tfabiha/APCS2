// T. Fabiha
// APCS2 pd2
// HW16 -- About Face
// 2018-03-06

public class Mysterion {
    private static void printArray(int[] arr)
    {
	String print = "[";
	for (int x = 0; x < arr.length; x++)
	    {
		print += arr[x] +", ";
	    }
	print = print.substring(0,print.length()-2) + "]";
	System.out.println(print);
    }
    
    private static void swap(int[] arr, int c, int b)
    {
	int temp = arr[c];
	arr[c] = arr[b];
	arr[b] = temp;
    }
    
    /* The function sorts the array from the item at index start to the item
     * in index end relative to how it compares to the item at index rel.
     * If an item is less than or equal to rel, then it is placed to the left. 
     * If it is greater, then it is placed to the right of it.
     */
    public static int sortRelative(int[] arr, int start, int end, int rel)
    {
	int v = arr[rel];
	swap(arr, rel, end);
	int s = start;

	for (int i = start; i < end; i++)
	    {
		if (arr[i] <= v)
		    {
			swap(arr, s, i);
			s += 1;
		    }
	    }

	swap(arr, end, s);
	printArray(arr);
	return s;
    }
    public static void main(String[] args)
    {
	int[] arr0 = {5,1,7,12,3};
	int[] arr1 = {5,7,3,9,2};
	int[] arr2 = {1,3,7,12,5};
	int[] arr3 = {1,3,9,12,7,4,6,0,10};
	System.out.println(sortRelative(arr0, 0, 4, 2));
	System.out.println(sortRelative(arr1, 0, 4, 2));
	System.out.println(sortRelative(arr2, 0, 4, 2));
	System.out.println(sortRelative(arr3, 0, 8, 4));

    }
}
