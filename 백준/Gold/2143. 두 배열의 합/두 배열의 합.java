
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static List<Integer> listA;
	static List<Integer> listB;
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		int numA = Integer.parseInt(br.readLine());
		int[] A = new int[numA];
		String[] arrA = br.readLine().split(" ");
		for(int i = 0; i < numA; i++) {
			A[i] = Integer.parseInt(arrA[i]);
		}
		
		int numB = Integer.parseInt(br.readLine());
		int[] B = new int[numB];
		String[] arrB = br.readLine().split(" ");
		for(int i = 0; i < numB; i++) {
			B[i] = Integer.parseInt(arrB[i]);
		}
		
		listA = new ArrayList<>();
		listB = new ArrayList<>();
		
		for(int i = 0; i < numA; i++) {
			int sum = 0;
			for(int j = i; j < numA; j++) {
				sum += A[j];
				listA.add(sum);
			}
		}
		
		for(int i = 0; i < numB; i++) {
			int sum = 0;
			for(int j = i; j < numB; j++) {
				sum += B[j];
				listB.add(sum);
			}
		}
		
		Collections.sort(listA);
		Collections.sort(listB);
		
		System.out.println(compute());
	}
	
	public static long compute() {
		int pa = 0;
		int pb = listB.size() - 1;
		long count = 0;
		
		while(pa < listA.size() && pb >= 0) {
			long sum = listA.get(pa) + listB.get(pb);
			
			if(sum == T) {
				int a = listA.get(pa);
				int b = listB.get(pb);
				long countA = 0;
				long countB = 0;
				
				while (pa < listA.size() && listA.get(pa) == a) {
					countA++;
					pa++;
				}
				while (pb >= 0 && listB.get(pb) == b) {
					countB++;
					pb--;
				}
				
				count += countA * countB;
			}
			
			else if(sum < T) {
				pa++;
			}
			else if(sum > T){
				pb--;
			}
		}
		
		return count;
		
	}
}