## BOJ 2018 - 나머지 합 구하기 (`Six.java`)
- 연속된 자연수, **투 포인터 활용방법**
- startIndex, endIndex 존재
- 시작은 1로 생각하기
- endIndex++ 이라면 무조건 `sum = sum + endIndex;`
- startIndex++ 이라면 무조건 `sum = sum - startIndex;`
- sum == N 이라면 count 증가하고 endIndex 증가
- sum < N 이라면 endIndex 증가
- sum > N 이라면 startIndex 증가

## BOJ 2018 - 나머지 합 구하기 (`Six.java`)
