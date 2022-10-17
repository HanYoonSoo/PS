
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int n = scan.nextInt();
		for(int i = 0; i < n; i++) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			long[][] arr = new long[num2+1][num1+1];
			
			long result = nck(arr, num2, num1);
			
			System.out.println(result);
		}
	}
	
	public static long nck(long[][] arr, int num2, int num1) {
		for(int i = 0; i <= num2; i++) {
			for(int j = 0; j <= Math.min(i, num1); j++) {
				if(j == 0 || j == i)
					arr[i][j] = 1L;
				else
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]);
			}
		}
		
		return arr[num2][num1];
	}

}
