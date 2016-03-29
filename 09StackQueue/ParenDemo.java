public class ParenDemo{
    
    private MyStack<String> data = new MyStack<String>();

    public static boolean isMatching(String s){
	for(int i = 0;i < s.length();i++){
	    if(s.substring(i,i+1).equals("(") || s.substring(i,i+1).equals("[") || s.substring(i,i+1).equals("{") || s.substring(i,i+1).equals("<")){
		data.push(s.substring(i,i+1));
	    } else if(s.substring(i,i+1).equals(")")){
		if (data.pop().equals("(")){
		    data.remove();
		} else {
		    return false;
		}
	    } else if(s.substring(i,i+1).equals("]")){
		if (data.pop().equals("[")){
		    data.remove();
		} else {
		    return false;
		}
	    } else if(s.substring(i,i+1).equals("}")){
		if (data.pop().equals("{")){
		    data.remove();
		} else {
		    return false;
		}
	    } else if(s.substring(i,i+1).equals(">")){
		if (data.pop().equals(">")){
		    data.remove();
		} else {
		    return false;
		}
	    }
	}
	return true;
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }
}
