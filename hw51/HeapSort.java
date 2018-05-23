//T. Fabiha
//APCS2 pd2
//HW21 - Heaping Piles of Sordidness
//2018-05-21 m

public class HeapSort
{
    public static int[] heapify(int[] arr, int last)
    {
	for (int i = 1; i <= last; i++)
	    {
		int currPos = i;
		while (arr[currPos/2] < arr[currPos])
		    {
			int temp = arr[currPos/2];
			arr[currPos/2] = arr[currPos];
			arr[currPos] = temp;

			currPos /= 2;
		    }		
	    }

	return arr;
    }

    public static int[] heapSort(int[]arr)
    {
        for (int i = arr.length - 1; i > 0; i--)
	    {
		heapify(arr, i);

		int temp = arr[i];
		arr[i] = arr[0];
		arr[0] = temp;
		
	    }

	return arr;
    }
    
    public static void printArr(int[] arr)
    {
	System.out.print("{ ");
	for (int each : arr)
	    {
		System.out.print(each+" ");
	    }
	System.out.println("}");
    }
    
    public static void main(String[] args)
    {
	int[] arr1 = {12, 5, 7, 1, 3};
	HeapSort.heapSort(arr1);
	printArr(arr1);

	int[] arr2 = {1, 12, 5, 3, 7};
	HeapSort.heapSort(arr2);
	printArr(arr2);

	int[] arr3 = {17, 213, 34, 85, 2, 5, 76, 4};
	HeapSort.heapSort(arr3);
	printArr(arr3);
    }
}
