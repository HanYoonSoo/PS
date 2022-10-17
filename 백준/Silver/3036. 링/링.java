
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i = 1; i < n; i++) {
			int result = gcd(arr[0], arr[i]);
			System.out.println(arr[0]/result + "/" + arr[i]/result);
		}
		
	}
	
	public static int gcd(int p, int q) {
		if(q == 0)
			return p;
		else
			return gcd(q, p % q);
	}
}
