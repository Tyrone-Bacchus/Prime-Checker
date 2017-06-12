/*By: Tyrone Bacchus
 *Course: ICS 4U1
 *Teacher: Mr. Ryan
 *Due: Thursday, December 8, 2011*/

 import java.util.*;

public class PrimeCheckerIOStringSkip
{
	public static void main (String[] Tyrone)
	{
		System.out.println("Project: Prime Checker\n" + "By: Tyrone Bacchus\n" + "Teacher: Mr. Ryan\n"
							+ "Course: ICS 4U1\n" + "Due: Thursday, December 8, 2011\n"
								+ "This program prints the prime numbers from 1 to the input.\n");

		int numberOfPrimes = 0;
		int upperLimit;

		String primeString = new String("");

		boolean prime = true;
		boolean allNumbers[];

		Scanner reader = new Scanner(System.in);

		System.out.print("Enter a positive integer: ");
		upperLimit = reader.nextInt();
		allNumbers = new boolean[upperLimit];
		reader.nextLine();

		for(int out = 2; out <= upperLimit; out++)
		{
			if(allNumbers[out - 1] == false)
			{
				primeString += out + "\t";
				numberOfPrimes++;

				for(int in = out; in <= (int)(upperLimit / out); in++)
				{
					allNumbers[out * in - 1] = true;
				}
			}
		}

		System.out.println(primeString);
		System.out.print("\nThere are " + numberOfPrimes + " prime numbers between 1 and "
			+ upperLimit + ", inclusive.");
	}
}