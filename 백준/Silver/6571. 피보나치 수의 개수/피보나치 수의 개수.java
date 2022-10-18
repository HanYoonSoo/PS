import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			BigInteger dp1 = new BigInteger("0");
			BigInteger dp2 = new BigInteger("1");
			BigInteger dp3;
			BigInteger tmp;
			

			String a = scan.next();
			String b = scan.next();
			if(a.equals("0") && b.equals("0")) {
				return;
			}
			BigInteger big_a = new BigInteger(a);
			BigInteger big_b = new BigInteger(b);
			int count = 0;
			for(int i = 0 ; i < 10000 ; i++) {
				dp3 = dp1.add(dp2);
				if((dp3.compareTo(big_a) == 1||dp3.compareTo(big_a) == 0) && (dp3.compareTo(big_b) == -1 ||dp3.compareTo(big_b) == 0)) {
					count++;
				}
				if(dp3.compareTo(big_b) == 1) {
					break;
				}
				dp1 = dp2;
				dp2 = dp3;
			}

			
			System.out.println(count);
		}
	}
}
