

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);



	
	

			int n = scan.nextInt();
			int[] w = new int[n+1];
			int sum = 0;

			for(int i = 1; i <= n; i++) {
				w[i] = scan.nextInt();
				sum += w[i];
			}

			int[][] dp = new int[n+1][sum+1];

			for(int i = 1; i <= n; i++) {
				dp[i][w[i]] = 1;
				for(int j = 1; j <= sum; j++) {
					if(j > w[i]) {
						for(int index=1;index<i;index++)
			                   if(dp[index][j-w[i]]>0)
			                   {
			                      dp[i][j] = dp[index][j-w[i]]+1;
			                   }
					}
				}
			}

			int min = sum;
			int ans = sum;
			for(int i=1;i<=n;i++)
			{
				for(int j = 1; j <= sum; j++) 
				{
					if(dp[i][j]==n/2) 
					{
						if( Math.abs(2*j - sum) < min)
						{
							min = Math.abs(sum-2*j);
							ans = j;
						}
					}
					else if(n%2==1 && (dp[i][j]==n/2||dp[i][j]==n/2+1)) 
					{
						if( Math.abs(sum-2*j) < min)
						{
							min = Math.abs(sum-2*j);
							ans = j;
						}
					}
				}
			}
			System.out.println(Math.min(ans,sum-ans)+" "+Math.max(ans, sum-ans));



	}
}
