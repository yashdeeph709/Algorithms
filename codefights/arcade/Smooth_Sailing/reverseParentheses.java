public class ReverseParanthese{
	public static void main(String args[]){
		/*String input="ya(shde)ep";
		System.out.println("input"+input);
		System.out.println(reverseParentheses(input));
		input="yash(d(ei)p)";
		System.out.println("input"+input);
		System.out.println(reverseParentheses(input));
		input="(yash)deep";
		System.out.println("input"+input);
		System.out.println(reverseParentheses(input));
		input="co(de(fight)s)";
		System.out.println("input"+input);
		System.out.println(reverseParentheses(input));*/
		String input="ab(c(de)(fg)h)ij";
		System.out.println("input"+input);
		System.out.println(reverseParentheses(input));
	}
	public static String reverseParentheses(String s) {
	    String input=s;
	    int[] openingBrackets=new int[s.length()];
	    int count=0;
	    for(int i=0;i<input.length();i++){
		System.out.println(i+" "+input.charAt(i));
	        if(input.charAt(i)=='('){
	            openingBrackets[count]=i;
	            System.out.println("Added opening of"+i+" at "+count);
	            count++;
	        }else if(input.charAt(i)==')'){
	            int openIndex=openingBrackets[count-1];
	            String chunk=new StringBuffer(input.substring(openIndex+1,i)).reverse().toString();
	            System.out.println("Reversed Chunk is :"+chunk);
	            System.out.println(0+","+(openIndex-1)+" "+(i+1)+" "+input.length());
		    input=overwriteOriginal(input,chunk,openIndex+1,i); 
		    System.out.println(input);
	            count-=1;
		    i-=2;
	        }
	    }
	    return input;
	}
	public static String overwriteOriginal(String input,String chunk,int start,int end){
		String startchunk=null,endchunk=null;
		if(start>=0){
			startchunk=(input.substring(0,start-1));
		}
		if(end+1<input.length() || end>=0){
			endchunk=(input.substring(end+1));
		}
		if(startchunk!=null){
			input=startchunk+chunk;
		}else{
			input=chunk;
		}
		if(endchunk!=null){
			input+=endchunk;
		}
		return input;
	}
}
