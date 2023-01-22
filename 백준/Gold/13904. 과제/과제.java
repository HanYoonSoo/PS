
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<SNode> subject;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		subject = new ArrayList<>();
		
		String[] temp;
		int maxDay = 0;
		for(int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			subject.add(new SNode(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
			
			maxDay = Math.max(maxDay, Integer.parseInt(temp[0]));
		}
		
		int result = 0;
		
		for(int i = maxDay; i > 0; i--) {
			result += searchMaxValue(i);
		}
		
		System.out.println(result);
	}
	
	public static int searchMaxValue(int now) {
		int index = -1;
		int result = 0;
		
		for(int i = 0; i < subject.size(); i++) {
			if(subject.get(i).day >= now && result < subject.get(i).value) {
				index = i;
				result = subject.get(i).value;
			}
		}
		
		if(result == 0) {
			return 0;
		}
		
		subject.remove(index);
		return result;
	}
}

class SNode{
	int day;
	int value;
	
	public SNode(int day, int value) {
		this.day = day;
		this.value = value;
	}
	
}
