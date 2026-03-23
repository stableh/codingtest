package week1.practice;

import java.io.*;
import java.util.StringTokenizer;

public class FiveSecondTry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefix = new long[N+1];
        // 나머지 갯수 배열
        long[] remainder = new long[M];
        
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefix[i] = Long.parseLong(st.nextToken()) + prefix[i - 1];
        }
        
        // 나머지 배열로 변경
        // 1부터 시작하는 이유는?
        // 그래야 첫 입력 구간부터 계산이 진행됨
        // 만약 1부터 시작하고 싶다면 if(mod == 0) answer++;로 설정
        for (int i = 0; i <= N; i++) {
            int mod = (int) (prefix[i] % M);
            remainder[mod]++;
        }

        // 배열 내의 나머지 갯수는 N보다 많을 수 없다.
        for (int i = 0; i < M; i++) {
            if (remainder[i] == 0) continue;
            answer = answer + ((remainder[i] * (remainder[i]-1)) / 2);
        }

        System.out.println(answer);
    }
}
