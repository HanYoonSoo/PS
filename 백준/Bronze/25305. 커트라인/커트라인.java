
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] arr = scan.nextLine().split(" ");
		
		int[] arr1 = new int[Integer.parseInt(arr[0])];
		for(int i = 0; i < Integer.parseInt(arr[0]); i++) {
			arr1[i] = scan.nextInt();
		}
		
		Arrays.sort(arr1);
		
		System.out.println(arr1[arr1.length-Integer.parseInt(arr[1])]);
	}
}
