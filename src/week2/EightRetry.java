package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 더 깔끔한 코드로 재시도
public class EightRetry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        
        int left;
        int right;
        long find;
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            left = 0;
            right  = N - 1;
            find = arr[i];

            while (left < right) {
                long sum = arr[left] + arr[right];
                if (sum == find) {
                    if (left != i && right != i) {
                      count++;  
                      break;
                    } else if (left == i) {
                        left++;
                    } else if (right == i) {
                        right--;
                    }
                } else if (sum > find) {
                    right--;
                } else {
                    left++;
                }
                
            }
        }
        System.out.println(count);
    }
}

