import java.util.*;

public class FrontierStack<T> implements Frontier<T>{

    MyStack<T> data = new MyStack<T>();

    public void add(T element){
	data.push(element);
    }
    public T next(){
	return data.pop();
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
