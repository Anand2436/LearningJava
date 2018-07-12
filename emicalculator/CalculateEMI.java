package emicalculator;
import java.text.DecimalFormat;
import java.util.*;

class NegZeroValueException extends Exception{
	public void errorMsg()
	{
		System.out.println(" cant have zero/negative values");
	}
}

class InvalidInstallmentException extends Exception{
	public void errorMsg()
	{
		System.out.println("Invalid Installment number provided. Please try again!");
	}
}

public class CalculateEMI {
	
	static boolean check_neg_value(double p_amt,double tenure,double ins)
	{
		if(tenure>=0 && ins>=0 && p_amt>=0)
			return true;
		
		if(p_amt <= 0)
		{
			System.out.print("Loan Amount");
			try 
			{
				throw new NegZeroValueException();
			}
			catch(NegZeroValueException e)
			{
				e.errorMsg();
			}
		}
		
		if(tenure <= 0)
		{
			System.out.print("Tenure");
			try 
			{
				throw new NegZeroValueException();
			}
			catch(NegZeroValueException e)
			{
				e.errorMsg();
			}
		}
		
		if(ins <= 0)
		{
			System.out.print("Number of installments in a year");
			try 
			{
				throw new NegZeroValueException();
			}
			catch(NegZeroValueException e)
			{
				e.errorMsg();
			}
		}
		
		return false;
	}
	
	static double calculate_installment(double p_amt,double rate,double tenure,double ins)
	{
		// tenure can't be zero ==> i/t will lead to arithmeticException
		// (1+(i/t)) cant be zero
		// (1-(1+(i/t))) cant be zero for the same reasons
		
		// checking Neg value exceptions for amount, tenure, installments
		
		// calculating numerator term
		double num = (p_amt * rate);
		try
		{
			num = num/ins;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// calculating denominator
		double denom = 1;
		try
		{
			denom= 1 + (rate/ins);
			denom = Math.pow(denom,tenure);
			denom = 1/denom;
			denom = 1 - denom;
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}
		
		// calculating ans
		double inst_amount = num/denom;
		return inst_amount;
	}
	
	static double repayment_schedule(double tenure,double ins,double loan_amt,double interest_rate,double arr_pc[],double arr_ic[],double arr_out[])
	{
		int count = 0;
		interest_rate = interest_rate/100; // % conversion
		double interest_comp = loan_amt * interest_rate/ins ;
		double installment_amount = calculate_installment(loan_amt,interest_rate,tenure,ins);
		double p_amt = installment_amount - interest_comp;
		
		while(count<tenure)
		{
			arr_out[count] = loan_amt;
			arr_pc[count] = p_amt;
			arr_ic[count] = interest_comp;
			
			loan_amt = loan_amt - p_amt;
			interest_comp = loan_amt * interest_rate/ins;
			p_amt = installment_amount - interest_comp;
			
			count++;
		}
		
		return installment_amount;
	}
	
	static void print_schedule(int len,double arr_pc[],double arr_ic[],double arr_out[],double install)
	{
		DecimalFormat formatter = new DecimalFormat("#0.00"); 
		System.out.print("Ins No \t O/s value \t Interest \t principal \t EMI\n");
		
		for(int i=0;i<len;i++)
		{
			
			System.out.print((i+1) + "\t");
			System.out.print(formatter.format(arr_out[i]) + "\t");
			System.out.print(formatter.format(arr_ic[i]) + "\t");
			System.out.print(formatter.format(arr_pc[i]) + "\t");
			System.out.println(formatter.format(install));
		}
	}
	
	public static void main(String [] args)
	{
		final Scanner input = new Scanner(System.in);
		// for simplicity all inputs have been taken as double
		int val = 0;
		// A switch is used for calling different functions for a given input
		System.out.println("Enter integer values : ");
		System.out.println("1 for calculating emi installment");
		System.out.println("2 for repayment schedule printing");
		System.out.println("3 for seeing particular record");
		System.out.println("4 to exit");
		val = input.nextInt();
		
		while(val!=4)
		{
			
			System.out.println("Enter Loan amount");
			double loan_amt = input.nextDouble();
			
			System.out.println("Enter Interest rate (%) pa");
			double interest_rate = input.nextDouble();
			
			System.out.println("Enter Tenure period in months");
			double tenure = input.nextDouble();
			
			int installments_per_year_given;
			System.out.println("No. of installments given or not? answer with '1' for yes and '2' for no.");
			installments_per_year_given = input.nextInt();
			
			double num_of_installments = 12; //default value
			
			if(installments_per_year_given == 1)
			{
				num_of_installments = input.nextDouble();
			}
			
			boolean valid = check_neg_value(loan_amt,tenure,num_of_installments);
			
			if(valid)
				{
					double [] arr_pc = new double[(int)tenure]; // principal component
					double [] arr_ic = new double[(int)tenure]; // interest component
					double [] arr_out = new double[(int)tenure]; // outstanding amount 
			
					switch(val)
					{
					case(1):
						interest_rate = interest_rate/100; // % conversion
						double interest_comp = loan_amt * interest_rate/num_of_installments ;
						double installment_amount = calculate_installment(loan_amt,interest_rate,tenure,num_of_installments);
						System.out.println(installment_amount);
						break;
						
					case(2):
						double installment= repayment_schedule(tenure,num_of_installments,loan_amt,interest_rate,arr_pc,arr_ic,arr_out);
						print_schedule((int)tenure,arr_pc,arr_ic,arr_out,installment);
						break;
						
					case (3):
						System.out.println("Enter the installment number you want to enquire about:");
					    int ins_num = input.nextInt();
					    
					    if(ins_num <=0 || ins_num>=(int)tenure)
					    {
					    	try
					    	{
					    		throw new InvalidInstallmentException();
					    	}
					    	catch(InvalidInstallmentException e)
					    	{
					    		e.errorMsg();
					    	}
					    }
					    else
					    {
					    	double install= repayment_schedule(tenure,num_of_installments,loan_amt,interest_rate,arr_pc,arr_ic,arr_out);
					    	DecimalFormat formatter = new DecimalFormat("#0.00"); 
					    	System.out.print("Ins No \t O/s value \t Interest \t principal \t EMI\n");
					    	System.out.print((ins_num) + "\t");
							System.out.print(formatter.format(arr_out[ins_num-1]) + "\t");
							System.out.print(formatter.format(arr_ic[ins_num-1]) + "\t");
							System.out.print(formatter.format(arr_pc[ins_num-1]) + "\t");
							System.out.println(formatter.format(install));
					    }
					    break;
					    
						
					default:
						break;
					}
				}
				System.out.println("Enter the integer again out of options 1(funct1) ,2(funct2),3 (funct3),4(exit) :");
				val = input.nextInt();
		}
		
		System.out.println("End of Program :)");
		//System.out.println(installment_amount);
	}

}
