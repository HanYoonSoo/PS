import java.util.*;

class Solution {
    List<String> arr;
    public int solution(String[] words) {
        int answer = 0;
        int len = words.length;
        arr = new ArrayList<>(Arrays.asList(words));

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                if(s1.compareTo(s2) > 0)
                    return 1;
                return -1;
            }
        });

        // for(String str: arr){
        //     System.out.println(str);
        // }

        for(int i = 0; i < len; i++){
            if(i == 0){
                answer += check(arr.get(i), arr.get(i + 1));
            } else if(i == len - 1){
                answer += check(arr.get(i), arr.get(i - 1));
            } else{
                answer += Math.max(check(arr.get(i), arr.get(i - 1)), check(arr.get(i), arr.get(i + 1)));
            }

            // System.out.println(answer);
        }


        return answer;
    }

    public int check(String org, String target){
        int count = 0;
        int compareLen = Math.min(org.length(), target.length());

        for(int i = 0; i < compareLen; i++){
            if(org.charAt(i) != target.charAt(i)){
                return count + 1;
            }
            count++;
        }

        if(org.length() > target.length() && count == target.length()){
            count++;
        }

        return count;
    }
}