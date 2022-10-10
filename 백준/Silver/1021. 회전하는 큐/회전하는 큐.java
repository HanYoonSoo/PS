

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		String[] arr = scan.nextLine().split(" ");
		
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		
		arr = scan.nextLine().split(" ");
		
		
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int index = 0;
		int count = 0;
		while(M > 0) {
			if(Integer.parseInt(arr[index]) == deque.peekFirst()) {
				deque.removeFirst();
				M--;
				index++;
			}
			else {
				int front = 0;
				int back = 0;
				ArrayDeque<Integer> firsttemp = deque.clone();
				ArrayDeque<Integer> lasttemp = deque.clone();
				while(Integer.parseInt(arr[index]) != firsttemp.peekFirst()) {
					firsttemp.offerLast(firsttemp.removeFirst());
					front++;
				}
				
				while(Integer.parseInt(arr[index]) != lasttemp.peekFirst()) {
					lasttemp.offerFirst(lasttemp.removeLast());
					back++;
				}
				
				if(front > back) {
					deque = firsttemp.clone();
					count += back;
				}
				else {
					deque = lasttemp.clone();
					count += front;
				}
			}
		}
		System.out.println(count);
	}
}
