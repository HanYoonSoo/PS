
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(scan.nextLine());
		
		String[] arr = new String[num];
		
		for(int i = 0; i < num; i++) {
			arr[i] = scan.nextLine();
		}
		
		String str = "lol";
		int count;
		for(int i = 0; i < arr.length; i++) {
			count = 0;
			
			for(int j = 0; j < arr[i].length(); j++) {
				if(arr[i].contains(str)) {
					count = 3;
					break;
				}
				if(str.contains(String.valueOf(arr[i].charAt(j)))) {
					if(j + 2 < arr[i].length() && arr[i].charAt(j+2) == 'l' && arr[i].charAt(j) == 'l') {
						count = 2;
						break;
					}
					if(j+1 < arr[i].length() && str.contains(String.valueOf(arr[i].charAt(j+1)))) {
						if(arr[i].charAt(j) == 'o' && arr[i].charAt(j+1) == 'o') {
							count = 1;
						}
						else {
							count = 2;
							break;
						}
					}
					count = 1;
				}
				
			}
			sb.append(3-count+"\n");
		}
		
		
		System.out.println(sb.toString());
	}

}
