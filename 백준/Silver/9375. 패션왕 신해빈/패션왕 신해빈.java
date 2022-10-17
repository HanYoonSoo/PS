
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Map<String, Integer> map;
		
		int n = Integer.parseInt(scan.nextLine());
		
		for(int i = 0; i < n; i++) {
			map = new HashMap<String, Integer>();
			int num = Integer.parseInt(scan.nextLine());
			
			for(int j = 0; j < num; j++) {
				String[] arr = scan.nextLine().split(" ");
				
				if(!map.containsKey(arr[1])) {
					map.put(arr[1], 1);
				}
				else {
					map.put(arr[1], map.get(arr[1]) + 1);
				}
			}
			
			int result = 1;
			
			for(String key : map.keySet()) {
				result = result * (map.get(key) + 1);
			}
			
			System.out.println(result - 1);
		}
	}
}
