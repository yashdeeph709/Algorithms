import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class Tester {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] balanced=new int[expressions.length];
        for(int i=0;i<expressions.length;i++){
            int replacements=0;
            int opening=0,closing=0,anamolies=0;
            for(int j=0;j<expressions[i].length();j++){
                if(expressions[i].charAt(j)=='<'){
                    opening++;
                }
                if(expressions[i].charAt(j)=='>'){
                    if(opening==0){
                        anamolies++;
                        continue;
                    }
                    opening--;
                }
            }
            if(anamolies<=maxReplacements[i] && opening==0){
                balanced[i]=1;
            }
        }
        return balanced;
    }

   public static void main(String args[]){
   	String[] expressions=new String[]{"<<<>>>","<<<>>>>","<<<<<<<","<<<<<<",">>>>>>>",">>>>","<><><>>","><><>"};
	int[] replacements=new int[]{1,1,100,100,100,100,100,100};
	int[] results=balancedOrNot(expressions,replacements);
	for(int i=0;i<results.length;i++){
		System.out.println(results[i]);
	}
   }
    /**
     * DO NOT MODIFY THIS METHOD!
     */
/*     public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] res;
        
        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for (int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }
        
        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for (int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }
        
        res = balancedOrNot(_expressions, _maxReplacements);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
*/}