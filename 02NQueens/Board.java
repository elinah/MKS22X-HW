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
    }

    public static void main(String[] args){
	Board a = new Board(5);
	a.print();
    }
}
