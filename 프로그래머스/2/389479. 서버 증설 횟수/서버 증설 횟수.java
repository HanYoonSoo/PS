class Solution {
    public int solution(int[] players, int m, int k) {
        int[] addServer = new int[24];
    
        int curr = m;
        int answer = 0;
        
        for(int i = 0; i < 24; i++){
            if(addServer[i] != 0){
                curr -= addServer[i];
            }
            
            int uses = 0;
            uses = players[i];
            
            if(uses >= curr){
                int compute = (uses - curr) / m + 1;
                answer += compute;
                
                if(i + k < 24){
                    addServer[i + k] += compute * m;
                }
                
                curr += compute * m;
                // System.out.println(i + " " + compute);
            }
        }
        
        return answer;
    }
}