import java.util.Scanner;


public class main 
{

	public static void main(String[] args) 
	{
		int temp;
		boolean isSummer = false;
		String boolcheck = "n";
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Is it summer, enter y or n :");
		boolcheck = input.nextLine();
		
		System.out.println("Enter temperature :");
		temp = input.nextInt();
		
		if(boolcheck.equals("y"))
			isSummer = true;
		
		if(temp > 60 && temp < 90 && !isSummer)
		{
			System.out.println("True");
		}
		else if(temp > 60 && temp < 100 && isSummer)
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}

		
		input.close();
	}

}
