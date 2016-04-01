public class MyDeque<T>{
    
    private Object[] data;
    private int start, end;

    public MyDeque(){
	data = new Object[10];
    }

    private Object[] grow(){
	Object[] retAr = new Object[data.size()*2];
	for(int i = 0;i < data.size();i++){
	    if (i + start < data.size()){
		retAr[i] = data[i+start];
	    } else {
		int j = 0;
		retAr[i] = data[j];
		j++;
	    }
	}
	return retAr;
    }
}
