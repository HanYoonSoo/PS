import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        Set<Integer> init = new HashSet<>();
        Set<Integer> having = new HashSet<>();
        
        int N = cards.length;
        
        for(int i = 0; i < N / 3; i++){
            init.add(cards[i]);
        }
        
        int round = 1;
        
        int target = N + 1;
        
        for(int i = N / 3; i < N; i += 2){
            boolean compare = false;
            int first = cards[i];
            int second = cards[i + 1];
            // round++;
            
            having.add(first);
            having.add(second);
            
            // System.out.println(init + " " + having + " " + round);
            
            for(int num : init){
                if(init.contains(target - num)){
                    init.remove(num);
                    init.remove(target - num);
                    compare = true;
                    break;
                }
            }
            
            if(!compare){
                if(coin > 0){
                    for(int num : init){
                        if(having.contains(target - num)){
                            init.remove(num);
                            having.remove(target - num);
                            compare = true;
                            coin--;
                            break;
                        }
                    }
                }
            }
            
            if(!compare){
                if(coin > 1){
                    for(int num : having){
                        if(having.contains(target - num)){
                            having.remove(target - num);
                            having.remove(num);
                            compare = true;
                            coin -= 2;
                            break;
                        }
                    }
                }
            }
            
            // System.out.println(init + " " + having + " " + round + " " + compare + " " + coin);
            
            if(!compare){
                break;
            } else{
                round++;
            }
            
        }
        
        return round;
    }
}