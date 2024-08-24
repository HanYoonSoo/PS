class Solution {
    int N;
    int max;
    int[] arr;
    int[] answer = {-1};
    public int[] solution(int n, int[] info) {

        N = n;
        arr = new int[11];
        max = -1;
        
        dfs(info, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] apeach, int idx, int count){
        if(idx == 11){
            if(count == N){
                int apeachScore = 0;
                int lionScore = 0;
                
                for(int i = 0; i < 11; i++){
                    if(apeach[i] == 0 && arr[i] == 0)
                        continue;
                    if(apeach[i] >= arr[i]){
                        apeachScore += (10 - i);
                    } else{
                        lionScore += (10 - i);
                    }
                }
                
                if(lionScore > apeachScore){
                    if(lionScore - apeachScore > max){
                        max = lionScore - apeachScore;
                        answer = arr.clone();
                    }
                    else if((lionScore - apeachScore) == max){
                        for(int i = 10; i >= 0; i--){
                            if(answer[i] < arr[i]){
                                answer = arr.clone();
                                return;
                            } else if(answer[i] > arr[i]){
                                return;
                            }
                        }
                    }
                } 
            }
            return;
        }
        
        // 어피치랑 동점
        if(apeach[idx] == 0){
            dfs(apeach, idx + 1, count);
        }
        
        // 어피치보다 잘 쏘는 경우
        if(count + 1 + apeach[idx] <= N){
            arr[idx] = apeach[idx] + 1;
            dfs(apeach, idx + 1, count + apeach[idx] + 1);
            arr[idx] = 0;
        }
        
        // 어피치보다 못 쏘는 경우
        if(apeach[idx] != 0){
            for(int i = 0; i <= apeach[idx]; i++){
                arr[idx] = i;
                dfs(apeach, idx + 1, count + i);
                arr[idx] = 0;
            }
        }
    }
}