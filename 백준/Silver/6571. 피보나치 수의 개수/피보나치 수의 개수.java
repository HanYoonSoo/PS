
import java.util.Scanner;

public class Main {
	
	public static String[] a = new String[101];
	public static String[] b = new String[101];
	public static int lengtha, lengthb;
	public static int[] length = new int[3];
	static int result;
	public static Scanner scan = new Scanner(System.in);
	public static String[][] fib = new String[3][101];
	public static void main(String[] args) {
		int i;
		while(input()) {
			length[0] = length[1] = 1;
			fib[0][0] = fib[1][0] = "1";
			
			for(i = 1; compare(i%3, a, lengtha) < 0; i++)
				plus((i+1) % 3, i % 3, (i - 1)%3);
			
			result = i;
			for(; compare(i % 3, b, lengthb) <= 0; i++)
				plus((i+1)%3, i%3, (i-1)%3);
			
			result = i - result;
			System.out.println(result);
		}
		
	}
	
	public static boolean input() {
		
		String[] arr = scan.nextLine().split(" ");
		
		if(arr[0].equals("0") && arr[1].equals("0"))
			return false;
		lengtha = arr[0].length();
		lengthb = arr[1].length();
		
		for(int i = 0; i < lengtha; i++) {
			a[i] = String.valueOf(arr[0].charAt(lengtha - i - 1) - '0');
		}
		
		for(int i = 0; i < lengthb; i++) {
			b[i] = String.valueOf(arr[1].charAt(lengthb - i - 1) - '0');
		}
		return true;
	}
	
	public static int compare(int fi, String[] numb, int len) {
		int i;
		
		if(length[fi] < len) return -1;
		if(length[fi] > len) return 1;
		
		for(i = len - 1; i >= 0; i--) {
			if(fib[fi][i].compareTo(numb[i]) < 0) return -1;
			if(fib[fi][i].compareTo(numb[i]) > 0) return 1;
		}
		
		return 0;
	}
	
	public static void plus(int target, int a, int b) {
		int len = 0, carry = 0;
		
		for(; len < length[a] && len < length[b]; len++) {
			fib[target][len] = String.valueOf((Integer.parseInt(fib[a][len]) + Integer.parseInt(fib[b][len]) + carry));
			if(Integer.parseInt(fib[target][len]) >= 10)
				carry = 1;
			else
				carry = 0;
			fib[target][len] = String.valueOf(Integer.parseInt(fib[target][len]) % 10);
			
		}
		
		if(len < length[a]) {
			for(; len < length[a]; len++) {
				fib[target][len] = String.valueOf((Integer.parseInt(fib[a][len]) + carry));
				if(Integer.parseInt(fib[target][len]) >= 10)
					carry = 1;
				else
					carry = 0;
				fib[target][len] = String.valueOf(Integer.parseInt(fib[target][len]) % 10);
				
			}
		}
		else {
			for(; len < length[b]; len++) {
				fib[target][len] = String.valueOf((Integer.parseInt(fib[b][len]) + carry));
				if(Integer.parseInt(fib[target][len]) >= 10)
					carry = 1;
				else
					carry = 0;
				fib[target][len] = String.valueOf(Integer.parseInt(fib[target][len]) % 10);
				
			}
		}
		
		if(carry == 1)
			fib[target][len++] = String.valueOf(1);
		
		length[target] = len;
	}
}
