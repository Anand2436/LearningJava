package validationfunctions;

public class DataLengthValidation {
		
		//Data_Length_validation 
		//2 functions 
		// for string data type
		static boolean length_validation(String S,int max_len)
		{
			if(S.length()<=max_len)
			{
				return true;
			}
			
			return false;
		}
		
		// for int data type
		// can be easily used for long long
		static boolean length_validation(int num,int max_dig)
		{
			int count = 0;
			
			while(num!=0)
			{
				num = num/10;
				count++;
			}
			
			if(count<=max_dig)
			{
				return true;
			}
			
			return false;
		}
		
		
		
		public static void main(String [] args)
		{
			System.out.println(length_validation(5,10));
			System.out.println(length_validation("Rahul The Nsit Sky",10));
			System.out.println(length_validation(563478,4));
		}

	}
