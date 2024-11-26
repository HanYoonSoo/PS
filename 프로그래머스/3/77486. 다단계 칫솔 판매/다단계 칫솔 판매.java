import java.util.*;

class Solution {
    
    class Node{
        int node;
        int parent;
        
        public Node(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> idxMap = new HashMap<>();
        
        int idx = 1;
        for(String s : enroll){
            idxMap.put(s, idx++);
        }
        
        Node[] tree = new Node[idx];
        
        tree[0] = new Node(0, -1);
        
        for(int i = 0; i < referral.length; i++){
            if(referral[i].equals("-")){
                tree[idxMap.get(enroll[i])] = new Node(idxMap.get(enroll[i]), 0);
            } else{
                tree[idxMap.get(enroll[i])] = new Node(idxMap.get(enroll[i]), idxMap.get(referral[i]));
            }
        }
        
        int[] result = new int[enroll.length];
        
        for(int i = 0; i < seller.length; i++){
            String temp = seller[i];
            int point = amount[i] * 100;
            
            while (true) {
                int sellerIdx = idxMap.get(temp);
                // if (sellerIdx == null || sellerIdx >= tree.length || tree[sellerIdx] == null) {
                //     break; // 인덱스가 범위를 벗어나거나 유효하지 않은 경우 종료
                // }

                int compute = point / 10;
                result[sellerIdx - 1] += point - compute; // 현재 판매자의 수익 추가
                
                if (tree[sellerIdx].parent == 0 || tree[sellerIdx].parent == -1) {
                    break; // 루트 노드에 도달한 경우 종료
                }
                point = compute;
                
                if(point == 0)
                    break;
                
                temp = enroll[tree[sellerIdx].parent - 1];
            }
            
//             for(int t = 0; t < result.length; t++){
//                 System.out.print(result[t] + " ");
//             }
            
//             System.out.println();
        }
        
        return result;
        
    }
}