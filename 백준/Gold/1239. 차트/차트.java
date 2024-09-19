import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] chart;	//차트 정보 저장 배열
    static boolean[] check;	//차트 직선 지나는 범위 배열
    //fullMask : 비트마스킹을 통한 모든 차트 내용 사용 확인 값
    static int result = 0, N, fullMask;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int max  = -1;	//차트 내 최대값 변수
        chart = new int[N];
        check = new boolean[51];
        fullMask = (1 << N) - 1;	//fullMask 초기화
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        //차트 값 저장
        for(int i=0;i<N;i++){
            chart[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, chart[i]);	//최대값 비교
        }
        if(max > 50)	//50% 이상 존재 시, 직선 X
            bw.write("0");
        else if(max == 0)	//50% 존재 시, 직선 1개
            bw.write("1");
        else{		// 50% 미만일 때, 모든 경우 탐색
            check[0] = true;	//12시 시작값 기준 시작
            search(0, 0,false, 0);	//모든 경우 탐색
            bw.write(String.valueOf(result));	//최대 개수 BufferedWriter 저장
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //차트 모든 경우 탐색하는 재귀함수
    static void search(int cnt, int sum, boolean flag, int mask){
        if(mask == fullMask){	//차트 완성시.
            result = Math.max(result, cnt);
            return;
        }
        //다음 차트에 들어갈 영역 탐색
        for(int i=0;i<N;i++){
            if((mask & (1<<i)) >= 1)	//이미 탐색한 영역일 때
                continue;
            int temp = chart[i] + sum;

            if(!flag){	//12시부터 시작했을 때 영역
                if(temp>= 50){	//50퍼를 넘어서 6시 이후 구역으로 넘어갈 때
                    if(check[temp % 50]) {	//직선이 생길 때
                        search(cnt+1, temp % 50, true, mask | (1 << i));
                    }else	//직선이 생기지 않을 때
                        search(cnt, temp%50, true, mask|(1<<i));
                }else{	//50퍼를 넘어가지 않을 때
                    check[temp] = true;	//해당 영역 선 생성
                    search(cnt, temp, false, mask | (1<<i) );	//다음 영역 탐색
                    check[temp] = false;	//해당 영역 선 제거
                }
            }else{	//6시부터 시작했을 때 영역
                if(check[temp]) {	//직선이 생길 때
                    search(cnt + 1, temp, true, mask | (1 << i));
                }else	//직선이 생기지 않을 때
                    search(cnt, temp, true, mask | (1<<i));
            }
        }
    }
}