class Solution {
    public String solution(String number, int k) {
        if(number.length() == 1){
            return number;
        } else if(k == 0){
            return number;
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(number.charAt(0));
        
        for(int i = 1; i < number.length(); i++){
            int curr = number.charAt(i) - '0';
            
            int j = sb.length() - 1;
            while(j >= 0 && (sb.charAt(j) - '0') < curr){
                if(k > 0){
                    k--;
                    sb.deleteCharAt(sb.length() - 1);
                    j--;
                } else {
                    break;
                }
            } 
            
            sb.append(curr);
        }
        
        while(k > 0){
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        
        return sb.toString();
    }
}