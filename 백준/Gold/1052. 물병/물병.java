import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0, index = -1;
        String bitN = Integer.toBinaryString(N);	
        int ones = Integer.bitCount(N);
        
        if(ones > K){	
            for (int i = 0; i < bitN.length(); i++) {
                if (K == 0) {
                    index = i;
                    break;
                }
                if (bitN.charAt(i) == '1')
                    K--;
            }
            String temp = bitN.substring(index);	//바꿔야 하는 값
            int t = Integer.parseInt(temp, 2);	//바꿔야 하는 값의 10진수 값

            if (t != 0)
                answer = (int) (Math.pow(2, bitN.length() - index) - t);
        }
        bw.write(answer + "");		//물병 구매 개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}