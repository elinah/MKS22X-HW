public class MyLinkedList{

    private LNode start;
    private int size;

    public MyLinkedList(){
    }

    //get the value of the element at the specified index (0 based)
    private int get(int index){
	LNode current = start;
	for(int i = 0;i < size;i++){
	    if (i == index){
		return current.getValue();
	    }
	    current = current.getNext();
	}
	return 0;
    }

    //change the value of the element at the specified index to the newValue, return the old value
    private int set(int index,int newValue){
	int val = 0;
	LNode current = start;
	for(int i = 0;i < size;i++){
	    if (i == index){
		val = current.getValue();
		current.setValue(newValue);
		return val;
	    }
	    current = current.getNext();
	}
	return val;
    }

    //return the number of elements in the list
    private int size(){
	return size;
    }

    //remove the element at the specified index, returns the value removed
    private int remove(int index){
	int val = 0;
	if (index == 0 && size > 0){
	    val = start.getValue();
	    start = start.getNext();  
	} else if (index > 0 && index < size){
	    LNode current = start;
	    for(int i = 0;i < index-1;i++){
		current = current.getNext();
	    }
	    val = current.getNext().getValue();
	    current.setNext(current.getNext().getNext());
	}
	size--;
	return val;
    }

    //insert a new elmeent at the specified index, 0 at the front, size() at the end.
    private boolean add(int index, int value){
	if (index == 0){
	    start = new LNode(value,start);
	} else if (index > 0 && index <= size){
	    LNode current = start;
	    for(int i = 0;i < index-1;i++){
		current = current.getNext();
	    }
	    current.setNext(new LNode(value,current.getNext()));
	}
	size++;
	return true;
    }

    //adds to end
    private boolean add(int value){
	if (size == 0){
	    start = new LNode(value);
	} else {
	    LNode current = start;
	    while (current.getNext() != null){
		current = current.getNext();
	    }
	    current.setNext(new LNode(value));
	}
	size++;
	return true;
    }

    //returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
    private int indexOf(int value){
	LNode current = start;
	for(int i = 0;i < size;i++){
	    if (current.getValue() == value){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    //returns a list formatted like: [ v1, v2, v3, ... vn-1, vn ] , empty list is just []
    public String toString(){
	String retS = "[";
	if (size > 0){
	    LNode current = start;
	    while (current.getNext() != null){
		retS += " " + current.getValue() + ",";
		current = current.getNext();
	    }
	    retS += " " + current.getValue() + " ";
	}
	retS += "]";
	return retS;
    } 
 
    private class LNode{
	private int value;
	private LNode next;
	
	private LNode(int value){
	    this.value = value;
	}
	private LNode(int value, LNode next){
	    this.value = value;
	    this.next = next;
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

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	System.out.println(a);
	a.add(5);
	System.out.println(a);
	a.add(0,2);
	System.out.println(a);
	a.add(1,7);
	System.out.println(a);
	System.out.println(a.indexOf(7));
	a.remove(0);
	System.out.println(a);
	System.out.println(a.indexOf(7));
	System.out.println(a.indexOf(5));
	System.out.println(a.indexOf(55));
	System.out.println(a.get(1));
	System.out.println(a.set(0,8));
	System.out.println(a);
    }
}
