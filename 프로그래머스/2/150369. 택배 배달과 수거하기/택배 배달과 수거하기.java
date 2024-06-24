class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        for(int i = n - 1; i >= 0;){
            if(deliveries[i] == 0 && pickups[i] == 0){
                i--;
                continue;
            }
            
            compute(cap, i, deliveries);
            compute(cap, i, pickups);
            
            answer += (i + 1) * 2;
        }
        return answer;
    }
    
    public void compute(int cap, int idx, int[] arr){
        while(idx >= 0){
            if(cap >= arr[idx]){
                cap -= arr[idx];
                arr[idx--] = 0;
            } else{
                arr[idx] -= cap;
                break;
            }
        }
    }
}