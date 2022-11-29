
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int[] arr = new int[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = scan.nextInt();
		}
		
		int[] dp = new int[num];
		
		dp[0] = arr[0];
		int max = arr[0];
		
		for(int i = 1; i < num; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
