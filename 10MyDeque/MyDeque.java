public class MyDeque<T>{
    
    private T[] data;
    private int start, end;

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
	data = retAr;
    }

    public String toString(){
	String retSt = "[";
	for(int i = 0;i < data.length-1;i++)
	    retSt += data[i] + ", ";
	retSt += data[data.length-1] + "]";
	return retSt;
    }

    public static void main(String[] args){
	MyDeque<String> a = new MyDeque<String>();
	System.out.println(a.toString());
	a.grow();
	System.out.println(a.toString());
    }
}
