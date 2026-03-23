package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좋은 수 구하기
public class Eight {
    // N 크기 배열의 입력 값 크기는 10^9가 넘으니 long 배열로 설정
    // 입력값이 2,000개 미만이므로 정렬 가능할 것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 좋은 수라고 한다.
        // 1~10에서 1, 2는 다른 두 수의 합으료 표현되는 것이 불가능
        // 하지만 연속된 값이 아닐 수 있음
        // 초기 설계
        // 정렬하여 맨 뒷 값을 M으로 설정
        // startIndex를 맨 앞, endIndex를 M-1로 설정
        // 어차피 맨 앞의 값은 뒤에있는 숫자보다 작기에 더해서 좋은 수로 설정되는 것이 불가능
        // 맨 앞 2개는 좋은 수 불가능
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long M;
        int startIndex = 0;
        int endIndex;
        int count = 0;

        for (int i = 0; i < N; i++) {

            M = arr[N - 1 - i];
            endIndex = N - 1;
            startIndex = 0;
            
            while (startIndex < endIndex) {
                if (startIndex == N - 1 - i) startIndex++;                
                else if (endIndex == N - 1 - i) endIndex--;
                
                if (startIndex >= endIndex) break; 
                
                long sum = arr[startIndex] + arr[endIndex];

                if (sum == M) {
                    count++;
                    break;
                } else if (sum < M) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }

        System.out.println(count);
    }
}
