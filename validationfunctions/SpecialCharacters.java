package validationfunctions;
import java.util.*;


public class SpecialCharacters {
	
	static boolean special_characters_check(String S,String spec_chars)// returns true if string contains special character
	{
		
		int len = spec_chars.length();
		
		Set <Character> a = new HashSet <Character> ();
		
		for(int i=0;i<len;i++)
		{
			a.add(spec_chars.charAt(i));
		}
		
		len = S.length();
		for(int i=0;i<len;i++)
		{
			boolean exists = a.contains(new Character(S.charAt(i)));
			
			if(exists) // if character at ith of string matches with any char of special_character string
			{
				return true;
			}
		}
		return false;
	}
	public static void main(String [] args)
	{
		System.out.println(special_characters_check("Nucleus%","!@#%"));
		System.out.println(special_characters_check("Nucleus","!@#%"));
	}

}
