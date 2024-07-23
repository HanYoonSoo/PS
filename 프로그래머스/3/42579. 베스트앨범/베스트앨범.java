import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, HashMap<Integer, Integer>> genreMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            sumMap.put(genre, sumMap.getOrDefault(genre, 0) + plays[i]);
            
            if(genreMap.containsKey(genre)){
                genreMap.get(genre).put(i, plays[i]);
            } else{
                HashMap<Integer, Integer> genreIdxMap = new HashMap<>();
                genreIdxMap.put(i, plays[i]);
                genreMap.put(genre, genreIdxMap);
            }
        }
        
        List<String> sumList = new ArrayList<>(sumMap.keySet());
        
        Collections.sort(sumList, (o1, o2) -> {
           return sumMap.get(o2) - sumMap.get(o1); 
        });
        
        List<Integer> answer = new ArrayList<>();
        
        for(String genre : sumList){
            HashMap<Integer, Integer> map = genreMap.get(genre);
            
            List<Integer> genreIdx = new ArrayList<>(map.keySet());
            
            Collections.sort(genreIdx, (o1, o2) -> {
                if(map.get(o1) == map.get(o2)){
                    return o1 - o2;
                }
                return map.get(o2) - map.get(o1);
            });
            
            answer.add(genreIdx.get(0));
            
            if(genreIdx.size() > 1)
                answer.add(genreIdx.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
        
    }
}