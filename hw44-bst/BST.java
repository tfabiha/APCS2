//T. Fabiha && Daniel Jiang
//APCS2 pd2
//HW #44: Prune Your Tree
//2018-05-03 r

/*****************************************************
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

    //instance variables / attributes of a BST:
    TreeNode _root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( )
    {
	_root = null;
    }


    /*****************************************************
     * void insert( int )
     * Adds a new data element to tree.
     *****************************************************/
    public void insert( int newVal )
    {
	TreeNode newNode = new TreeNode( newVal );

	if ( _root == null ) {
	    _root = newNode;
	    return;
	}
	insert( _root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode )
    {
	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }//end insert()




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav()
    {
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav()
    {
	inOrderTrav( _root );
    }
    public void inOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav()
    {
	postOrderTrav( _root );
    }
    public void postOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    public TreeNode search( int target )
    {
        return search(_root, target);
    }

    private TreeNode search(TreeNode currNode, int target)
    {
	if (currNode.getValue() == target)
	    return currNode;
	if (currNode.getLeft() == null &&
	    currNode.getRight() == null)
	    return null;
	
	if (currNode.getValue() > target)
	    {
		if (currNode.getLeft() != null)
		    return search(currNode.getLeft(), target);
	    }
	else
	    {
		if (currNode.getRight() != null)
		    {
			return search(currNode.getRight(), target);
		    }
		
	    }
	
	return null;
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
	return height(_root);
    }

    private int height(TreeNode currNode)
    {
	if (currNode.getLeft() == null &&
	    currNode.getRight() == null)
	    return 0;

	int max = 0;

	if (currNode.getLeft() != null)
	    max = height(currNode.getLeft());
	if (currNode.getRight() != null)
	    {
		int n = height(currNode.getRight());
		if (max < n)
		    max = n;
	    }
	return max+1;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves(_root);
    }
    
    private int numLeaves(TreeNode currNode)
    {
	if (currNode.getLeft() == null &&
	    currNode.getRight() == null)
	    return 1;

	int sum = 0;

	if (currNode.getLeft() != null)
	    sum += numLeaves(currNode.getLeft());
	if (currNode.getRight() != null)
	    sum += numLeaves(currNode.getRight());
	
	return sum;
    }

    /*****************************************************
     * void remove( int )
     * removes node containing the input value
     *****************************************************/
    public void remove(int target)
    {
	TreeNode node = search(target);
	TreeNode parentNode = piggyBack(target);

	if (node == null)
	    return;
	
	if (node.getLeft() == null && node.getRight() == null)
	    removeWNoChild(parentNode, node);
	else if (node.getLeft() != null && node.getRight() != null )
	    removeWTwoChild(parentNode, node);
	else
	    removeWOneChild(parentNode, node);
	
    }

    private void removeWNoChild(TreeNode parent, TreeNode child)
    {
	if (_root == child)
	    {
		_root = null;
		return;
	    }

	if (parent.getLeft() == child)
	    parent.setLeft(null);
	else
	    parent.setRight(null);
    }

    public void removeWOneChild(TreeNode parent, TreeNode child)
    {
	TreeNode successor = null;
	if (child.getLeft() != null)
	    successor = child.getLeft();
	else
	    successor = child.getRight();
	
	if (_root == child)
	    {
		_root = successor;		
		return;
	    }

	if (parent.getLeft() == child)
	    parent.setLeft(successor);
	else
	    parent.setRight(successor);
    }

    public void removeWTwoChild(TreeNode parent, TreeNode child)
    {
	TreeNode successor = child.getLeft();
	while(successor.getRight() != null)
	    successor = successor.getRight();

	remove(successor.getValue());
	successor.setLeft(child.getLeft());
	successor.setRight(child.getRight());
	
	if (_root == child)
	    {			
		_root = successor;
		return;
	    }
	
	if (parent.getLeft() == child)
	    parent.setLeft(successor);
	else
	    parent.setRight(successor);
    }
    

    /*****************************************************
     * TreeNode remove( int )
     * returns parent node of the node containing the input
     *****************************************************/
    private TreeNode piggyBack(int target)
    {
	return piggyBack(_root, target);
    }
    
    private TreeNode piggyBack(TreeNode currNode, int target)
    {
	//only case is root 
        if (currNode.getValue() == target)
	    return currNode;
	
	if (currNode.getValue() > target)
	    {
		if (currNode.getLeft() != null)
		    if (currNode.getLeft().getValue() == target)
			return currNode;
		    else
			return piggyBack(currNode.getLeft(), target);
	    }
	else
	    {	if (currNode.getRight() != null)
		    if (currNode.getRight().getValue() == target)
			return currNode;
		    else
			return piggyBack(currNode.getRight(), target);
	    }
	
	return null;
    }
    


    //main method for testing
    public static void main( String[] args )
    {
	BST arbol = new BST();

	//PROTIP: sketch state of tree after each insertion
	//        ...BEFORE executing these.
	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\n-----------------------------");
	System.out.println( "pre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "in-order traversal:" );
	arbol.inOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "post-order traversal:" );
	arbol.postOrderTrav();

	System.out.println( "\n-----------------------------");

	System.out.println( "height:" );
	System.out.println(arbol.height());

	System.out.println( "-----------------------------");

	System.out.println( "number of leaves:" );
	System.out.println(arbol.numLeaves());

	System.out.println( "-----------------------------");

	System.out.println( "find 4:" );
	System.out.println(arbol.piggyBack(4).getValue());
	
	System.out.println( "-----------------------------");

	System.out.println( "find 5:" );
	System.out.println(arbol.piggyBack(5).getValue());
	
	System.out.println( "-----------------------------");
	
	System.out.println( "find 6:" );
	System.out.println(arbol.piggyBack(6).getValue());
	
	System.out.println( "-----------------------------");

	System.out.println( "find 1:" );
	System.out.println(arbol.piggyBack(1).getValue());
	
	System.out.println( "-----------------------------");

	System.out.println( "find 10 (not in the tree):");
	System.out.println(arbol.piggyBack(10));
	
	System.out.println( "-----------------------------");

	/*
	System.out.println( "remove 1:");
        arbol.remove(1);
	arbol.inOrderTrav();        
		
	System.out.println( "\n-----------------------------");
	
	System.out.println( "remove 6:");
        arbol.remove(6);
	arbol.inOrderTrav();
	
	System.out.println( "-----------------------------");
	*/	

	/*
	System.out.println( "remove 5:");
	arbol.inOrderTrav();
	System.out.println();
        arbol.remove(5);
	arbol.inOrderTrav();        
		
	System.out.println( "\n-----------------------------");
	*/

	System.out.println( "remove 2:");
	arbol.inOrderTrav();
	System.out.println();
        arbol.remove(2);
	arbol.inOrderTrav();        
		
	System.out.println( "\n-----------------------------");
	
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class
