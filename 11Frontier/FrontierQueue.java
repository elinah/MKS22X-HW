import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{

    MyQueue<T> data = new MyQueue<T>();

    public void add(T element){
	data.enqueue(element);
    }
    public T next(){
	return data.peek();
    }
    
    public boolean hasNext(){
	try {
	    data.peek();
	    return true;
	} catch(NoSuchElementException e){
	    return false;
	}
    }

}
