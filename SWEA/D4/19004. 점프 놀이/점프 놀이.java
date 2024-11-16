
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

/**

2
5 3
1 1 1 1 1
1 2 2 2 1
1 2 3 2 1
1 2 2 2 1
1 1 1 1 1
2 3
1 3
3 1
**/

class Solution
{
    static class Point{
    	int y;
        int x;
        int minDist;
        
        public Point(int y, int x, int minDist){
        	this.y = y;
            this.x = x;
            this.minDist = minDist;
        }
    }
	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T;
		T = Integer.parseInt(br.readLine());
        
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            StringTokenizer st = new StringTokenizer(br.readLine());
            
			int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
			
            List<Point>[] grid = new ArrayList[K];
            
            for(int i = 0; i < K; i++){
            	grid[i] = new ArrayList<>();
            }
           
            for(int i = 0; i < N; i++){
            	st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                	int num = Integer.parseInt(st.nextToken());
                    
                    if(num == 1){
                    	grid[0].add(new Point(i, j, 0));
                    } else{
                    	grid[num - 1].add(new Point(i, j, 250000));
                    }
                }
            }
            
           boolean compare = true;
           for(int i = 0; i < K; i++){
               if(grid[i].isEmpty()){
                   System.out.println("#" + test_case + " -1");
                   compare = false;
                   break;
               }
           }
            
            if(!compare)
                continue;
            
            for(int i = 0; i < K - 1; i++){
            	List<Point> currK = grid[i];
                List<Point> nextK = grid[i + 1];
                
                for(Point curr : currK){
                	for(Point next: nextK){
                    	int dist = curr.minDist;
                        int compute = Math.abs(curr.y - next.y) + Math.abs(curr.x - next.x);
                        
                        if(next.minDist > compute + dist){
                        	next.minDist = compute + dist;
                        }
                    }
                }
            }
            
            int result = Integer.MAX_VALUE;
            
            for(Point lastK : grid[K - 1]){
            	result = Math.min(lastK.minDist, result);
            }
            
            System.out.println("#" + test_case + " " + result);

		}
	}
}