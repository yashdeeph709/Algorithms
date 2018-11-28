import java.io.*;

class PrimeGenSieveOfEra{
  static int size=1000000;
  static int[] memo=new int[size];

  public static void initSieve(){
    for(int i=2;i<10000000;i++){
      if(memo[i]!=-1){
        for(int j=2;j<10000000;j++){
           memo[i*j]=-1;
        }
      }
    }
  }

  public static void main(String args[]){
    initSieve();
    for(int i=0;i<10;i++){
      System.out.println(memo[i]);
    }
  }
}
