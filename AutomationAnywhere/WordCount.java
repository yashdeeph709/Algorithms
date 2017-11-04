import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class WordCount{    
    public static int word_count(String[] input,String input2)
    {
	for(int i=0;i<input.length;i++){
		input[i]=input[i].replaceAll("#","");
		//System.out.println(input[i].length());
	}
        int count=0;
        for(int i=0;i<input.length;i++){
	    //System.out.println(input[0].length()+""+input[i]);
            for(int j=0;j<input[0].length();j++){
		//System.out.println("++Position Started:"+i+","+j);
                if(input[i].charAt(j)==input2.charAt(0)){
		    //System.out.println("negative diagonal");
                    count+=diagonalCheck(input,input2,i,j,-1)?1:0;
		    //System.out.println("diagonal");
                    count+=diagonalCheck(input,input2,i,j,0)?1:0;
		    //System.out.println("positive diagonal");
                    //count+=diagonalCheck(input,input2,i,j,1)?1:0;
		    //System.out.println("horizontal");
                    count+=checkHorizontalAndVertical(input,input2,i,j,0)?1:0;
		    //System.out.println("vertical");
                    count+=checkHorizontalAndVertical(input,input2,i,j,1)?1:0;
                }
		//System.out.println("Position Ended:"+i+","+j);
            }
        }
	return count;
    }
    public static boolean diagonalCheck(String[] input1,String input2,int i,int j,int k){
	//System.out.println("Diagonal Start");
        int rowdiff=0,coldiff=0;
        switch(k){
            case 0:
            rowdiff=1;
            coldiff=1;
            break;
            case 1:
            rowdiff=1;
            coldiff=-1;
            break;
            case -1:
            rowdiff=-1;
            coldiff=1;
            break;
        }

        if(k==0 && (i+input2.length()-1>input1.length || j+input2.length()-1>input1[0].length())){
            //System.out.println("k==0"+input1[i].charAt(j));
       	    //System.out.println("Diagonal End");
            return false;
        }
        if(k==-1 && (input2.length()>i+1 || j+input2.length()-1>input1[0].length())){
            //System.out.println("k==-1"+input1[i].charAt(j));
       	    //System.out.println("Diagonal End");
            return false;
        }
        if(k==1 && (i+input2.length()-1>input1.length || input2.length()>j+1)){
            //System.out.println("k==1"+input1[i].charAt(j));
            //System.out.println("Diagonal End");
            return false;
        }

        int col=j,row=i,x=0;
        boolean result=false;
        while(input1[row].charAt(col)==input2.charAt(x)){
            //System.out.println("row="+row+",col="+col+",input1[row]="+input1[row]+",input2="+input2+",x"+x);
            row+=rowdiff;
            col+=coldiff;
            x++;
            if(x==input2.length()){
                result=true;
                break;
            }
        }
	if(result){
		//System.out.println("match found");
	}
	//System.out.println("Diagonal End");
        return result;
    }
    /*
     * k=0 horizontal ell in hello
     * k=1 vertical lll in hello,hello,hello 
     */
    public static boolean checkHorizontalAndVertical(String[] input1,String input2,int i,int j,int k){
	//System.out.println("Start Horizon or Vert");
        if(k==0 && (j+input2.length()-1<input1[0].length())){
            int rowdiff=0,coldiff=1;
            int row=i,col=j,x=0;
            boolean result=false;
            while(input1[row].charAt(col)==input2.charAt(x)){
                row+=rowdiff;
                col+=coldiff;
                x++;
                if(x==input2.length()){
                    result=true;
                    break;
                }
            }
	//System.out.println("End Horizon or Vert");
            return result;
        } 
        if(k==1 && (i+input2.length()-1<input1.length)){
            int rowdiff=1,coldiff=0;
            int row=i,col=j,x=0;
            boolean result=false;
            while(input1[row].charAt(col)==input2.charAt(x)){
                row+=rowdiff;
                col+=coldiff;
                x++;
                if(x==input2.length()){
                    result=true;
                    break;
                }
            }
	//System.out.println("End Horizon or Vert");
            return result;
        }
	//System.out.println("End H or V");
        return false;
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(//System.in);
        int output = 0;
        int ip1_size = 0;
        ip1_size = Integer.parseInt(in.nextLine().trim());
        String[] ip1 = new String[ip1_size];
        String ip1_item;
        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
            try {
        ip1_item = in.nextLine();
            } catch (Exception e) {
        ip1_item = null;
            }
            ip1[ip1_i] = ip1_item;
        }
        String ip2 = in.nextLine().trim();
        output = word_count(ip1,ip2);
        //System.out.println(String.valueOf(output));
    }
}
