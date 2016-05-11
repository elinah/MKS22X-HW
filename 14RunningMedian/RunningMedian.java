import java.util.*;

public class RunningMedian{
    MyHeap<Integer> smallValue, largeValue;
    int smallSize, largeSize; 
    
    public RunningMedian(){
	smallValue = new MyHeap<Integer>();
	largeValue = new MyHeap<Integer>(false);
    }

    public double getMedian(){
	//System.out.println("smallSize: "+smallSize+" largeSize: "+largeSize);
	if (smallSize == 0 && largeSize == 0)
	    throw new NoSuchElementException();
	else if (smallSize == 0 || largeSize - smallSize == 1)
	    return (double)largeValue.peek();
	else if (largeSize == 0 || smallSize - largeSize == 1)
	    return (double)smallValue.peek();
	else
	    return ((double)smallValue.peek() + (double)largeValue.peek()) / 2;
    }

    public void add(Integer x){
	try {
	    if (getMedian() > x){
		smallValue.add(x);
		smallSize++;
	    } else {
		largeValue.add(x);
		largeSize++;
	    }
	    //System.out.println("Before: smallSize: "+smallSize+" largeSize: "+largeSize);
	    if (smallSize - largeSize > 1){
	        largeValue.add(smallValue.delete());
		largeSize++;
		smallSize--;
	    } if (largeSize - smallSize > 1){
		smallValue.add(largeValue.delete());
		smallSize++;
		largeSize--;
	    }
	    //System.out.println("After: smallSize: "+smallSize+" largeSize: "+largeSize);
	} catch (NoSuchElementException e) {
	    largeValue.add(x);
	    largeSize++;
	}
    }

    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	//System.out.println(a.getMedian());
	a.add(5);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
	a.add(7);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
	a.add(3);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
	a.add(9);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
	a.add(2);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
	a.add(-1);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
	a.add(21);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
	a.add(60);
	System.out.println("smallValue: "+a.smallValue.toString());
	System.out.println("largeValue: "+a.largeValue.toString());
	System.out.println(a.getMedian());
    }
}
