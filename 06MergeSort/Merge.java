import java.util.Arrays;

public class Merge{
    
    public void mergeSort(int[] data){
	int[] newAr = mergeSortH(data);
	for(int i = 0;i < data.length;i++){
	    data[i] = newAr[i];
	}
    }

    public int[] merge(int[] data1,int[] data2){
        int[] retAr = new int[data1.length+data2.length];
	int i = 0;
	int j = 0;
	while(i < data1.length || j < data2.length){
	    if(i == data1.length){
		retAr[i+j] = data2[j];
		j++;
	    } else if (j == data2.length){
		retAr[i+j] = data1[i];
		i++;
	    } else if(data1[i] < data2[j]){
		retAr[i+j] = data1[i];
		i++;
	    } else {
		retAr[i+j] = data2[j];
		j++;
	    }
	}
	return retAr;
    }

    public int[] mergeSortH(int[] data){
	if(data.length == 1){
	    return data;
	} else {
	    int split = data.length / 2;
	    int[] ar1 = new int[split];
	    int[] ar2 = new int[data.length-split];
	    for(int i = 0;i < split;i++){
		ar1[i] = data[i];
	    }
	    for(int i = 0;i < ar2.length;i++){
		ar2[i] = data[i+split];
	    }
	    return merge(mergeSortH(ar1),mergeSortH(ar2));
	}
    }

    public static void main(String[] args){
	int[] array = {2,5,3,1,8,5};
	Merge m = new Merge();
	m.mergeSort(array);
	System.out.println(Arrays.toString(array));
    }
}
	    
	
