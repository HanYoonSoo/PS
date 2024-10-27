import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        Set<Integer> base = new HashSet<>();
        Set<Integer> having = new HashSet<>();
        
        int N = cards.length;
        
        for(int i = 0; i < N / 3; i++){
            base.add(cards[i]);
        }
        
        int target = N + 1;
        
        int idx = N / 3;
        
        int result = 0;
        
        while(true){
            if(idx >= N){
                break;
            }
            boolean compare = false;
            
            having.add(cards[idx]);
            having.add(cards[idx + 1]);
            
            idx += 2;
            
            for(int b : base){
                if(base.contains(target - b)){
                    base.remove(b);
                    base.remove(target - b);
                    compare = true;
                    result++;
                    break;
                }
            }
            
            if(!compare){
                if(coin > 0){
                    for(int b : base){
                        if(having.contains(target - b)){
                            base.remove(b);
                            having.remove(target - b);
                            compare = true;
                            coin--;
                            result++;
                            break;
                        }
                    }
                }
            }
            
            if(!compare){
                if(coin > 1){
                    for(int h : having){
                        if(having.contains(target - h)){
                            having.remove(h);
                            having.remove(target - h);
                            compare = true;
                            coin -= 2;
                            result++;
                            break;
                        }
                    }
                }
            }
            
            if(!compare){
                break;
            }
        }
        
        return result + 1;
    }
}