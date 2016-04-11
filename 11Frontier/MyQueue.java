import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> l = new MyLinkedList<T>();
    
    /**
     * Adds the given item to the rear of the queue.
     */
    public void enqueue(T item){
	l.add(item);
    }

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T dequeue(){
	if (isEmpty())
	    throw new NoSuchElementException();
	return l.remove(0);
    }

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
	if (isEmpty())
	    throw new NoSuchElementException();
	return l.get(0);
    }

    /**
     * Returns the number of items currently in the queue.
     */
    public int size(){
	return l.size();
    }

    /**
     * Returns whether the queue is empty or not.
     */
    public boolean isEmpty(){
	return size() == 0;
    }

    public static void main(String[] args){
	MyQueue<Integer> q = new MyQueue<Integer>();
	q.enqueue(3);
	q.enqueue(5);
	q.enqueue(67);
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
	System.out.println(q.peek());
    }
}
