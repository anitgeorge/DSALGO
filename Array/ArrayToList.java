import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

/* Name of the class has to be "Main" only if the class is public. */
class ArrayToList
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = new int[]{1,2,3,4};
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		System.out.println(list.toString());
	}
}
