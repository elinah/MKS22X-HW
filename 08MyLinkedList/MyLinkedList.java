public class MyLinkedList{

    private LNode start;
    private int size;

    public MyLinkedList(){
    }
    
    private int get(int index){} 

    //- get the value of the element at the specified index (0 based)

    private int set(int index,int newValue){}

	//- change the value of the element at the specified index to the newValue, return the old value

    private int size(){
	return size;
    }

	//- return the number of elements in the list

    private int remove(int index){}

	//- remove the element at the specified index, returns the value removed

    private boolean add(int index, int value){} 

	//- insert a new elmeent at the specified index, 0 at the front, size() at the end.

    private boolean add(int value){
	size++;
	
    }

	//- adds to end

    private int indexOf(int value){}

	//- returns the index of the 1st occurrence of the value in the linked list, -1 if not found.

    private toString(){} 

	//- returns a list formatted like: [ v1, v2, v3, ... vn-1, vn ] , empty list is just []
 
    private class LNode{
	int value;
	LNode next;
	
	private LNode(int value){
	    this.value = value;
	}

	private int getValue(){
	    return value;
	}

	private void setValue(int value){
	    this.value = value;
	}

	private LNode getNext(){
	    return next;
	}

	private void setNext(LNode next){
	    this.next = next;
	}
    }
