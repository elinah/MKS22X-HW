import java.util.Arrays;

public class Sorts{

    public static String name(){
	return "7,Hvirtsman,Elina";
    }
    
    public static void mergesort(int[] data){
	int[] newAr = mergeSortH(data);
	for(int i = 0;i < data.length;i++){
	    data[i] = newAr[i];
	}
    }

    private static int[] merge(int[] data1,int[] data2){
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

    private static int[] mergeSortH(int[] data){
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

    public static void selectionSort(int[] data){;
	int atCur;
	for(int cur=0;cur<data.length-1;cur++){
	    int min = cur;
	    for(int i=cur+1;i<data.length;i++){
		if (data[i] < data[min])
		    min = i;
	    }
	    atCur = data[cur];
	    data[cur] = data[min];
	    data[min] = atCur;
	}
    }

    public static void insertionSort(int[] data){
	int currentIndex = 1;
	int i;
	int intAtCurrent;
	int changeIndex;
	while (currentIndex < data.length){
	    i = currentIndex - 1;
	    intAtCurrent = data[currentIndex];
	    while (i != 0 && data[currentIndex] < data[i])
		i--;
	    if(data[currentIndex] > data[i]){
		changeIndex = currentIndex -1;
		while (changeIndex > i){
		    data[changeIndex+1] = data[changeIndex];
		    changeIndex--;
		}
		data[i+1] = intAtCurrent;
	    }
	    else if(data[currentIndex] < data[i]){
		changeIndex = currentIndex -1;
		while (changeIndex >= 0){
		    data[changeIndex+1] = data[changeIndex];
		    changeIndex--;
		}
		data[i] = intAtCurrent;
	    }
	    currentIndex++;
	}
    }

    public static void bubbleSort(int[] data){
	int atCur;
	for(int cur=data.length-1;cur>0;cur--){
	    for(int i=0;i<data.length-1;i++){
		if (data[i] > data[i+1]){
		    atCur = data[i];
		    data[i] = data[i+1];
		    data[i+1] = atCur;
		}
	    }
	}
    }

    public static void main(String[] args){
	int[] array = {2,5,3,1,8,5,87};
	int[] array2 = {87, 56, 45, 2, -4};
	Sorts m = new Sorts();
	m.mergesort(array);
	System.out.println(Arrays.toString(array));
	m.mergesort(array2);
	System.out.println(Arrays.toString(array2));
	System.out.println(m.name());
    }
}
	    
	
