package week1.practice;

// https://www.acmicpc.net/problem/10986
// 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
// 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 내 설계
// 1~5
// 2~5
// ...
// 전부 검사하면 가능
// 
public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 출력 연산은 간단하기에 sout 사용
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        // 이전 입력 값 기억 위함
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int[] prefix = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            
            for (int j = 0; j < N; j++) {
                if (i + j > N) break;
                
                prefix[i+j] = arr[i+j] + prefix[i + j - 1];

                if (prefix[i + j] % M == 0) {
                    count++;
                }
            }

            Arrays.fill(prefix, 0);
        }

        System.out.println(count);
    }
}
