class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        for(int i = n - 1; i >= 0; ){
            if(deliveries[i] == 0 && pickups[i] == 0){
                i--;
                continue;
            }
            
            compute(deliveries, cap, i);
            compute(pickups, cap, i);
            
            answer += (i + 1) * 2;
        }
        
        return answer;
    }
    
    public void compute(int[] arr, int cap, int idx){
        for(int i = idx; i >= 0; i--){
            if(cap >= arr[i]){
                cap -= arr[i];
                arr[i] = 0;
            } else{
                arr[i] -= cap;
                cap = 0;
                break;
            }
        }
    }

}