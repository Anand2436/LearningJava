package validationfunctions;
import java.util.*;

public class FormatValidation {

	static boolean format_validation(String format,String input)
	{
		// the format should strictly match
		if (input.length()!=format.length())
			{
				return false;
			}
		
		Set <Character> S = new HashSet<Character> ();
		
		// array of symbols used in formats, can be changes acc to users need
		Character [] arr ={'!','@','#','$','%','^','&','*',' ','_','-','+','=','/','?','.','|','~'};
		Collections.addAll(S, arr);
		
		Character [] index = new Character[15]; // assuming that the maximum length for format will be 14
		int counter = 0;
		
		for(int i=0;i<format.length();i++)
		{
			if (S.contains(new Character(format.charAt(i))))
					{
						index[i] = new Character(format.charAt(i));
						//System.out.println(i);
						//System.out.println(index[i]);
						counter++;
					}
			else
					{
						index[i] = 'x';
					}
		}
		//System.out.println(counter);
		for(int i=0;i<input.length();i++)
		{
			//System.out.println(i);
			if (S.contains(new Character(input.charAt(i))))
					{
						if(index[i].compareTo(new Character(input.charAt(i))) !=0)
						{
							return false;
						}
						else
						{
							counter--;
						}
					}
		}
		
		if(counter==0)
		{
			return true;
		}
		
		return false;
	}
	
	public static void main(String [] args)
	{
		System.out.println(format_validation("02-04-1997","08/03/1342"));
		System.out.println(format_validation("02/04/1997","08/03/1342"));
		System.out.println(format_validation("02,apr 1997","08,02 1342"));
		System.out.println(format_validation("02,jun,1997","08,dec,1342"));
		System.out.println(format_validation("02^08^1997","08^03^1342"));
	}
}
