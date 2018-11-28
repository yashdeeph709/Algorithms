/*
username: hghbahj7xnsaox
password: CoCD7bo91N
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Ideone {
	
    /**
     * Complete the function below.
     * DONOT MODIFY anything outside this function!
     */
    static int[] rearrange(int[] elements) {
        int[] binary=new int[elements.length];
        for(int i=0;i<elements.length;i++){
            int number=elements[i];
            int count=0;
            while(number!=0){
                  if((number & 0x1)==1){
                      count++;
                  }
                  number=number>>1;
            }
            binary[i]=count;
            System.out.println("Number:"+elements[i]+" "+binary[i]);
        }
        for(int i=0;i<elements.length;i++){
            for(int j=i+1;j<elements.length;j++){
                if(binary[j]<binary[i]){
                    elements[i]=elements[i]+elements[j];
                    elements[j]=elements[i]-elements[j];
                    elements[i]=elements[i]-elements[j];
                    binary[i]=binary[j]+binary[i];
                    binary[j]=binary[i]-binary[j];
                    binary[i]=binary[i]-binary[j];
                }
                if(binary[i]==binary[j] && elements[j]<elements[i]){
                   elements[i]=elements[i]+elements[j];
                   elements[j]=elements[i]-elements[j];
                   elements[i]=elements[i]-elements[j];
                    binary[i]=binary[j]+binary[i];
                    binary[j]=binary[i]-binary[j];
                    binary[i]=binary[i]-binary[j];
                }
            }
        }
        return elements;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int n = 0;
        n = Integer.parseInt(in.nextLine().trim());
        int[] elements = new int[n];
        int element;
        for (int i = 0; i < n; i++) {
            element = Integer.parseInt(in.nextLine().trim());
            elements[i] = element;
        }
        // call rearrange function
        int[] results = rearrange(elements);
        
        for (int i = 0; i < results.length; i++) {
            System.out.println(String.valueOf(results[i]));
        }
    }
}