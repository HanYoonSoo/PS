
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			
			if(num1 == 0 && num2 == 0) {
				break;
			}
			
			boolean compare;
			
			if(num1 < num2) {
				if(num2 % num1 == 0) {
					System.out.println("factor");
				}
				else {
					System.out.println("neither");
				}
			}
			else if(num1 >  num2) {
				if(num1 % num2 == 0) {
					System.out.println("multiple");
				}
				else {
					System.out.println("neither");
				}
			}
		}
	}
}
