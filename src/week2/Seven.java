package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1940
public class Seven {
    public static void main(String[] args) throws IOException {

        // 2가지 재료로 만드는데 2가지 번호를 합쳐 M(1 <= M <= 10^8)이 면 만들어짐
        // N(1 <= N <= 15,000)의 재료로 몇개의 갑옷을 만들 수 있는지
        // 투 포인터 정렬을 이용하여 풀어도 된다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;

        while (startIndex < endIndex) {
            
            int sum = arr[startIndex] + arr[endIndex];
            
            if (sum == M) {
                startIndex++;
                endIndex--;
                count++;
            } else if (sum > M) {
                endIndex--;
            } else {
                startIndex++;
            }
        }

        System.out.println(count);

    }
}
