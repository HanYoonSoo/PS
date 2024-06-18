import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 2;

        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        int left = a[0];
        int right = a[a.length - 1];

        leftMin[0] = left;
        rightMin[a.length - 1] = right;

        for(int i = 1; i < a.length; i++){
            if(left > a[i])
                left = a[i];
            leftMin[i] = left;
        }

        for(int i = a.length - 2; i >= 0; i--){
            if(right > a[i])
                right = a[i];
            rightMin[i] = right;
        }

        for(int i = 1; i < a.length - 1; i++){
            if(a[i] > leftMin[i] && a[i] > rightMin[i])
                continue;
            answer++;
        }

        return answer;
    }
}