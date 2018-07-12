package validationfunctions;

import java.util.Random;

public class Student {
	
	int stdid;
	String name;
	
	public Student()
	{
		Random rand = new Random();
		stdid = rand.nextInt(500);
		name = "A";
	}

}
