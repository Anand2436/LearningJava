package validationfunctions;
import java.util.*;

public class DomainValidation {
	
	// validate domain for int data type
	static boolean validate_domain(int val,ArrayList <Integer> L)
	{
		Set <Integer> s = new HashSet<Integer>(L);
		
		if (s.contains(val))
		{
			return true;
		}
		
		return false;
	}
	
	// validation for string data type
	static boolean validate_domain(String val,ArrayList <String> L)
	{
		Set <String> s = new HashSet<String>(L);
		
		if (s.contains(val))
		{
			return true;
		}
		
		return false;
	}
	
	
	
	public static void main(String [] args)
	{
		// Checking for int values
		Integer arr[] = {4,15,6,7};
		ArrayList <Integer> list = new ArrayList <Integer> ();
		Collections.addAll(list,arr);
		  
		System.out.println(validate_domain(5,list));
		
		// Checking for String values
		String arr1[]={"Mon","Tues","Wed","Thurs","Fri"};
		ArrayList <String> list1 = new ArrayList <String> ();
		Collections.addAll(list1,arr1);
		  
		System.out.println(validate_domain("Mon",list1));
		System.out.println(validate_domain("Sun",list1));
	}

}
