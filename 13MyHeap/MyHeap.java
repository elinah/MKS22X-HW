import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }
    public MyHeap(T[] array){
        this(array,true);
    }
    public MyHeap(boolean isMax){
	isMax = this.isMax;
	size = 0;
	data = (T[])new Comparable[2];
    }
    public MyHeap(T[] array, boolean isMax){
	this.isMax = isMax;
	size = array.length;
	data = (T[])new Comparable[size+1];
	data[0] = null;
	for(int i = 1; i < size+1; i++){
	    data[i] = array[i-1];
	}   
	heapify();
    }

    private int compare(T a, T b){
	if (isMax)
	    return a.compareTo(b);
	else
	    return -1 * a.compareTo(b);
    }
    private void pushDown(int k){
	int iMax = k;
	if (k*2 <= size && compare(data[k],data[k*2]) < 0)
	    iMax = k*2;
	if (k*2+1 <= size && compare(data[iMax],data[k*2+1]) < 0)
	    iMax = k*2+1;
	if (iMax != k){
	    T temp = data[k];
	    data[k] = data[iMax];
	    data[iMax] = temp;
	    pushDown(iMax);
	}
    }
    private void pushUp(int k){
	if (k != 1 && compare(data[k],data[k/2]) > 0){
	    T temp = data[k];
	    data[k] = data[k/2];
	    data[k/2] = temp;
	    pushUp(k/2);
	}
    }
    private void heapify(){
        for(int i = size/2;i > 0;i--)
	    pushDown(i);
    }
    public T delete(){
	T ret = data[1];
	data[1] = data[size];
	size--;
	pushDown(1);
	return ret;
    }
    public void add(T x){
	if (size+1 >= data.length)
	    doubleSize();
	data[size+1] = x;
	size++;
	pushUp(size);
    }
    private void doubleSize(){
	T[] temp = (T[])new Comparable[data.length*2];
	for (int i = 0;i <= size;i++)
	    temp[i] = data[i];
	data = temp;
    }
    public String toString(){
	String retSt = "[";
	for (int i = 1;i < size;i++){
	    retSt += data[i] + ", ";
	}
	retSt += data[size] + "]";
	return retSt;
    }

    public static void main(String[] args){
	String[] data = {"b","d","a","c"};
	MyHeap<String> a = new MyHeap<String>(data,true);
	System.out.println(a.toString());
	System.out.println(a.delete());
	System.out.println(a.toString());
	a.add("e");
	System.out.println(a.toString());
	a.add("D");
	System.out.println(a.toString());
    }
	
}
