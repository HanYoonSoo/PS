
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		
		String[] s = new String[N];
		
		for(int i = 0; i < N; i++) {
			s[i] = br.readLine();
		}
		
		Arrays.sort(s);
		
		int count = 0;
		for(int i = 0; i < M; i++) {
			count += binarySearch(s, br.readLine());
		}
		
		System.out.println(count);
	}
	public static int binarySearch(String[] arr, String n)
	{
		int start = 0;
		int end = arr.length-1;
		int middle = 0;
		
		while(start <= end)
		{
			middle = (start + end)/2;
			if(arr[middle].equals(n))
			{
				return 1;
			}
			else
			{
				if(arr[middle].compareTo(n) > 0)
				{
					end = middle-1;
				}
				else
				{
					start = middle+1;
				}
			}
		}
		
		return 0;
	}


}
