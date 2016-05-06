import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       size = 0;
       data = (T[])new Comparable[2];
   }
   public MyHeap(T[] array){
       size = array.length;
       data = (T[])new Comparable[size];
       data[0] = null;
       for(int i = 1; i < size; i++){
	   data[i] = array[i-1];
       }   
       heapify();
   }
   private void pushDown(int k){
       if (data[k*2+1].compareTo(data[k*2]) < 0){
	   T temp = data[k];
	   data[k] = data[k*2];
	   data[k*2] = temp;
       } else {
	   T temp = data[k];
	   data[k] = data[k*2+1];
	   data[k*2+1] = temp;
       }
   }
   private void pushUp(int k){
   }
   private void heapify(){
   }
   public T delete(){
       return data[0];
   }
   public void add(T x){
   }
   private void doubleSize(){
   }
   public String toString(){
       return "";
   }

   //do this last
   //public MyHeap(boolean isMax)
   //public MyHeap(T[] array, boolean isMax)

}
