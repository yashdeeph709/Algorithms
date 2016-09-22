package com.hackerrank.woc21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Kangaroo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\tests\\KangarooTests"));
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        if(v1<=v2){
            System.out.println("NO");
            return;
        }
        float diff=(x2-x1)/(v1-v2);
        int diffi=(x2-x1)/(v1-v2);
        if(diff-diffi>0){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}
