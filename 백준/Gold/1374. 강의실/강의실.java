import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Course{
        int startTime;
        int endTime;

        public Course(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Course[] courses = new Course[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            courses[i] = new Course(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(courses, (o1, o2) -> {
           if(o1.startTime == o2.startTime)
               return o1.endTime - o2.endTime;
            return o1.startTime - o2.startTime;
        });

        PriorityQueue<Course> pq = new PriorityQueue<>((o1, o2) -> o1.endTime - o2.endTime);

        int max = 0;

        for(int i = 0; i < N; i++){
            if(!pq.isEmpty() && pq.peek().endTime <= courses[i].startTime){
                pq.poll();
            }

            pq.add(courses[i]);

            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}
