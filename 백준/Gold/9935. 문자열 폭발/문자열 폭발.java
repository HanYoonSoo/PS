import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String boom = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			sb.append(c);
			
			if(sb.length() >= boom.length()) {
				boolean isSame = true;
				for(int j = 0; j < boom.length(); j++) {
					char c1 = sb.charAt(sb.length() - boom.length() + j);
					char c2 = boom.charAt(j);
					
					if(c1 != c2) {
						isSame = false;
						break;
					}
				}
				
				if(isSame) {
					sb.delete(sb.length() - boom.length(), sb.length());
				}
			}
		}
		
		if(sb.length() == 0) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(sb.toString());
		}
	}
}
