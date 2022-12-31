
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		int W[] = new int[N+1];
		int V[] = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			W[i] = scan.nextInt();
			V[i] = scan.nextInt();
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(W[i] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
