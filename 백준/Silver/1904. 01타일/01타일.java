
import java.util.Scanner;

public class Main {
	static int dp[] = new int[1000001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= num; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 15746;
		}
		
		System.out.println(dp[num]);
	}
}
