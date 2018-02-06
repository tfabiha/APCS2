// Team PotatoChips
// Daniel Gelfand, Tabassum Fabiha, Shayan Chowdhury
// APCS2 Period 2
// HW #03: I Am Still Searching
// 2018--02--02

/*
1. Start at top right corner (largest number in first row)
2. Check if current number matches the target. If Yes, return position of target. Else, go to step 3.
3. If number at current location is larger than the target, move to the left 1 column.
   Otherwise, move down one row to a larger number.
4. Repeat steps 2 and 3 until you cannot move left or move down.
   If you can no longer move and target has not been found return (-1,-1).

   This algorithm has a runtime of O(1) (top right) for the best case and O(2n - 1) for the worst case (bottom left).
   However, as we noted from the team's algorith we assessed in class today, the runtime for our worst case is still
   linearly increasing and thus has the same runtime growth rate as O(n).
 */

public class MatrixFinder {
	private static String helperFinder(int[][] array, int row, int col, int find) {
		if ((row >= array.length) || (col < 0))
			return "(-1,-1)";

		if (array[row][col] == find) {
			return "(" + row + "," + col + ")";
		}

		if (array[row][col] > find) {
			return helperFinder(array, row, col - 1, find);
		} else {
			return helperFinder(array, row + 1, col, find);
		}
	}

	public static String finder(int[][] array, int find) {
		return helperFinder(array, 0, array.length - 1, find);
	}

	public static void main(String[] args) {
		int[][] test1 = { { 1 } };
		System.out.println("test1, find 1: " + finder(test1, 1)); //(0,0)
		System.out.println("test1, find 6: " + finder(test1, 6)); //(-1,-1)
		System.out.println();

		int[][] test2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("test2, find 1: " + finder(test2, 1)); //(0,0)
		System.out.println("test2, find 6: " + finder(test2, 6)); //(1,2)
		System.out.println("test2, find 5: " + finder(test2, 5)); //(1,1)
		System.out.println("test2, find -17: " + finder(test2, -17)); //(-1,-1)
		System.out.println("test2, find 54: " + finder(test2, 54)); //(-1,-1)
		System.out.println();

		int[][] test3 = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 7, 8, 9, 10 }, { 10, 11, 12, 13 } };
		System.out.println("test3, find 1: " + finder(test3, 1)); //(0,0)
		System.out.println("test3, find 6: " + finder(test3, 6)); //(1,2)
		System.out.println("test3, find 14: " + finder(test3, 14)); //(-1,-1)
		System.out.println("test3, find -1: " + finder(test3, -1)); //(-1,-1)
		System.out.println("test3, find 10: " + finder(test3, 10)); //(2,3)
		System.out.println();

	}
}
