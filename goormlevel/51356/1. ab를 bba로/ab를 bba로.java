import java.io.*;
class Main {
	
	final static int value = 1000000007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int[] dp = new int[1000001];
		
		for (int i = 1; i < dp.length; i++) {
			dp[i] = (dp[i - 1] * 2 + 1) % value;
		}

		String input = br.readLine();
		
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == 'a') {
				count++;
			} else {
				answer = (answer + dp[count]) % value;
			}
		}
		
		System.out.println(answer);
	}
}