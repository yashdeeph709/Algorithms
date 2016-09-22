
public class InsertionSort {
	public static int[] insertion(int ...input){
		for(int i=0;i<input.length;i++){
			int key=input[i];
			for(int j=i;j>=0;j--){
				if(key>input[j]){
					input[j+1]=input[j];
					input[j]=key;
				}
			}
		}
		return input;
	}
	public static void main(String[] args) {
		int[] a=insertion(12,11,45,6,58,4,1,58,7);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}

}
