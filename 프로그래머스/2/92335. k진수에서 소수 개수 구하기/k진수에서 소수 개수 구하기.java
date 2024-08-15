class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        
        String[] numArr = num.split("0");
        
        // System.out.println(Integer.toString(n, k));
        
        for(int i = 0; i < numArr.length; i++){
            if(numArr[i].equals(""))
                continue;
            long prime = Long.parseLong(numArr[i]);
            if(isPrime(prime)){
                // System.out.println(prime);
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num){
        if(num == 1){
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}