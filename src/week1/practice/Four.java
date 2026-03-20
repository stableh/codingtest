package week1.practice;

// https://www.acmicpc.net/problem/11660

// N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. 
// (x, y)는 x행 y열을 의미한다.
//

// D(X, Y)는 (0,0)부터 A(X, Y)까지의 구간 합
// D(X, Y)는 D[X][Y-1] + D[X-1][Y] - D[X-1][Y-1] + A[X][Y]
// 쉽게 말하자면 왼->오 대각선의 합은 더하고, 왼쪽 위 첫 합 값은 뺀 뒤, 구하고자 하는 위치의 원래 값은 더하기
// 만약 (2, 2) ~ (3, 4)의 구간합을 구하고자 한다면? D(1, 4), D(4,1)을 빼면 됨. 이런식으로 구하기

import java.io.*;
import java.util.StringTokenizer;

public class Four {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixArr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixArr[i][j] = prefixArr[i][j - 1] + prefixArr[i - 1][j] - prefixArr[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(prefixArr[x2][y2] - prefixArr[x2][y1 - 1] - prefixArr[x1 - 1][y2] + prefixArr[x1 - 1][y1 - 1] + "\n");
        }
        
        bw.flush();


    }
}
