class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                answer += ' ';
                index = 0;
                continue;
            }
            if(index % 2 == 0){
                answer += String.valueOf(s.charAt(i)).toUpperCase();
            }
            else{
                answer += String.valueOf(s.charAt(i)).toLowerCase();
            }
            index++;
        }
        
        return answer;
    }
}