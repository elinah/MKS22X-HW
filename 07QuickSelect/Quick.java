import java.util.*;

public class Quick{

    public static String name(){
	return "7,Hvirtsman,Elina";
    }

    private static int partition(int[] data, int left, int right){
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

    public static int quickselect(int[] data, int k){
	return quickselect(data,k,0,data.length-1);
    }
    
    private static int quickselect(int[] data, int k, int left, int right){
	int part = partition(data,left,right);
	if (k != part){
	    if (k < part){
		return quickselect(data, k, left, part - 1);
	    } else {
		return quickselect(data, k, part + 1, right);
	    }
	}
	return data[part];
    }

    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }

    private static void quickSort(int[] data, int left, int right){
	if (right - left > 0){
	    int part = partition(data,left,right);
	    quickSort(data,left,part - 1);
	    quickSort(data,part + 1,right);
	}
    }

		
    public static void main(String[] args){
	Quick a = new Quick();
	int[] ary = {16,48,1,23,56,45};
	a.quickSort(ary);
	//System.out.println(a.quickselect(ary,0));
	//System.out.println(a.partition(ary,0,13));
	System.out.println(Arrays.toString(ary));
    }
}
	
