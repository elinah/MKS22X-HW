public class KnightBoard{
    int[][] board;
    int num;
    
    public KnightBoard(int size){
	board = new int[size+4][size+4];
	for(int row = 0;row < size+4;row++){
	    board[row][0] = -1;
	    board[row][1] = -1;
	    board[row][size+2] = -1;
	    board[row][size+3] = -1;
	}
	for(int col = 2;col < size+2;col++){
	    board[0][col] = -1;
	    board[1][col] = -1;
	    board[size+2][col] = -1;
	    board[size+3][col] = -1;
	}
    }
    
    public KnightBoard(int rows, int cols){
	board = new int[rows+4][cols+4];
	for(int row = 0;row < rows+4;row++){
	    board[row][0] = -1;
	    board[row][1] = -1;
	    board[row][cols+2] = -1;
	    board[row][cols+3] = -1;
	}
	for(int col = 2;col < cols+2;col++){
	    board[0][col] = -1;
	    board[1][col] = -1;
	    board[rows+2][col] = -1;
	    board[rows+3][col] = -1;
	}
    }
    
    public boolean solve(){
	num = 1;
	return solveOpen(2,2);
	//return solveClosed(2,2);
    }
    
    private boolean solveOpen(int row, int col){
	if (board[row][col] != 0)
	    return false;
	board[row][col] = num;
	if (num == (board.length - 4) * (board[0].length - 4)){
	    return true;
	}
	num += 1;
	if(solveOpen(row+2,col+1)){
	    return true;
	}
	else if(solveOpen(row+2,col-1)){
	    return true;
	}
	else if(solveOpen(row-2,col+1)){
	    return true;
	}
	else if(solveOpen(row-2,col-1)){
	    return true;
	}
	else if(solveOpen(row+1,col+2)){
	    return true;
	}
	else if(solveOpen(row-1,col+2)){
	    return true;
	}
	else if(solveOpen(row+1,col-2)){
	    return true;
	}
	else if(solveOpen(row-1,col-2)){
	    return true;
	} else {
	    num -= 1;
	    board[row][col] = 0;
	    return false;
	}
    }

    /*private boolean solveOpen(int row, int col){
	board[row][col] = num;
	if (num == (board.length - 4) * (board[0].length - 4)){
	    return true;
	}
	int x,y,z,newRow,newCol;
	num += 1;
	for(int i = 0;i < 8;i++){
	    x = i % 2;
	    y = (i / 2) % 2;
	    z = (i / 4) % 2;
	    newRow = row + (int)Math.pow(-1,x) * (1 + z);
	    newCol = col + (int)Math.pow(-1,y) * (2 - z);
	    //System.out.println(newRow + ", " + newCol);
	    if (board[newRow][newCol] == 0){
		if (solveOpen(newRow,newCol)){
		    return true;
		}
	    }
	}
	num -= 1;
	board[row][col] = 0;
	return false;
	}*/

    private boolean solveClosed(int row, int col){
	if (board[row][col] != 0)
	    return false;
	board[row][col] = num;
	if (num == (board.length - 4) * (board[0].length - 4)){
	    if ((Math.abs(row - 2) == 1 && Math.abs(col - 2) == 2) ||
		(Math.abs(row - 2) == 2 && Math.abs(col - 2) == 1)){
		return true;
	    } else {
		board[row][col] = 0;
		return false;
	    }
	}
	num += 1;
	if(solveClosed(row+2,col+1)){
	    return true;
	}
	else if(solveClosed(row+2,col-1)){
	    return true;
	}
	else if(solveClosed(row-2,col+1)){
	    return true;
	}
	else if(solveClosed(row-2,col-1)){
	    return true;
	}
	else if(solveClosed(row+1,col+2)){
	    return true;
	}
	else if(solveClosed(row-1,col+2)){
	    return true;
	}
	else if(solveClosed(row+1,col-2)){
	    return true;
	}
	else if(solveClosed(row-1,col-2)){
	    return true;
	} else {
	    num -= 1;
	    board[row][col] = 0;
	    return false;
	}
    }
    
    /*private boolean solveClosed(int row, int col){
	board[row][col] = num;
	if (num == (board.length - 4) * (board[0].length - 4)){
	    if ((Math.abs(row - 2) == 1 && Math.abs(col - 2) == 2) ||
		(Math.abs(row - 2) == 2 && Math.abs(col - 2) == 1)){
		return true;
	    } else {
		board[row][col] = 0;
		return false;
	    }
	}
	int x,y,z,newRow,newCol;
	num += 1;
	for(int i = 0;i < 8;i++){
	    x = i % 2;
	    y = (i / 2) % 2;
	    z = (i / 4) % 2;
	    newRow = row + (int)Math.pow(-1,x) * (1 + z);
	    newCol = col + (int)Math.pow(-1,y) * (2 - z);
	    //System.out.println(newRow + ", " + newCol);
	    if (board[newRow][newCol] == 0){
		if (solveClosed(newRow,newCol)){
		    return true;
		}
	    }
	}
	num -= 1;
	board[row][col] = 0;
	return false;
	}*/

    public void printSolution(){
	for (int row=0;row<board.length;row++){
	    for (int col=0;col<board[0].length;col++){
		if (board[row][col] >= 0){
		    if (board.length * board[0].length >= 10 &&
			board[row][col] < 10){
			System.out.print("_" + board[row][col] + " ");
		    } else {
		        System.out.print(board[row][col] + " ");
		    }
		}
	    }
	    System.out.println();
	}
	System.out.println();
    }

    public static void main(String[] args){
	KnightBoard a = new KnightBoard(6);
	a.printSolution();
	System.out.println(a.solve());
	a.printSolution();
	KnightBoard b = new KnightBoard(3,10);
	b.printSolution();
	System.out.println(b.solve());
	b.printSolution();
    }
}
