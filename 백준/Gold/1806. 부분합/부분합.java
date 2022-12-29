
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int S = scan.nextInt();
		
		int[] arr = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
		int total = 0;
		int end = 0;
		int start = 0;
		int min = Integer.MAX_VALUE;
		
		while(end <= N && start <= N) {
			if(total >= S && min > end- start)
				min = end - start;
			else if(total < S) {
				total += arr[end++];
			}
			else {
				total -= arr[start++];
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else {
			System.out.println(min);
		}
	}
}
