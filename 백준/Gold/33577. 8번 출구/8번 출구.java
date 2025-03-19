import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        long[] immunities = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            immunities[i] = Long.parseLong(st.nextToken());
        }
        
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + immunities[i];
        }
        
        long[] exitsAvailable = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            exitsAvailable[i] = immunities[i - 1] - prefixSum[i - 1];
        }
        
        long[] exitsMax = new long[n + 1];
        exitsMax[1] = exitsAvailable[1];
        for (int i = 2; i <= n; i++) {
            exitsMax[i] = Math.max(exitsMax[i - 1], exitsAvailable[i]);
        }
        
        long immunityCurr = 0;
        long ret = 0;
        
        while (immunityCurr < prefixSum[n]) {
            int idx = Arrays.binarySearch(prefixSum, immunityCurr);
            if (idx < 0) {
                idx = -idx - 2;
            }
            
            if (idx == n) {
                break;
            }
            
            long immunityNext = prefixSum[idx + 1];
            long immunityIncrease = exitsMax[idx + 1];
            long diff = immunityNext - immunityCurr;
            
            long r = (immunityIncrease + diff - 1) / immunityIncrease;
            immunityCurr += r * immunityIncrease;
            ret += r;
        }
        
        out.write(ret + "\n");
        out.flush();
        br.close();
        out.close();
    }
}
