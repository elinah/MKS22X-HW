public class Board{
    int size;
    int[][] board;
    
    public Board(int size){
	this.size = size;
	board = new int[size][size];
	for (int row=0;row<size;row++){
	    for (int col=0;col<size;col++){
		board[row][col] = 0;
	    }
	}
    }

    public void print(){
	for (int row=0;row<size;row++){
	    for (int col=0;col<size-1;col++){
		System.out.print(board[row][col] + " ");
	    }
	    System.out.println(board[row][size-1]);
	}
	System.out.println();
    }

    public void addQueen(int row, int col){
	if (board[row][col] == 0){
	    board[row][col] = 1;
	    for (int y=col+1,dev=1;y<size;y++,dev++){
		board[row][y] -= 1;
		if (row + dev < size){
		    board[row+dev][y] -= 1;
		}
		if (row - dev > -1){
		    board[row-dev][y] -= 1;
		}
	    }
	}
    }

    public void removeQueen(int row, int col){
	if (board[row][col] == 1){
	    board[row][col] = 0;
	    for (int y=col+1,dev=1;y<size;y++,dev++){
		board[row][y] += 1;
		if (row + dev < size){
		    board[row+dev][y] += 1;
		}
		if (row - dev > -1){
		    board[row-dev][y] += 1;
		}
	    }
	}
    }

    public static void main(String[] args){
	Board a = new Board(4);
	a.print();
	a.addQueen(0,0);
	a.print();
	a.addQueen(2,1);
	a.print();
	a.removeQueen(2,1);
	a.print();
    }
}
