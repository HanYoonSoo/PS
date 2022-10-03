
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = Integer.parseInt(scan.nextLine());
		
		Node root = new Node();
		
		for(int i = 0; i < num; i++) {
			String[] arr = scan.nextLine().split(" ");
			Node cur = root;
			
			for(int j = 1; j <= Integer.parseInt(arr[0]); j++) {
				String s = arr[j];
				
				if(!cur.childs.containsKey(s)) {
					cur.childs.put(s, new Node());
				}
				cur = cur.childs.get(s);
			}
		}
		
		print(root, "");
	}
	
	static void print(Node root, String bar) {
		Object[] arr = root.childs.keySet().toArray();
		Arrays.sort(arr);
		
		for(Object o : arr) {
			System.out.println(bar + o);
			print(root.childs.get(o), bar + "--");
		}
	}
}

class Node{
	HashMap<String, Node> childs = new HashMap<>();
}