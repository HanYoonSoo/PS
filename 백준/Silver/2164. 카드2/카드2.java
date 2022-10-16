
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= num; i++) {
			queue.offer(i);
		}
		
		while(queue.size() != 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		sb.append(queue.poll());
		
		System.out.println(sb.toString());
	}
}
