package validationfunctions;

class MyGen<T>{  
public T obj;  
void add(T obj){this.obj=obj;}  
T get(){return obj;}  
}  

public class DataTypeValidation {
	
	/*static boolean data_type_validation(int input,String S)
	{
		if(S.matches("int") || S.matches("Numeric"))
		{
			return true;
		}
		return false;
	}
	
	
	static boolean data_type_validation(double input,String S)
	{
		if(S.matches("double"))
		{
			return true;
		}
		return false;
	}
	
	static boolean data_type_validation(String input,String S)
	{
		if(S.matches("String"))
		{
			return true;
		}
		return false;
	}
	
	static boolean data_type_validation(float input,String S)
	{
		if(S.matches("float"))
		{
			return true;
		}
		return false;
	}
	
	static boolean data_type_validation(Integer input,String S)
	{
		if(S.matches("Integer"))
		{
			return true;
		}
		return false;
	}
	*/
	static <E> boolean data_type_validation( E input,String S)
	{
		//System.out.println(input.getClass().getSimpleName());
		if(input.getClass().getSimpleName().matches(S))
		{
			return true;
		}
		return false;
	}
	
	public static void main(String [] args)
	{
		Student Std1 = new Student();
		int num = 100;
		String check = "Nucleus @ Noida";
		System.out.println(data_type_validation(num,"Integer"));
		System.out.println(data_type_validation(Std1,"Student"));
		System.out.println(data_type_validation(check,"String"));
		System.out.println(data_type_validation(Std1,"String"));
	}
}
