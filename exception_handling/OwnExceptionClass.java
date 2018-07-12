package exception_handling;

class NegMarksException extends Exception{
	
	public void errorMsg()
	{
		System.out.println("Negative Marks Exception");
	}
}

public class OwnExceptionClass {
	
	public static void main(String [] args)
	{
		int marks = -99;
		System.out.println("Marks are " + marks);
		if(marks<0)
		{
			try
			{	
			throw new NegMarksException(); // treated as checked exception
			// Therefore try catch blocks are necessary
			}
			catch(NegMarksException e)
			{
				e.errorMsg();
			}
		}
	}

}
