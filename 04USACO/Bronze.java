import java.util.Scanner;
import java.io.*;

public class Bronze{
    Scanner in;
    int[][] field;
    int elev;
    int numInst;
	
    public Bronze(){
	try {
	    in = new Scanner(new File("makelake.in.txt"));
	} catch (FileNotFoundException e){
	    System.out.println("File not found");
	}
	int row = in.nextInt();
	int col = in.nextInt();
	elev = in.nextInt();
	numInst = in.nextInt();
	field = new int[row][col];
	for(int i = 0;i < row;i++){
	    for(int j = 0;j < col;j++){
		field[i][j] = in.nextInt();
	    }
	}
    }

    private void print(){
	for(int i = 0;i < field.length;i++){
	    for(int j = 0;j < field[0].length;j++){
		System.out.print(field[i][j]+" ");
	    }
	    System.out.println();
	}
	System.out.println();
    }

    private void stomp(){
	for(int n = 0;n < numInst;n++){
	    int r = in.nextInt();
	    int c = in.nextInt();
	    int decrease = in.nextInt();
	    int max = field[r-1][c-1];
	    for(int i = r-1;i < r + 2;i++){
		for(int j = c-1;j < c + 2;j++){
		    if (max < field[i][j])
			max = field[i][j];
		}
	    }
	    int num = max - decrease;
	    for(int i = r-1;i < r + 2;i++){
		for(int j = c-1;j < c + 2;j++){
		    if (field[i][j] > num)
			field[i][j] = num;
		}
	    }
	}
    }

    private void solve(){
	int sum = 0;
	for(int i = 0;i < field.length;i++){
	    for(int j = 0;j < field[0].length;j++){
		if (elev - field[i][j] > 0)
		    sum += elev - field[i][j];
	    }
	}
	int ans = sum * 72 * 72;
	System.out.println(ans + ",7,Hvirtsman,Elina");
    }
	    
    public static void main(String[] args){
	Bronze a = new Bronze();
	a.stomp();
	a.solve();
    }
}
