public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;
	// set/get: data/left/right
	public T getData(){
	    return data;
	}
	public void setLeft(Node left){
	    this.left = left;
	}
	public Node getLeft(){
	    return left;
	}
	public void setRight(Node right){
	    this.right = right;
	}
	public Node getRight(){
	    return right;
	}

	//real methods here
	public int height(){ 
	    return 0;
	}
	public void add(T value){
	}
	public String toString(){
	    return "";
	}
	public boolean contains(T value){
	    return false;
	}
    
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
    }
    public String toString(){
	//check for empty before you do things with root.
	return "";
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return false;
    }
}
