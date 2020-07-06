import java.util.*;
import java.lang.*;
import java.io.*;

class ListToArray
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i < 100; i++)
		   list.add(i);
		   
		int arr[] = list.stream().mapToInt(i -> i).toArray();
		
		System.out.println(arr[90]);
	}
}
