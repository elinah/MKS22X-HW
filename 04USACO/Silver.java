import java.util.Scanner;
import java.io.*;

public class Silver{
    Scanner in;
    int row,col,steps,startx,starty,endx,endy;
    int[][] field;

    public Silver(){
	try {
	    in = new Scanner(new File("ctravel.in.txt"));
	    row = in.nextInt();
	    col = in.nextInt();
	    steps = in.nextInt();
	    field = new int[row][col];
	    String s = "";
	    in.nextLine();
	    for(int i = 0;i < row;i++){
		s += in.nextLine();
	    }
	    for(int x = 0;x < row;x++){
		for(int y = 0;y < col;y++){
		    if(s.charAt(x*col+y) == '.'){
			field[x][y] = 0;
		    } else {
			field[x][y] = -1;
		    }
		}
	    }
	    startx = in.nextInt()-1;
	    starty = in.nextInt()-1;
	    field[startx][starty] = 1;
	    endx = in.nextInt()-1;
	    endy = in.nextInt()-1;
	} catch (FileNotFoundException e){
	    System.out.println("File not found");
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

    public void solve(){
	int[][] temp1 = new int[row][col];
	int[][] temp2;
	for(int i = 0;i < steps;i++){
	    for(int x = 0;x < row;x++){
		for(int y = 0;y < col;y++){
		    if(field[x][y] != -1){
			temp1[x][y] = 0;
			if(x+1 < row && field[x+1][y] >= 0){
			    temp1[x][y] += field[x+1][y];
			}
			if(x-1 >= 0 && field[x-1][y] >= 0){
			    temp1[x][y] += field[x-1][y];
			}
			if(y+1 < col && field[x][y+1] >= 0){
			    temp1[x][y] += field[x][y+1];
			}
			if(y-1 >= 0 && field[x][y-1] >= 0){
			    temp1[x][y] += field[x][y-1];
			}
		    } else {
			temp1[x][y] = -1;
		    }
		}
	    }
	    temp2 = field;
	    field = temp1;
	    temp1 = temp2;
	}
    }

    public void ans(){
	System.out.println(field[endx][endy] + ",7,Hvirtsman,Elina");
    }

    public static void main(String[] args){
	Silver s = new Silver();
	//s.print();
	s.solve();
	//s.print();
        s.ans();
    }
}
	
