import java.util.*;

public class MyStack<T>{

    private MyLinkedList<T> l = new MyLinkedList<T>();
    
    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item){
	l.add(0,item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
	if (isEmpty())
	    throw new NoSuchElementException();
	return l.remove(0);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if (isEmpty())
	    throw new NoSuchElementException();
	return l.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
	return l.size();
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
	return size() == 0;
    }

    public String toString(){
	return l.toString();
    }

    public static void main(String[] args){
	MyStack<Integer> s = new MyStack<Integer>();
	System.out.println(s.toString());
	s.push(3);
	System.out.println(s.toString());
	s.push(87);
	System.out.println(s.toString());
	s.push(59);
	System.out.println(s.toString());
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.peek());
	System.out.println(s.toString());
    }
}
