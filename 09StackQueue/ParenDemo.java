public class ParenDemo{

    public static boolean isMatching(String s){
	MyStack<String> data = new MyStack<String>();
	for(int i = 0;i < s.length();i++){
	    if(s.substring(i,i+1).equals("(") || s.substring(i,i+1).equals("[") || s.substring(i,i+1).equals("{") || s.substring(i,i+1).equals("<")){
		data.push(s.substring(i,i+1));
	    } else if(s.substring(i,i+1).equals(")")){
		if (!data.isEmpty() && data.peek().equals("(")){
		    data.pop();
		} else {
		    return false;
		}
	    } else if(s.substring(i,i+1).equals("]")){
		if (!data.isEmpty() && data.peek().equals("[")){
		    data.pop();
		} else {
		    return false;
		}
	    } else if(!data.isEmpty() && s.substring(i,i+1).equals("}")){
		if (data.peek().equals("{")){
		    data.pop();
		} else {
		    return false;
		}
	    } else if(!data.isEmpty() && s.substring(i,i+1).equals(">")){
		if (data.peek().equals("<")){
		    data.pop();
		} else {
		    return false;
		}
	    }
	}
	if (data.size() > 0){
	    return false;
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
