import java.util.*;

public class BSTree<T extends Comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;

	public Node(T data){
	    this(data,null,null);
	}
	public Node(T data, Node left, Node right){
	    this.data = data;
	    this.left = left;
	    this.right = right;
	}
	
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
	    int leftH = 0;
	    int rightH = 0;
	    if (left == null && right == null)
		return 1;
	    if (left != null)
		leftH = left.height();
	    if (right != null)
		rightH = right.height();
	    return Math.max(1 + leftH, 1 + rightH);
	}
	public void add(T value){
	    if (value.compareTo(data) < 0){
		if (left == null)
		    left = new Node(value);
		else
		    left.add(value);
	    } else {
		if (right == null)
		    right = new Node(value);
		else
		    right.add(value);
	    }
	}
	public String toString(){
	    String retSt = "" + data + " ";
	    if (left == null)
		retSt += "_ ";
	    else
		retSt += left.toString();
	    if (right == null)
		retSt += "_ ";
	    else
		retSt += right.toString();
	    return retSt;
	}
	public boolean contains(T value){
	    if (value.compareTo(data) == 0)
		return true;
	    else if (value.compareTo(data) < 0){
		if (left == null)
		    return false;
		else
		    return left.contains(value);
	    } else {
		if (right == null)
		    return false;
		else
		    return right.contains(value);
	    }
	}
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public int getHeight(){
	//call the root's methods
	//check for empty first!
	if (root == null)
	    return 0;
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
	if (root == null)
	    root = new Node(value);
	else
	    root.add(value);
    }
    public String toString(){
	//check for empty before you do things with root.
	if (root == null)
	    return "";
	return root.toString();
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	if (root == null)
	    return false;
	return root.contains(value);
    }

    public static void main(String[] args){
	BSTree<Integer> b = new BSTree<Integer>();
	System.out.println("Int tree:");
	System.out.println(b.getHeight());
	b.add(5);
	System.out.println(b);
	System.out.println(b.getHeight());
	b.add(3);
	System.out.println(b);
	System.out.println(b.getHeight());
	b.add(7);
	System.out.println(b);
	System.out.println(b.getHeight());
	b.add(2);
	System.out.println(b);
	System.out.println(b.getHeight());
	b.add(1);
	System.out.println(b);
	System.out.println(b.getHeight());
	System.out.println(b.contains(5));
	System.out.println(b.contains(3));
	System.out.println(b.contains(7));
	System.out.println(b.contains(2));
	System.out.println(b.contains(1));
	System.out.println(b.contains(11));
	System.out.println(b.contains(0));
	System.out.println();
	BSTree<String> bs = new BSTree<String>();
	System.out.println("String tree:");
	System.out.println(bs.getHeight());
	bs.add("n");
	System.out.println(bs);
	System.out.println(bs.getHeight());
	bs.add("l");
	System.out.println(bs);
	System.out.println(bs.getHeight());
	bs.add("p");
	System.out.println(bs);
	System.out.println(bs.getHeight());
	bs.add("q");
	System.out.println(bs);
	System.out.println(bs.getHeight());
	bs.add("s");
	System.out.println(bs);
	System.out.println(bs.getHeight());
	System.out.println(bs.contains("n"));
	System.out.println(bs.contains("l"));
	System.out.println(bs.contains("p"));
	System.out.println(bs.contains("q"));
	System.out.println(bs.contains("s"));
	System.out.println(bs.contains("z"));
	System.out.println(bs.contains("a"));
    }
}
