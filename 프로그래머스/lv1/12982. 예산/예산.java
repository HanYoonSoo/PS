import java.util.Arrays;

class Solution {
    static public void main(String[] args) {
        System.out.println((solution(new int[]{1,3,2,5,4} , 9))==3);
        System.out.println((solution(new int[]{2,2,3,3} , 10))==4);
    }

    static public int solution(int[] d, int budgetLimit) {
        int answer = 0;
        int sumValue = 0;

        
        Arrays.sort(d);

    
        for (int wantBudget : d) {
           
            sumValue = sumValue + wantBudget;
       
            if (sumValue <= budgetLimit) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}