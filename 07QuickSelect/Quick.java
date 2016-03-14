import java.util.*;

public class Quick{

    public static String name(){
	return "7,Hvirtsman,Elina";
    }

    private static int partitionOld(int[] data, int left, int right){
	int part = (int)(left + (Math.random() * (right-left+1)));
	int temp = data[right];
	data[right] = data[part];
	data[part] = temp;
	int end = right;
	if (left == right){
	    return right;
	}
	right--;
	while (left != right){
	    if (data[left] <= data[end]){
		left++;
	    } else {
		temp = data[left];
		data[left] = data[right];
		data[right] = temp;
		right--;
	    }
	}
	if (data[right] < data[end]){
	    temp = data[right+1];
	    data[right+1] = data[end];
	    data[end] = temp;
	    return right+1;
	} else {
	    temp = data[right];
	    data[right] = data[end];
	    data[end] = temp;
	    return right;
	}
    }

    public static int quickSelectOld(int[] data, int k){
	return quickSelectOld(data,k,0,data.length-1);
    }
    
    private static int quickSelectOld(int[] data, int k, int left, int right){
	int part = partitionOld(data,left,right);
	if (k != part){
	    if (k < part){
		return quickSelectOld(data, k, left, part - 1);
	    } else {
		return quickSelectOld(data, k, part + 1, right);
	    }
	}
	return data[part];
    }

    public static void quickSortOld(int[] data){
	quickSortOld(data,0,data.length-1);
    }

    private static void quickSortOld(int[] data, int left, int right){
	if (right - left > 0){
	    int part = partitionOld(data,left,right);
	    quickSortOld(data,left,part - 1);
	    quickSortOld(data,part + 1,right);
	}
    }

    private static int[] partition(int[] data, int[] tempAry, int left, int right){
	int[] retAry = new int[2];
	if (left == right){
	    retAry[0] = left;
	    retAry[1] = right;
	} else {
	    int part = (int)(left + (Math.random() * (right-left+1)));
	    //int[] tempAry = new int[data.length];
	    int start = left;
	    int end = right;
	    for(int i = left;i < right+1;i++){
		if (data[i] < data[part]){
		    tempAry[start] = data[i];
		    start++;
		} else if (data[i] > data[part]){
		    tempAry[end] = data[i];
		    end--;
		}
	    }
	    //System.out.println("tempAry: " + Arrays.toString(tempAry));
	    int retLeft = start;
	    while (start <= end){
		tempAry[start] = data[part];
		start++;
	    }
	    for(int i = left;i < right+1;i++){
		data[i] = tempAry[i];
	    }
	    //System.out.println("data: " + Arrays.toString(data));
	    retAry[0] = retLeft;
	    retAry[1] = end;
	}
	//System.out.println("retAry: " + Arrays.toString(retAry));
	return retAry;
    }

    public static int quickSelect(int[] data, int k){
	return quickSelect(data,k,0,data.length-1);
    }
    
    private static int quickSelect(int[] data, int k, int left, int right){
	int[] tempAry = new int[data.length];
	int[] part = partition(data,tempAry,left,right);
	if (k != part[0]){
	    if (k < part[0]){
		return quickSelect(data, k, left, part[0] - 1);
	    } else {
		return quickSelect(data, k, part[1] + 1, right);
	    }
	}
	return data[part[0]];
    }

    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }

    private static void quickSort(int[] data, int left, int right){
	if (right - left > 0){
	    int[] tempAry = new int[data.length];
	    int[] part = partition(data,tempAry,left,right);
	    quickSort(data,left,part[0] - 1);
	    quickSort(data,part[1] + 1,right);
	}
    }

		
    public static void main(String[] args){
	//int[] ary = {16,23,48,1,23,56,23,45,23,23,23,23,23,23,23,23};
	//quickSort(ary);
	//System.out.println(quickselect(ary,0));
	//System.out.println(partition(ary,0,13));
	//System.out.println(Arrays.toString(ary));
        int[] d = new int [4000000];
	int[] c = new int [d.length];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	quickSort(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));
	
    }
}
	
