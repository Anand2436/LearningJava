package exception_handling;

public class Resources implements AutoCloseable{
	
	public Resources()
	{
		System.out.println("Resource1 Constructor");
	}
	
	public void doProcess()
	{
		//int b = 10/0;
		System.out.println("Process going on !!!");
	}
	
	public void close() throws Exception
	{
		//int a = 10/0;
		System.out.println("Closed the resource 1");
	}
}

class Execution{
	
	public static void main(String [] args)
	{
		// one way
		/*Resources r1 = new Resources();
		try
		{
		r1.doProcess();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				r1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}*/
		try(Resources r1 = new Resources();)
		{
		r1.doProcess();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
