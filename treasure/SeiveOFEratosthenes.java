public class SeiveOFEratosthenes{
	public static void main(String args[]){
		long startTime=System.currentTimeMillis();
		for(int x=2;x<5000;x++){
			 int i,m=0,flag=0;    
			  int n=x;//it is the number to be checked  
			  m=n/2;    
			  for(i=2;i<=m;i++){    
			   if(n%i==0){    
			   flag=1;    
			   break;    
			   }    
			  }    
			  if(flag==0){    
			  	System.out.println(n);
			  }    
		}  	
		System.out.println(System.currentTimeMillis()-startTime);
	}
}
