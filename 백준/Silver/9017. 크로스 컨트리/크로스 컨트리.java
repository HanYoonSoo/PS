import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            Map<Integer, Integer> teamCount = new HashMap<>();
            Map<Integer, List<Integer>> teamMap = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N + 1];
            for(int i = 1; i <= N; i++){
                arr[i] = Integer.parseInt(st.nextToken());

                teamCount.put(arr[i], teamCount.getOrDefault(arr[i], 0) + 1);
//                if(!teamMap.containsKey(team)){
//                    teamMap.put(team, new ArrayList<>());
//                    teamMap.get(team).add(i);
//                } else{
//                    teamMap.get(team).add(i);
//                }
            }

            int rank = 0;
            for(int i = 1; i <= N; i++){
                if(teamCount.get(arr[i]) >= 6){
                    if(!teamMap.containsKey(arr[i])){
                        teamMap.put(arr[i], new ArrayList<>());
                        teamMap.get(arr[i]).add(rank++);
                    } else{
                        teamMap.get(arr[i]).add(rank++);
                    }
                }
            }

            List<Integer> equalTeam = new ArrayList<>();

            int min = Integer.MAX_VALUE;
            for(int team : teamMap.keySet()){
                int sum = 0;
                if(teamMap.get(team).size() >= 6){
                    for(int i = 0; i < 4; i++){
                        sum += teamMap.get(team).get(i);
                    }
                }

//                System.out.println(team + " " + sum);

                if(sum != 0){
                    if(min > sum){
                        if(min == Integer.MAX_VALUE) {
                            min = sum;
                            equalTeam.add(team);
                        } else {
                            min = sum;
                            equalTeam.clear();
                            equalTeam.add(team);
                        }
                    } else if(min == sum){
                        equalTeam.add(team);
                    }
                }
            }

//            System.out.println(equalTeam);
            if(equalTeam.size() == 1){
                System.out.println(equalTeam.get(0));
            } else{
                int totalMin = Integer.MAX_VALUE;
                int winTeam = -1;

                for(int team : equalTeam){
                    if(totalMin > teamMap.get(team).get(4)){
                        totalMin = teamMap.get(team).get(4);
                        winTeam = team;
                    }
                }

                System.out.println(winTeam);
            }
        }
    }
}
