public class Recursion implements hw01{

    public String name(){
	return "Hvirtsman,Elina";
    }

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n, n / 2);
    }

    public double sqrtHelper(double n, double guess){
	if (guess * guess > n - .0000000000001 && guess * guess < n + .0000000000001){
	    return guess;
	} else {
	    return sqrtHelper(n, (n / guess + guess) / 2);
	}
    }
}
	
