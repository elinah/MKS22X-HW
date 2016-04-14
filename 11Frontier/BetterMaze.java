import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	private int[] location;
	private Node prev;
	
	private Node(int x,int y,Node prev){
	    location = new int[2];
	    location[0] = x;
	    location[1] = y;
	    this.prev = prev;
	}

	private Node getPrev(){
	    return prev;
	}

	private int[] getValue(){
	    return location;
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false
    private boolean solved = false;
    
    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/
	int[] copy;
	if (solved){
	    copy = new int[solution.length];
	    for (int i = 0;i < solution.length;i++){
		copy[i] = solution[i];
	    }
	} else {
	    copy = new int[0];
	}
	return copy;
    }    


    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){  
        /** IMPLEMENT THIS **/
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


    /**initialize the frontier as a stack and call solve
     */ 
    public boolean solveDFS(){  
        /** IMPLEMENT THIS **/
	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

    /**Search for the end of the maze using the frontier. 
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
        /** IMPLEMENT THIS **/
	Node next;
	if (startRow < maze.length && startCol < maze[0].length &&
	    maze[startRow][startCol] == 'S'){
	    placesToGo.add(new Node(startRow,startCol,null));
	    maze[startRow][startCol] = '.';
	}
	
	while (placesToGo.hasNext()){
	    next = placesToGo.next();
	    int[] loc = next.getValue();
	    if (loc[0]+1 < maze.length){
		if (maze[loc[0]+1][loc[1]] == ' '){
		    placesToGo.add(new Node(loc[0]+1,loc[1],next));
		    maze[loc[0]+1][loc[1]] = '.';
		} else if (maze[loc[0]+1][loc[1]] == 'E'){
		    toCoordinates(loc[0]+1,loc[1],next);
		    solved = true;
		    return true;
		}
	    }
	    if (loc[0]-1 > 0){
		if (maze[loc[0]-1][loc[1]] == ' '){
		    placesToGo.add(new Node(loc[0]-1,loc[1],next));
		    maze[loc[0]-1][loc[1]] = '.';
		} else if (maze[loc[0]-1][loc[1]] == 'E'){
		    toCoordinates(loc[0]-1,loc[1],next);
		    solved = true;
		    return true;
		}
	    }
	    if (loc[1]+1 < maze[0].length){
		if (maze[loc[0]][loc[1]+1] == ' '){
		    placesToGo.add(new Node(loc[0],loc[1]+1,next));
		    maze[loc[0]][loc[1]+1] = '.';
		} else if (maze[loc[0]][loc[1]+1] == 'E'){
		    toCoordinates(loc[0],loc[1]+1,next);
		    solved = true;
		    return true;
		}
	    }
	    if (loc[1]-1 > 0){
		if (maze[loc[0]][loc[1]-1] == ' '){
		    placesToGo.add(new Node(loc[0],loc[1]-1,next));
		    maze[loc[0]][loc[1]-1] = '.';
		} else if (maze[loc[0]][loc[1]-1] == 'E'){
		    toCoordinates(loc[0],loc[1]-1,next);
		    solved = true;
		    return true;
		}
	    }
	}	
	return false;
    }

    private void toCoordinates(int x,int y,Node path){
	int n = 2;
	Node temp = path;
	while (temp != null){
	    n += 2;
	    temp = temp.getPrev();
	}
	solution = new int[n];
	solution[n-1] = x;
	solution[n-2] = y;
	int i = n - 3;
	while (path != null){
	    solution[i] = path.getValue()[0];
	    solution[i-1] = path.getValue()[1];
	    i -= 2;
	    path = path.getPrev();
	}
    }

     
    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  
	/** IMPLEMENT THIS **/ 
	animate = b;
    }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    
    
    public static void main(String[] args){
	BetterMaze a = new BetterMaze("data2.dat");
	a.solveDFS();
	System.out.println(Arrays.toString(a.solutionCoordinates()));
    }
       
}
