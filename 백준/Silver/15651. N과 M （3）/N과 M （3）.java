
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] list;
	static int[] result;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);

		list = new int[n];

		for(int i = 0; i < n; i++) {
			list[i] = i + 1;
		}

		visit = new boolean[list.length];

		result = new int[m];

		nm(n, m, 0);
		
		System.out.println(sb.toString());
	}

	public static void nm(int n, int m, int index) {
		if(index == result.length) {
			for(int i = 0; i < result.length; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0; i < list.length; i++) {
			result[index] = list[i];
			nm(n, m, index + 1);
		}
	}

}
