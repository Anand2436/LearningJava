package validationfunctions;

public class EmailValidation {
	
	static boolean validate_email(String email)
	{
		
		// first char should be an alphabet
		if((email.charAt(0) < 'A' || email.charAt(0) >'Z') && (email.charAt(0) < 'a' || email.charAt(0) >'z') )
		{
				return false;
		}
		
		// basic assumptions : atleast 1 @, 1 dot and the last @ should be followed by a dot
		int count_dot = 0, count_at = 0, last_at_index= -1;
		int n = email.length();
		
		for(int i=0;i<n;i++)
		{
			if (email.charAt(i) == '@')
			{
				last_at_index = i;
				if(count_at == 0)
				{
					count_at++;
				}
			}
			
			if (email.charAt(i) == '.')
			{
				if(count_dot==0)
				{
					count_dot++;
				}
			}
			
			if (email.charAt(i)==' ')
			{
				return false;
			}
		}
		
		if(count_dot !=1 || count_at!=1)
		{
			return false;
		}
		else
		{
			// last_At_index is index of last @.We are looking for a dot after it.
			for(int i=last_at_index+2;i<n;i++)// i started from last_ind + 2 bcz there should be chars between @ and .
			{
				if(email.charAt(i) == '.' && i!=n-1) // i!=n-1 bcz there should be chars after the .
				{
					return true;
				}
			}
			return false;
		}
		
	}
	
	
	public static void main(String [] args)
	{
		System.out.println(validate_email("nucleussoftwares@gmail.com"));
		System.out.println(validate_email("@gmail.com"));
		System.out.println(validate_email("nucleussoftwares@.k"));
		System.out.println(validate_email("nucl.euss.oftwar.es@gmail.com"));
		System.out.println(validate_email("nucleussoftwares@gmail."));
	}

}
