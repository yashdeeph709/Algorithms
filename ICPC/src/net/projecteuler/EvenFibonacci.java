package net.projecteuler;

public class EvenFibonacci {
	public static void main(String[] args) {
		int first=0,second=1;
		int sum=0;
		while(true){
			int temp=second;
			second=first+second;
			first=temp;
			if(second>=4000000){
				break;
			}
			if(second%2==0){
				sum+=second;
			}
		}
		System.out.println(sum);
	}
}
