
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		long[][] arr = new long[num1+1][num2+1];
		for(int i = 0; i <= num1; i++) {
			for(int j = 0; j <= Math.min(i, num2); j++) {
				if(j == 0 || j == i)
					arr[i][j] = 1;
				else
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % 10007;
			}
		}
		
		System.out.println(arr[num1][num2]);
	}
}
