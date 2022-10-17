
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		if(n == 1) {
			System.out.println(arr[0] * arr[0]);
		}
		else {
			System.out.println(arr[0] * arr[n-1]);
		}
		
	}

}
