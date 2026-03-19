package week1.practice;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11720
// 1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번재 줄에 숫자 N개가 공백 없이 주어진다.
// 입력으로 주어진 숫자 N개의 합을 출력한다.
// 시간: 104ms
// String s = sc.next()로 입력받고,
// char[] c = s.toCharArray()로 하는 방법도 존재
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        
        long total = 0;

        // bf.read는 무조건 아스키 코드, 유니코드 값이 반환되게이 char이 아니면 문제 생김
        // '5' > 53
        // '4' > 52
        // '3' > 51
        // '2' > 50
        // '1' > 49
        for (int i = 0; i < N; i++) {
            char in = (char) (bf.read());
            total += Long.parseLong(String.valueOf(in));
        }
        
        bw.write(total + "\n");
        bw.flush();
    }
}
