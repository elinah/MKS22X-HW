public class MyDeque<T>{
    
    private T[] data;
    private int start, end, size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    private void grow(){
	T[] retAr = (T[]) new Object[data.length*2];
	for(int i = 0;i < data.length;i++){
	    if (i + start < data.length){
		retAr[i] = data[i+start];
	    } else {
		int j = 0;
		retAr[i] = data[j];
		j++;
	    }
	}
	start = 0;
	end = data.length;
	data = retAr;
    }

    public String toString(){
	String retSt = "[";
	for(int i = 0;i < data.length-1;i++)
	    retSt += data[i] + ", ";
	retSt += data[data.length-1] + "]";
	return retSt;
    }

    public void addFirst(T value){
	if (size == 0){
	    data[0] = value;
	    start = 0;
	    end = 0;
	} else {
	    if (size == data.length){
		grow();
	    }
	    if (start != 0){
		data[start-1] = value;
		start = start-1;
	    } else {
		data[data.length-1] = value;
		start = data.length-1;
	    }
	}
	size++;
    }

    public void addLast(T value){
	
    }
    
    public static void main(String[] args){
	MyDeque<String> a = new MyDeque<String>();
	System.out.println(a.toString());
	a.addFirst("a");
	System.out.println(a.toString());
	a.addFirst("b");
	System.out.println(a.toString());
	a.addFirst("c");
	System.out.println(a.toString());
    }
}
