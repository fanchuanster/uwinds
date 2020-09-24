package analysis;

import java.util.Arrays;
import java.util.Random;

public final class McssTest 
{
	private static int start = 0;
	private static int end = 0;
	
	private static int msccCubic(int[] a)
	{
		int maxSum = 0;
		for (int i=0; i<a.length; i++)
		{
			for (int j=i; j<a.length; j++)
			{
				int thisSum = 0;
				for (int k=i; k<=j; k++)
				{
					thisSum += a[k];
				}
				
				if (thisSum > maxSum)
				{
					maxSum = thisSum;
					start = i;
					end = j;
				}
			}
		}
		return maxSum;
	}
	
	private static int msccQuadratic(int[] a)
	{
		return 0;
	}
	
	private static int msccDivideConquer(int[] a)
	{
		return 0;
	}
	
	private static int msccLinear(int[] a)
	{
		return 0;
	}
	
	public static void main(String args[])
	{
		System.out.println("main start " + 0);
		
		Random aR = new Random();
		int[] a = aR.ints(10, -100, 100).toArray();
		System.out.println(Arrays.toString(a));
		
		int max = msccCubic(a);
		System.out.println("maxSum " + max + " from " + start + " to " + end);
	}

}
