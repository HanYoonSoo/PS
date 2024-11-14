import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 10; t++){
        	int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int sum = 0;
            
            for(int i = 2; i < N - 2; i++){
            	if(arr[i - 1] < arr[i] && arr[i - 2] < arr[i] && arr[i] > arr[i + 1] && arr[i] > arr[i + 2]){
                	int leftMax = Math.max(arr[i - 1], arr[i - 2]);
                    int rightMax = Math.max(arr[i + 1], arr[i + 2]);
                    
                    sum += arr[i] - Math.max(leftMax, rightMax);
                }
            }
            
            sb.append("#").append(t + " ").append(sum + "\n");
        }
        
        System.out.println(sb);
	}
}