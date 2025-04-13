import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;

        int[][] node = new int[N][2];

        for(int i = 0; i < N; i++){
            node[i][0] = nums[i];
            node[i][1] = i;
        }

        Arrays.sort(node, (o1, o2) -> o1[0] - o2[0]);

        for(int i = 0; i < N; i++) {
            int compute = target - node[i][0];

            int left = i + 1;
            int right = N - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                // System.out.println(left + " " + nums[mid] + " " + right);

                if(node[mid][0] < compute) {
                    left = mid + 1;
                } else if(node[mid][0] == compute){
                    return new int[]{node[i][1], node[mid][1]};
                } else {
                    right = mid - 1;
                }
            }
        }

        return new int[]{-1};
    }
}
