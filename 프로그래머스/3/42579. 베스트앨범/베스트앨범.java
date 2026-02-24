import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresSumMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> genresIdxPlayMap = new HashMap<>();
        
        int N = genres.length;
        
        for (int i = 0; i < N; i++) {
            genresSumMap.put(genres[i], genresSumMap.getOrDefault(genres[i], 0) + plays[i]);
            if (!genresIdxPlayMap.containsKey(genres[i])) {
                genresIdxPlayMap.put(genres[i], new HashMap<>());
                genresIdxPlayMap.get(genres[i]).put(i, plays[i]);
            } else {
                genresIdxPlayMap.get(genres[i]).put(i, plays[i]);
            }
        }
        
        List<String> sumList = new ArrayList<>(genresSumMap.keySet());
        
        Collections.sort(sumList, (o1, o2) -> {
            return genresSumMap.get(o2) - genresSumMap.get(o1);
        });
        
        List<Integer> result = new ArrayList<>();
        
        for (String key : sumList) {
            Map<Integer, Integer> map = genresIdxPlayMap.get(key);
            
            List<Integer> idxPlayList = new ArrayList<>(map.keySet());
            
            Collections.sort(idxPlayList, (o1, o2) -> {
               if (map.get(o1) == map.get(o2)) {
                   return o1 - o2;
               } else {
                   return map.get(o2) - map.get(o1);
               }
            });
            
            result.add(idxPlayList.get(0));
            
            if (idxPlayList.size() > 1) 
                result.add(idxPlayList.get(1));
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}