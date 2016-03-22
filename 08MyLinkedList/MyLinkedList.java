public class MyLinkedList<T>{

    private LNode start,end;
    private int size;

    public MyLinkedList(){
    }

    //get the value of the element at the specified index (0 based)
    public T get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Index out of bound");
	} else {
	    LNode current = start;
	    for(int i = 0;i < size;i++){
		if (i == index){
		    return current.getValue();
		}
		current = current.getNext();
	    }
	}
	return null;
    }

    //change the value of the element at the specified index to the newValue, return the old value
    public T set(int index,T newValue){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Index out of bound");
	} else {
	    T val = null;
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
    }

    //return the number of elements in the list
    public int size(){
	return size;
    }

    //remove the element at the specified index, returns the value removed
    public T remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException("Index out of bound");
	} else {
	    T val = null;
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
		if (index == size-1){
		    end = current;
		}
	    }
	    size--;
	    return val;
	}
    }

    //insert a new elmeent at the specified index, 0 at the front, size() at the end.
    public boolean add(int index, T value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("Index out of bound");
	} else {
	    if (index == 0){
		start = new LNode(value,start);
		if (size == 0){
		    end = start;
		}
	    } else if (index > 0 && index < size){
		LNode current = start;
		for(int i = 0;i < index-1;i++){
		    current = current.getNext();
		}
		current.setNext(new LNode(value,current.getNext()));
	    } else {
		return add(value);
	    }
	    size++;
	    return true;
	}
    }

    //adds to end
    public boolean add(T value){
	if (size == 0){
	    start = new LNode(value);
	    end = start;
	} else {
	    end.setNext(new LNode(value));
	    end = end.getNext();
	}
	size++;
	return true;
    }

    //returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
    public int indexOf(T value){
	LNode current = start;
	for(int i = 0;i < size;i++){
	    if (current.getValue().equals(value)){
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
		retS += current.getValue() + ", ";
		current = current.getNext();
	    }
	    retS += current.getValue();
	}
	retS += "]";
	return retS;
    } 
 
    private class LNode{
	private T value;
	private LNode next;
	
	private LNode(T value){
	    this.value = value;
	}
	private LNode(T value, LNode next){
	    this.value = value;
	    this.next = next;
	}

	private T getValue(){
	    return value;
	}

	private void setValue(T value){
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
	MyLinkedList<String> a = new MyLinkedList<String>();
	System.out.println(a);
	a.add("hi");
	System.out.println(a);
	a.add(0,"hey");
	System.out.println(a);
	a.add(1,"pie");
	a.add("bye");
	System.out.println(a);
	System.out.println(a.indexOf("hey"));
	a.remove(0);
	System.out.println(a);
	System.out.println(a.indexOf("hi"));
	System.out.println(a.indexOf("bye"));
	System.out.println(a.indexOf("pizza"));
	System.out.println(a.get(1));
	System.out.println(a.set(0,"hello"));
	System.out.println(a);
	a.remove(2);
	System.out.println(a);
	MyLinkedList<Integer> b = new MyLinkedList<Integer>();
	b.add(new Integer(5));
	System.out.println(b);
    }
}
