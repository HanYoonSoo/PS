
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		int result1 = gcd(num1, num2);
		System.out.println(result1);
		System.out.println(num1 * num2 / result1);
	}
	
	public static int gcd(int p, int q) {
		if(q == 0)
			return p;
		else
			return gcd(q, p % q);
	}

}
