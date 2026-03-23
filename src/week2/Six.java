package week2;


import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2018
// 투 포인터 활용 방법
public class Six {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;

        while (endIndex != N) {
            if (sum == N) {
                count++;
                endIndex++;
                sum = sum + endIndex;
            } else if (sum < N) {
                endIndex++;
                sum = sum + endIndex;
            } else { // sum > N
                sum = sum - startIndex;
                startIndex++;
            }
        }
        System.out.println(count);
    }
}
