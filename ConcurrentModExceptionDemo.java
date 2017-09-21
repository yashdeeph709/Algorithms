import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Iterator; 
import java.util.List; 
public class ConcurrentModExceptionDemo{ 
	public static void main(String args[]) { 
		List<String> listOfPhones = new ArrayList<String>(Arrays.asList( "iPhone 6S", "iPhone 6", "iPhone 5", "Samsung Galaxy 4", "Lumia Nokia")); 
		System.out.println("list of phones: " + listOfPhones); 
		// Iterating and removing objects from list 
		// This is wrong way, will throw ConcurrentModificationException 
		for(String phone : listOfPhones){ 
			if(phone.startsWith("iPhone")){ 
			 //listOfPhones.remove(phone);  
			}
		} 
		for(Iterator<String> itr = listOfPhones.iterator(); itr.hasNext();){ 
			String phone = itr.next(); 
			if(phone.startsWith("iPhone")){ 
			itr.remove();
			} 
		} 
		System.out.println("list after removal: " + listOfPhones); 
	}
}
