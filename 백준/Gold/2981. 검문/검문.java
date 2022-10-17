
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int[]arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int num=arr[1]-arr[0];
		
		for(int i=1;i<N;i++) {
			num=gcd(num, arr[i]-arr[i-1]);
		}
		
		for(int i=2;i<=num;i++) {
			if(num%i==0)
				System.out.print(i+" ");
		}
	}
	
	
	public static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}

}