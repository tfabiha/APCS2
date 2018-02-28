//T Fabiha
//APCS2 pd2
//HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-02-28

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

  
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	boolean ret = true;
        for (int col =  0; col < _board[0].length && ret; col++)
	    {
		ret = solveH(col);
	    }
	
	if (!ret)
	    {
		for (int row = 0; row < _board.length; row++)
		    {
			for (int col = 0; col < _board[0].length; col++)
			    {
				_board[row][col] = 0;
			    }
		    }
	    }
	return ret;
    }

  
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
        boolean ret = false;
	for (int row = 0; row < _board.length && !ret; row++)
	    {
		ret = addQueen(row,col);
	    }
	return ret;
    }


    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] == 1)
		    {
			ans += "Q" + "\t";
		    }
		else
		    {
			ans += "_" + "\t";
		    }
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Adds a queen to the specified location if applicable. 
     * precondition: _board is initialized and parameters are given
     * postcondition: returns false if a queen cannot be put there
     *                returns true if a queen can be put there and marks
     *                off every space to the right of the queen that 
     *                another queen cannot occupy
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Removes the queen at the specified location is applicable.
     * precondition: _board is initialized and parameters are given
     * postcondition: returns false if there is no queen there to remove
     *                returns true if a queen is there and removes all of 
     *                marks made by that queen to ensure that no other queen
     *                could be placed there 
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Represents what the board looks like.
     * precondition: _board is initialized
     * postcondition: returns the board in string form
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	/*
	QueenBoard b = new QueenBoard(5);
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
	System.out.println(b);
	b.removeQueen(3,0);
	System.out.println(b);
	*/

	QueenBoard b0 = new QueenBoard(12);
	System.out.println(b0.solve());
	b0.printSolution();
    }
    
}//end class
