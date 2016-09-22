import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Farmer implements Comparable<Farmer>{
	public int price;
	public int quantity;
	
	public Farmer(int price, int quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Farmer arg0) {
		if(this.price>arg0.price){
			return 1;
		}else{
			if(this.price==arg0.price){
				return 0;
			}else{
				return -1;
			}
		}
	}
}
public class MixingMilk {
	public static int requirement=0;
	public static ArrayList<Farmer> farmers=new ArrayList<Farmer>();
	public static int totalPrice;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		requirement=sc.nextInt();
		int nFarmer=sc.nextInt();
		while(nFarmer>0){
			int i=sc.nextInt();
			int j=sc.nextInt();
			farmers.add(new Farmer(i,j));
			nFarmer--;
		}
		int i=0;
		Collections.sort(farmers);
		while(requirement>0){
			Farmer farmer=farmers.get(i);
			if(farmer.quantity<=requirement){
				requirement-=farmer.quantity;
				totalPrice+=farmer.quantity*farmer.price;
			}else{
				int diff=farmer.quantity-(farmer.quantity-requirement);
				requirement-=diff;
				totalPrice+=farmer.price*diff;
			}
			i++;
		}
		System.out.println(totalPrice);
		sc.close();
	}
}
