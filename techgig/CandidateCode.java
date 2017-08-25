import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class CandidateCode {
    public static String operations_seq(int[][] input1,int[][] input2)
    {
	String result="yes";
	HashMap<Integer,Integer> occurrences1 = new HashMap<Integer,Integer>();
	HashMap<Integer,Integer> occurrences2 = new HashMap<Integer,Integer>();
	HashSet<Integer> locations1 = new HashSet<Integer>();
	HashSet<Integer> locations2 = new HashSet<Integer>();

	for(int i=0;i<input2.length;i++){
		for(int j=0;j<input2[i].length;j++){
			Integer value=occurrences1.get(input2[i][j]);
			if(value==null){
				occurrences1.put(input2[i][j],1);
			}else{
				occurrences1.put(input2[i][j],value++);
			}
			locations1.add(input2[i][j]+""+j);
		}
	}
	for(int i=0;i<input1.length;i++){
		for(int j=0;j<input1[i].length;j++){
			Integer value=occurrences2.get(input1[i][j]);
			if(value==null){
				occurrences2.put(input1[i][j],1);
			}else{
				occurrences2.put(input1[i][j],value++);
			}
		}
		locations2.add(input1[i][j]+""+j);
	}

	for(Integer k:occurrences1.keySet()){
		if(!occurrences1.get(k).equals(occurrences2.get(k))){
			result="no";
		}else{
			//System.out.println("FirstMap:key"+k+":"+occurrences1.get(k)+":"+occurrences2.get(k));
		}
	}
	for(

        return result;		    
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String output;
        int ip1_rows = 0;
        int ip1_cols = 0;
        ip1_rows = Integer.parseInt(in.nextLine().trim());
        ip1_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] ip1 = new int[ip1_rows][ip1_cols];
        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
                ip1[ip1_i][ip1_j] = in.nextInt();
                
            }
        }
        in.nextLine();
        int ip2_rows = 0;
        int ip2_cols = 0;
        ip2_rows = Integer.parseInt(in.nextLine().trim());
        ip2_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] ip2 = new int[ip2_rows][ip2_cols];
        for(int ip2_i=0; ip2_i<ip2_rows; ip2_i++) {
            for(int ip2_j=0; ip2_j<ip2_cols; ip2_j++) {
                ip2[ip2_i][ip2_j] = in.nextInt();
                
            }
        }
        output = operations_seq(ip1,ip2);
        System.out.println(String.valueOf(output));
    }
}
