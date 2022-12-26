
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int num = scan.nextInt();
		
		long result = 0;
		for(int i = 0; i < num; i++) {
			pq.add(scan.nextLong());
		}
		
		while(pq.size() > 1) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			
			result += num1 + num2;
			
			pq.add(num1 + num2);
		}
		
		System.out.println(result);
	}
}

