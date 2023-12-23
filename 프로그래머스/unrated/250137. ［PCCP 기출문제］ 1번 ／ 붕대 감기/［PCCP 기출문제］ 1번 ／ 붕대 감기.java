class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attack_distance = 0;
        // 어택 배열 ((Attack - 1) - bandage)
        int answer = health;
        int attack_time = 0;
        
        for(int i = 0; i < attacks.length; i++){
            attack_distance = attack_time;
            attack_time = attacks[i][0];
            
            int temp = Math.abs(attack_time - attack_distance);

            int plus = ((temp - 1) / bandage[0]) * bandage[2];
            int common = (temp - 1) * bandage[1];
            
            answer += (plus + common);
            
            if(answer >= health)
                answer = health;
            
            answer -= attacks[i][1];
            
            if(answer <= 0){
                return -1;
            }
            
            System.out.println(attacks[i][0] + " " + answer);
        }
        
        return answer;

    }
}