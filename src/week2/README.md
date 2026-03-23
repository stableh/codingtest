## BOJ 2018 - 나머지 합 구하기 (`Six.java`)
- 연속된 자연수, **투 포인터 활용방법**
- startIndex, endIndex 존재
- 시작은 1로 생각하기
- endIndex++ 이라면 무조건 `sum = sum + endIndex;`
- startIndex++ 이라면 무조건 `sum = sum - startIndex;`
- sum == N 이라면 count 증가하고 endIndex 증가
- sum < N 이라면 endIndex 증가
- sum > N 이라면 startIndex 증가
- N의 범위가 매우 크기에 정렬 알고리즘은 사용 힘들다
- 시간 복잡도 알고리즘 O(nlogn)은 제한 시간을 초과하면 사용 힘들어짐

## BOJ 1940 - 나머지 합 구하기 (`Seven.java`)
> 26.03.23 / 다시 풀어보기
- N의 최대가 15,000이기에 정렬 시간 복잡도 알고리즘 O(nlogn) 사용 가능
- 합을 비교하는 문제는 정렬하면 다루기 쉬워진다.
- 두 수의 합을 구해야하는 투 포인터 문제
- 합이 목표보다 크다면 큰 값을 줄이고, 목표보다 작다면 작은 값을 늘린다.
- 목표보다 작다면, 큰 값은 더 늘어날 곳이 없다.
- 목표보다 크다면, 작은 값은 더 줄어들 곳이 없다.

## BOJ 1253 - 나머지 합 구하기 (`Eight.java`)
> 26.03.23 다시 풀어보기
- 첫번째 시도는 음수를 고려하지 못해서 틀림
### 두번째 시도 틀린 이유
- 나는 처음에 음수를 고려못하고 startIndex나 endIndex는 점점 줄이면서 계산해야된다고 생각했음
- 예를들어, 한바퀴 돌았으면 무조건 끝 값은 -1해서 계산해야된다고 생각했음.
- 오름차순으로 정렬했고, 끝 값의 좋은 수 유무를 판단했고, 정렬되었기에 끝 값보다 좋은 수는 나오는건 불가능 하기 때문
- 하지만 음수가 들어올 수 있다면 어떤 조합으로도 합이 만들어질 수 있기에 이 생각은 틀렸다.
- 또한 두번째 시도에서는 내가 너무 어렵게 생각해서 풀었음
- 위 조건과 같이 앞 뒤가 반복으로 줄어드는 것이 아니라면 그냥 이전과 같이 투 포인터 계산을 진행하면됨
- 단! 현재 조건 확인 중인 index를 제외하는 조건으로
> EightRetry.java로 다시 풀어봤음
```java
// ver1
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

        for (int i = 0; i < (N - 2); i++) {

            M = arr[N - 1 - i];
            endIndex = N - 2 - i;
            startIndex = 0;
            
            while (startIndex < endIndex) {
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

```
