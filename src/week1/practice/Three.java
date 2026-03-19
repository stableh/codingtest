package week1.practice;

// https://www.acmicpc.net/problem/11659
// 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

// 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
// 둘째 줄에는 N개의 수가 주어진다. 
// 수는 1,000보다 작거나 같은 자연수이다. 
// 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

// 시간이 좀 걸림
// 1808ms
import java.util.Arrays;
import java.util.Scanner;

// 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr1 = new int[N];
        
        int[] prefixArr = new int[N + 1];
        prefixArr[0] = 0;
        
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        // 이렇게 구간합 구하기
        for (int i = 1; i <= N; i++) {
            prefixArr[i] = arr1[i-1] + prefixArr[i-1];
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            System.out.println(prefixArr[e] - prefixArr[s-1]);
        }
    }
}
