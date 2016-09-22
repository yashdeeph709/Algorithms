import java.util.ArrayList;

public class PrimePalindromFinder {
	public static boolean isPalindrome(int i){
		String result="";
		int input=i;
		int j=10;
		while(i>0){
			result+=i%j;
			i=i/j;
		}
		boolean prime=false,palindrome=false;
		if(Integer.parseInt(result)==input){
			palindrome=true;
			for(int k=2;k<input/2;k++){
				if(input%k==0){
					prime=true;
				}
			}
		}
		if(!prime && palindrome){
			return true;
		}
		return false;
	}
	public static ArrayList<Integer> listOfPandromes(int min,int max){
		ArrayList<Integer> palindromes=new ArrayList<Integer>();
		for(int i=min;i<max;i++){
			if(isPalindrome(i)){
				palindromes.add(i);
			}
		}
		return palindromes;
	}
	public static void main(String[] args) {
		System.out.println(listOfPandromes(5,500));
	}

}
