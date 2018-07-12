package exception_handling;

public class EHDemo {
	
	public static void calculation(){
		System.out.println("Inside Calculation");
		try
		{
			int a = 10/0;
			String str=null;
			System.out.println(str.equals("Hi"));
			System.out.println("End");
		}
		catch(Exception e) // for general exception !!!
		{
			System.out.println(e);
		}
		// the below blocks of catch are unreachable due to general exception code.
		// therefore if below two catch blocks also written with 
		// general exception, it will give error!
		
		/*catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		catch (NullPointerException e)
		{
			System.out.println(e);
		}*/
	
	}
	
	public static void calculation1(){
		System.out.println("Inside calculation1");
		int a = 10/0;
	}
	
	public static void main(String [] args)
	{
			System.out.println("Started");
			calculation();
			System.out.println("Calculation 0 ends here");
			//calculation1();
			try 
			{
				calculation1();
			}
			catch(ArithmeticException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				System.out.println("Finally block");
			}
			System.out.println("Program ends here :)");
	}
}
