import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    //JA_BU_K_A
    static long result = 0;
    static List<String> moList = List.of("A", "E", "I", "O", "U");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        backtracking(str.contains("L"), 0, 0, 0, str, 1, 1);

        System.out.println(result);
    }

    public static void backtracking(boolean containL, int mo, int ja, int idx, String str, long moCase, long jaCase){
        if(mo == 3 || ja == 3){
            return;
        }

        if(idx == str.length()){
            if(containL) {
                result += moCase * jaCase;
            }
            return;
        }

        char c = str.charAt(idx);

        if(c == '_'){
            backtracking(containL, mo + 1, 0, idx + 1, str, moCase * 5, jaCase);
            backtracking(containL, 0, ja + 1, idx + 1, str, moCase, jaCase * 20);
            backtracking(true, 0, ja + 1, idx + 1, str, moCase, jaCase);
        } else{
            if(moList.contains(String.valueOf(c))){
                backtracking(containL, mo + 1, 0, idx + 1, str, moCase, jaCase);
            } else{
                backtracking(containL, 0, ja + 1, idx + 1, str, moCase, jaCase);
            }
        }

    }
}

// JA_BU_K_A
// 25 25