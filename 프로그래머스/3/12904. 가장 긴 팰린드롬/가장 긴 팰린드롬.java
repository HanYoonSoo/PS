class Solution {
    public int solution(String s) {
        // s = "abaacde";
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            answer = Math.max(answer, findLongPalindrome(i - 1, i + 1, s));
            answer = Math.max(answer, findLongPalindrome(i, i + 1, s));
        }

        return answer;
    }
    
    public int findLongPalindrome(int left, int right, String s){
        while((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        while(right == s.length() && left >= 0 && s.charAt(left) == s.charAt(right - 1)){
            left--;
        }
        
        while(left == -1 && right < s.length() && s.charAt(left + 1) == s.charAt(right)){
            right++;
        }
        
        return right - left - 1;
    }
}

// a c a