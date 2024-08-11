import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        int idx = 0;
        for(long number : numbers){
            String binaryNum = Long.toBinaryString(number);
            
            int n = 0;
            
            while((Math.pow(2, n) - 1) < binaryNum.length()){
                n++;
            }
            
            // System.out.println(n);
            
            int repeat = (int)((Math.pow(2, n) - 1) - binaryNum.length());
            binaryNum = "0".repeat(repeat).concat(binaryNum);
            
            // System.out.println(binaryNum);
        
            
            if(isBinaryTree(binaryNum)){
                answer[idx++] = 1; 
            } else{
                answer[idx++] = 0;
            }
        }
        
        return answer;
    }
    
    public boolean isBinaryTree(String tree){
        int mid = (tree.length() - 1) / 2;
        
        String leftTree = tree.substring(0, mid);
        String rightTree = tree.substring(mid + 1, tree.length());
        
        boolean compare = true;
        
        // 왼쪽과 오른쪽 서브트리가 비어 있지 않을 경우에만 체크
        if (leftTree.length() > 0 && rightTree.length() > 0) {
            boolean leftZero = leftTree.charAt((leftTree.length() - 1) / 2) == '0';
            boolean rightZero = rightTree.charAt((rightTree.length() - 1) / 2) == '0';
            
            // 루트가 '0'인데 왼쪽 또는 오른쪽 서브트리의 중앙이 '1'이면 유효하지 않음
            if (tree.charAt(mid) == '0' && (!leftZero || !rightZero)) {
                return false;
            }
        }
        
        if(leftTree.length() >= 3){
            compare = isBinaryTree(leftTree);
            if(compare){
                compare = isBinaryTree(rightTree);
            }
        }
        
        return compare;
    }
}