import org.w3c.dom.ls.LSOutput;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            Deque<Integer> dq = new LinkedList<>();
            String[] commands = br.readLine().split("");
            boolean isLeft = true;
            int num = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split("\\D+");

            for (int i = 1; i < nums.length; i++) {
                dq.add(Integer.parseInt(nums[i]));
            }

//            System.out.println(dq);

            boolean isError = false;

            int rCount = 0;

            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equals("R")) {
                    isLeft = !isLeft;
                    rCount++;
                } else if (commands[i].equals("D")) {
//                    System.out.println(dq);
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isLeft) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                    }
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                int size = dq.size();
                if (rCount % 2 == 0) {
                    for (int i = 0; i < size; i++) {
                        if (i != size - 1)
                            sb.append(dq.pollFirst()).append(",");
                        else
                            sb.append(dq.pollFirst());
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        if (i != size - 1)
                            sb.append(dq.pollLast()).append(",");
                        else
                            sb.append(dq.pollLast());
                    }
                }
                sb.append("]").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
