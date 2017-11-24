import java.util.Scanner;

/* finding LCS
 * enter two strings
 * get the lengths of the two strings
 * loop through stringA comparing each element to each in stringB
 * storing any common elements
 * */
public class main 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String stringA, stringB;
		
		System.out.println("Finding the Lowest Common Sequence");
		System.out.println("Enter the first word : ");
		stringA = input.nextLine();
		
		System.out.println("Enter the second word : ");
		stringB = input.nextLine();

		System.out.println(lcsCheck(stringA, stringB));
		
		input.close();
				
	}
	
	// using recursion instead of a loop
	public static String lcsCheck(String a, String b)
	{
		String aa = a;
		String bb = b;
		
		// get the length of the words
	    int aLen = a.length();
	    int bLen = b.length();
	    
	    // check to make sure there is a word to check
	    if(aLen == 0 || bLen == 0)
	    {
	        return "";
	    }
	    else if(a.charAt(aLen-1) == b.charAt(bLen-1))
	    {
	        return lcsCheck(a.substring(0,aLen-1),b.substring(0,bLen-1))
	            + a.charAt(aLen-1);
	    }
	    else
	    {
	    	// using substring to search through comparing
	    	// to the other string
	        String x = lcsCheck(a, b.substring(0,bLen-1));
	        String y = lcsCheck(a.substring(0,aLen-1), b);
	        
	        return (x.length() > y.length()) ? x : y;
	    }
	}

}
