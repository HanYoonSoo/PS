import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();
		int count = 0;

		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		System.out.println(count);
	}

}