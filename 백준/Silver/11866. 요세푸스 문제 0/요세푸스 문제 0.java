

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		
		sb.append("<");
		List<Integer> josepus = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			josepus.add(i);
		}
		
		int index = k-1;
		while(josepus.size() != 0) {
			if(josepus.size() == 1) {
				sb.append(josepus.get(index));
				josepus.remove(index);
				break;
			}
			sb.append(josepus.get(index)+", ");
			josepus.remove(index);
			index = (index + (k-1)) % josepus.size();
			
		}
		
		sb.append(">");
		
		System.out.println(sb.toString());
		
	}

}
