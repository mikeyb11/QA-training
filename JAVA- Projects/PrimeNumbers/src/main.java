// http://compoasso.free.fr/primelistweb/page/prime/eratosthene_en.php

import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int i = 0, numberOfPrimes = 0;
		int num = 0;
		
		System.out.println("Enter the value of n:");
		int n = scanner.nextInt();
		
		scanner.close();
		
		long startTime = System.nanoTime();
		
		for (i = 1; i <= n; i++)  	   
		{ 		 		  
		  int counter=0; 		  
		  for(num = i; num >= 1; num--)
		  {
		   		if(i%num==0)
		   		{
		   			counter = counter + 1;
		   		}
		   	}
		   	if (counter == 2)
		   	{
		   		numberOfPrimes++;
		    }	
		  }	
		
		long endTime = System.nanoTime();
				
		long totalTime = (endTime - startTime);
		
		double seconds = (double)totalTime / 1000000000.0;
		
		System.out.println("Prime numbers from 1 to n are :");
		System.out.println(numberOfPrimes);
		
		System.out.println("Time it took(sec) :");
		System.out.println(seconds);
	}

}
