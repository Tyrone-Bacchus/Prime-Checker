/*By: Tyrone Bacchus
 *Course: ICS 4U1
 *Teacher: Mr. Ryan
 *Due: Tuesday, December 6, 2011*/

 import java.util.*;

public class PrimeCheckerIO
{
	public static void main (String[] Tyrone)
	{
		System.out.println("Project: Prime Checker\n" + "By: Tyrone Bacchus\n" + "Teacher: Mr. Ryan\n"
							+ "Course: ICS 4U1\n" + "Due: Tuesday, December 6, 2011\n"
								+ "This program prints the prime numbers from 1 to the input.\n");

		int numberOfPrimes = 0;
		int upperLimit;

		boolean prime = true;

		Scanner reader = new Scanner(System.in);

		System.out.print("Enter a postive integer: ");
		upperLimit = reader.nextInt();
		reader.nextLine();

		for(int out = 2; out <= upperLimit; out++)
		{
			prime = true;

			for(int in = 2; in <= (int)(Math.sqrt(out)); in++)
			{
				if(out % in == 0)
				{
					prime = false;
					break;
				}
			}

			if(prime)
			{
				System.out.print(out + "\t");
				numberOfPrimes++;
			}
		}

		System.out.print("\n\nThere are " + numberOfPrimes + " prime numbers between 1 and "
			+ upperLimit + ", inclusive.");
	}
}