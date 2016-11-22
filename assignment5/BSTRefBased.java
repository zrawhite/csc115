import java.util.Iterator;

/*
* ID: V00759566 Zach White
* Name: BSTRefBased.java
* Description: This program contains methods to control a reference based binary search tree.
* Input: TreeNodes and strings to insert into the tree
* Output: Info about the tree
*/

public class BSTRefBased extends AbstractBinaryTree 
    implements Iterable<WordRefs>
{
    private TreeNode root;


    public BSTRefBased() {
        root = null;
    }


    public BSTRefBased(WordRefs item,
        AbstractBinaryTree left,
        AbstractBinaryTree right)
    {
        root = new TreeNode(item, null, null);
        if (left != null) {
            attachLeftSubtree(left);
        }

        if (right != null) {
            attachRightSubtree(right);
        }
    }
	
	/*
	* Name: isEmpty
	* Description: Determines whether the tree is empty
	* Input: No input.
	* Output: boolean.
	*/

    public boolean isEmpty() {
        return (root == null);
    }
	
	/*
	* Name: makeEmpty
	* Description: Makes the root of the tree null
	* Input: No input.
	* Output: No output.
	*/

    public void makeEmpty() {
        root = null;
    }
	
	/*
	* Name: getRoot
	* Description: Returns the root of the tree
	* Input: No input.
	* Output: TreeNode.
	*/

    protected TreeNode getRoot() {
        return root;
    }
	
	/*
	* Name: setRoot
	* Description: Sets the root to the desired TreenNode
	* Input: TreeNode.
	* Output: No output.
	*/

    protected void setRoot(TreeNode r) {
        this.root = r;
    }
	
	/*
	* Name: getRootItem
	* Description: Returns a WordRefs that is contained within the root
	* Input: No input.
	* Output: WordRefs.
	*/

    public WordRefs getRootItem() throws TreeException {
        if (root == null) {
            throw new TreeException("getRootItem() on empty tree");
        }

        return root.item;
    }
    
    /*
	* Name: setRootItem
	* Description: Sets the item 
	* Input: No input.
	* Output: boolean.
	*/

	public void setRootItem(WordRefs item) {
        if (root == null) {
            root = new TreeNode(item);
        } else {
            root.item = item;
        }
    }
    
	/*
	* Name: attachLeft
	* Description: Attaches a TreeNode to the left branch of a different node
	* Input: WordRefs.
	* Output: No output.
	*/

    public void attachLeft(WordRefs item) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("attachLeft to empty tree");
        }

        if (!isEmpty() && root.left != null) {
            throw new TreeException("attachLeft to occupied left child");
        }

        root.left = new TreeNode(item, null, null);

        return;
    } 
    
	/*
	* Name: attachLeftSubtree
	* Description: Attaches a subtree to the left side of a node
	* Input: AbstractBinaryTree.
	* Output: No output.
	*/

    public void attachLeftSubtree(AbstractBinaryTree left) {
        if (isEmpty()) {
            throw new TreeException("attachLeftSubtree to empty tree");
        }

        if (!isEmpty() && root.left != null) {
            throw new 
                TreeException("attachLeftSubtree to occupied right child");
        }

        root.left = left.getRoot();
        left.makeEmpty();

        return;    
    }
	
	/*
	* Name: attachRight
	* Description: Attaches a TreeNode to the right branch of a different node
	* Input: WordRefs.
	* Output: No output.
	*/

    public void attachRight(WordRefs item) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("attachRight to empty tree");
        }

        if (!isEmpty() && root.right != null) {
            throw new TreeException("attachRight to occupied right child");
        }

        root.right = new TreeNode(item, null, null);

        return;
    } 
	
	/*
	* Name: attachRightSubtree
	* Description: Attaches a subtree to the right side of a node
	* Input: AbstractBinaryTree.
	* Output: No output.
	*/

    public void attachRightSubtree(AbstractBinaryTree right) {
        if (isEmpty()) {
            throw new TreeException("attachRightSubtree to empty tree");
        }

        if (!isEmpty() && root.right != null) {
            throw new 
                TreeException("attachRightSubtree to occupied right child");
        }

        root.right = right.getRoot();
        right.makeEmpty();

        return;
    }
	
	/*
	* Name: detachLeftSubtree
	* Description: Removes the left subtree from desired node
	* Input: No input.
	* Output: AbstractBinaryTree.
	*/

    public AbstractBinaryTree detachLeftSubtree()
        throws TreeException 
    {
        if (root == null) {
            throw new TreeException("detachLeftSubtree on empty tree");
        }

        BSTRefBased result = new BSTRefBased();
        result.setRoot(root.left);
        root.left = null;

        return result;
    }
	
	/*
	* Name: detachRightSubtree
	* Description: Removes the right subtree from desired node
	* Input: No input.
	* Output: AbstractBinaryTree.
	*/

    public AbstractBinaryTree detachRightSubtree()
        throws TreeException
    {
        if (root == null) {
            throw new TreeException("detachLeftSubtree on empty tree");
        }

        BSTRefBased result = new BSTRefBased();
        result.setRoot(root.right);
        root.right = null;

        return result;
    }
	
	/*
	* Name: insert
	* Description: Calls the recursive method insertItem
	* Input: String.
	* Output: No output.
	*/

    public void insert(String word) {
		
		 this.root = insertItem(root, word);
    } 
	
	/*
	* Name: insertItem
	* Description: Inserts an item into the binary search tree
	* Input: TreeNode and String.
	* Output: TreeNode.
	*/

    protected TreeNode insertItem(TreeNode r, String word) {
        if (r == null) {
        	r = new TreeNode(new WordRefs(word));
        }
        else if (word.compareTo(r.item.getWord()) < 0){
        	r.left = insertItem(r.left, word); 
        } else {
        	r.right = insertItem(r.right, word);
        }
        
        return r;
    }
	
	/*
	* Name: retrieve
	* Description: Calls the recursive method retrieveItem
	* Input: String.
	* Output: WordRefs.
	*/

    public WordRefs retrieve(String word) {
        TreeNode retrieve = retrieveItem(root, word);
        if (retrieve != null){
        	String word1 = retrieve.item.getWord();
        	return new WordRefs(word1);
        } else {
        	return null;
        }
    }
	
	/*
	* Name: retrieveItem
	* Description: retrieves the desired tree node
	* Input: TreeNode and String.
	* Output: TreeNode.
	*/

    protected TreeNode retrieveItem(TreeNode r, String word) {
        
        if (r == null) {
        	return null;
        }
        
        if (word.equals(r.item.getWord())){
        	return r;
        } else if (word.compareTo(r.item.getWord()) < 0){
        	return retrieveItem(r.left, word); 
        } else {
        	return retrieveItem(r.right, word);
        }
    }
	
	/*
	* Name: delete
	* Description: Calls the recursive method deleteItem
	* Input: String.
	* Output: No output.
	*/

    public void delete(String word) {
		deleteItem(root, word);
    }
	
	/*
	* Name: deleteItem
	* Description: Deletes desired item
	* Input: TreeNode and String.
	* Output: TreeNode.
	*/

    protected TreeNode deleteItem(TreeNode r, String word) {
        
        if (r == null) {
        	return null;
        	
        } else if(word.equals(r.item.getWord())){
        	TreeNode newNode = deleteItem(r.left, word);
        	return newNode;
        	
        } else if (word.compareTo(r.item.getWord()) < 0){
        	TreeNode left = deleteItem(r.left, word);
        	r.left = left;
        	return r; 
        	
        } else {
        	TreeNode right = deleteItem(r.right, word);
        	r.right = right;
        	return r;
        	
        }
    }
	
	/*
	* Name: deleteNode
	* Description: Deletes desired node 
	* Input: TreeNode.
	* Output: TreeNode.
	*/
    
    protected TreeNode deleteNode(TreeNode node) {
        
        if (node.left == null && node.right == null){
        	return null;
        	
        } else if (node.left != null && node.right == null){
        	return node.left;
        	
        } else if (node.left == null && node.right != null){
        	return node.right;
        	
        } else {
        	TreeNode replaceNode = findLeftMost(node.right);
        	TreeNode delete = deleteLeftMost(node.right);
        	
        	return node;
        }
        
    }
    
	/*
	* Name: findLeftMost
	* Description: Finds the left most node the in the tree
	* Input: TreeNode.
	* Output: TreeNode.
	*/

    protected TreeNode findLeftMost(TreeNode node) {
        
        if (node.left == null){
        	return node;
        	
        } else {
        	return findLeftMost(node.left);
        	
        }
    }

	/*
	* Name: deleteLeftMost
	* Description: deletes the left most node in the tree
	* Input: TreeNode.
	* Output: Treenode.
	*/

    protected TreeNode deleteLeftMost(TreeNode node) {
        
        if (node.left == null){
        	return node.right;
        	
        } else {
        	TreeNode replace = deleteLeftMost(node.left);
        	node.left = replace;
        	return node;
        	
        }
    }
	
	/*
	* Name: iterator
	* Description: Implements the BSTIterator class
	* Input: No input.
	* Output: Iterator<>.
	*/

    public Iterator<WordRefs> iterator() {
        return new BSTIterator(this);
    }


    public static void main(String args[]) {
        BSTRefBased t;
        AbstractBinaryTree tt;
        int i;
        boolean result;
        String message;

        message = "Test 1: inserting 'humpty' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            System.out.println("root "+ t.getRootItem().getWord());
            
            result = t.getRootItem().getWord().equals("humpty");
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        message = "Test 2: inserting 'humpty', 'dumpty', 'sat' -- ";
        t = new BSTRefBased();
        try {
            t.insert("humpty");
            t.insert("dumpty");
            t.insert("sat");
            result = t.getRootItem().getWord().equals("humpty");
            tt = t.detachLeftSubtree();
            result &= tt.getRootItem().getWord().equals("dumpty");
            tt = t.detachRightSubtree();
            result &= tt.getRootItem().getWord().equals("sat");
        } catch (Exception e) {
            result = false;
        	e.printStackTrace();
        }
        System.out.println(message + (result ? "passed" : "FAILED"));
        
        t = new BSTRefBased();
        t.insert("humpty");
        t.insert("dumpty");
        t.insert("sat");
        
        WordRefs retrieve = t.retrieve("sat");

        if (retrieve.getWord().equals("sat")){
        	System.out.println("Test 3 (retrieve): Passed");
        } else {
        	System.out.println("Test 3 (retrieve): Failed");
        }

    }
} 
