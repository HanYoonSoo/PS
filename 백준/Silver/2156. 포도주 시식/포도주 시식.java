import java.util.Scanner;

public class Main {
	static int[] dp = new int[10002];
	static int[] compare = new int[10002];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();

		
		for(int i = 1; i <= n; i++) {
			dp[i] = scan.nextInt();
		}
		
		compare[1] = dp[1];
		compare[2] = dp[1] + dp[2];
		
		for(int i = 3; i <= n; i++) {
			int max = Math.max(compare[i-1], compare[i-2] + dp[i]);
			max = Math.max(max, dp[i-1] + dp[i] + compare[i-3]);
			compare[i] = max;
		}
		
		int max = 0;
		
		for(int i = 1; i <= n; i++) {
			if(compare[i] > max)
				max = compare[i];
		}
		
		System.out.println(max);
	}
}
