import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // queue1 = new int[]{10, 5, 1};
        // queue2 = new int[]{2, 2, 2};
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        int len = queue1.length;
        
        long q1Sum = 0;
        long q2Sum = 0;
        long org1Sum = 0;
        long org2Sum = 0;
        
        for(int i = 0; i < len; i++){
            q1.add(queue1[i]);
            q1Sum += queue1[i];
            
            q2.add(queue2[i]);
            q2Sum += queue2[i];
        }
        
        org1Sum = q1Sum;
        org2Sum = q2Sum;
        
        if((q1Sum + q2Sum) % 2 == 1)
            return -1;
        
        long mid = (q1Sum + q2Sum) / 2;
        
        int move = 0;
        
        while(move <= len * 2 + 2){
            if(q1Sum > q2Sum){
                int num = q1.poll();
                if(mid < num){
                    return -1;
                }
                q1Sum -= num;
                q2.add(num);
                q2Sum += num;
                move++;
            } else if(q1Sum < q2Sum){
                int num = q2.poll();
                if(mid < num){
                    return -1;
                }
                q2Sum -= num;
                
                q1.add(num);
                q1Sum += num;
                move++;
            } else{
                return move;
            }
        }
        
        return -1;
    }
}

// import java.util.LinkedList;
// import java.util.List;

// public class Solution {

//     static long sum1;
//     static long sum2;
//     static List<Integer> q1 = new LinkedList<>();
//     static List<Integer> q2 = new LinkedList<>();

//     public long solution(int[] queue1, int[] queue2) {
//             setUp(queue1, queue2);
//             int qSize = q1.size() + q2.size();
//             long sum = sum1 + sum2;

//             // 총합이 홀수면 -1 반환
//             if (sum % 2 != 0) {
//                 return -1;
//             }

//             long moveCount = 0;
//             long answer = -1;

//             while (moveCount <= qSize + 2) {
//                 if (sum1 > sum2) {
//                     int moveNum = q1.remove(0);
//                     sum1 -= moveNum;
//                     sum2 += moveNum;
//                     moveCount++;
//                     q2.add(moveNum);
//                 } else if (sum1 == sum2) {
//                     answer = moveCount;
//                     break;
//                 } else if (sum1 < sum2) {
//                     int moveNum = q2.remove(0);
//                     sum1 += moveNum;
//                     sum2 -= moveNum;
//                     moveCount++;
//                     q1.add(moveNum);
//                 }

//             }
//             return answer;

//         }

//         void setUp(int[] queue1, int[] queue2) {

//             for (int a : queue1) {
//                 q1.add(a);
//                 sum1 += a;
//             }

//             for (int b : queue2) {
//                 q2.add(b);
//                 sum2 += b;
//             }

//         }

// }