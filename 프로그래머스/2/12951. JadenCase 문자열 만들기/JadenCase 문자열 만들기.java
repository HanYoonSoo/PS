class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ", -1);  // 연속된 공백도 유지하도록 설정
        
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isEmpty()) { // 공백이 아닌 경우 처리
                sb.append(Character.toUpperCase(arr[i].charAt(0))); // 첫 글자 대문자
                sb.append(arr[i].substring(1).toLowerCase()); // 나머지 소문자 변환
            }
            if (i < arr.length - 1) { // 마지막 단어가 아니면 공백 추가
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}
