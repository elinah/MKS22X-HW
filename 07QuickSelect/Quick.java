import java.util.*;

public class Quick{

    private static int partition(int[] data, int left, int right){
	int part = (int)(left + (Math.random() * (right-left+1)));
	//System.out.println(data[part]);
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
	    //System.out.println(Arrays.toString(data));
	    return right+1;
	} else {
	    temp = data[right];
	    data[right] = data[end];
	    data[end] = temp;
	    //System.out.println(Arrays.toString(data));
	    return right;
	}
    }

    public static int quickselect(int[] data, int k){
	int left = 0;
	int right = data.length-1; 
	int part = partition(data,left,right);
	//System.out.println(part);
	while (k != part){
	    if (k < part){
		right = part - 1;
		//System.out.println("Hello " + left + ", " + right);
		part = partition(data,left,right);
	    } else {
		left = part + 1;
		//System.out.println("Hey " + left + ", " + right);
		part = partition(data,left,right);
	    }
	    //System.out.println(part);
	    //System.out.println(left + ", " + right);
	}
	return data[part];
    }

		
    public static void main(String[] args){
	Quick a = new Quick();
	int[] ary = {16,48,1,23,56,45};
	System.out.println(a.quickselect(ary,0));
	//System.out.println(a.partition(ary,0,13));
	//System.out.println(Arrays.toString(ary));
    }
}
	
