import java.util.Scanner;


public class main 
{

	public static void main(String[] args) 
	{
		int MAXNUMBERS = 2;
		int[] numbers = new int[MAXNUMBERS];
		int value = 0;
		
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < MAXNUMBERS; i++)
		{
			System.out.println("Enter Number : ");
			numbers[i] = input.nextInt();
		}
		
		input.close();
		
		for(int i = 0; i < MAXNUMBERS; i++)
		{
			if(numbers[i] <= 21 && value < numbers[i])
			{
				value = numbers[i];
			}
		}
		
		System.out.println(value);

	}

}
