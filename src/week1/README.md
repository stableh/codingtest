# Week 1 - 코딩 테스트 기초

## 목차
1. [자료구조: 배열 vs 리스트](#1-자료구조-배열-vs-리스트)
2. [입출력 최적화](#2-입출력-최적화)
3. [정렬](#3-정렬)
4. [수학: 모듈러 분배 법칙](#4-수학-모듈러-분배-법칙)
5. [합배열과 구간합](#5-합배열과-구간합)
6. [문제 풀이](#6-문제-풀이)

---

## 1. 자료구조: 배열 vs 리스트

| 구분 | 배열 | 리스트 |
|------|------|--------|
| 접근 속도 | 인덱스로 빠르게 접근 | 인덱스 없어 느림 |
| 삽입/삭제 | 어려움 | 빠름 |
| 크기 | 고정 (변경 불가) | 유동적 |

### 2D ArrayList 초기화

```java
ArrayList<Edge>[] list = new ArrayList[10];

// 각 요소에 별도로 메모리 할당 필요
for (int i = 0; i < 10; i++) {
    list[i] = new ArrayList<Edge>();
}
```

> `new ArrayList[10]`만으로는 내부 리스트가 초기화되지 않으므로 반드시 각 인덱스마다 `new ArrayList<>()`를 할당해야 한다.

---

## 2. 입출력 최적화

코딩 테스트에서 입출력 속도는 성능에 직결된다.
`Scanner` 대신 `BufferedReader` + `StringTokenizer` 조합을 사용하면 크게 빨라진다.

### Scanner vs BufferedReader 속도 비교

| 방법 | 시간 (BOJ 11659 기준) |
|------|----------------------|
| Scanner | 1808ms |
| BufferedReader + StringTokenizer | 532ms |

### BufferedReader 기본 사용법

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

// 한 줄 읽기
int a = Integer.parseInt(br.readLine());

// bw는 반드시 String으로 변환 후 write
bw.write(String.valueOf(a));
bw.flush(); // 반드시 flush 해야 출력됨
```

### 주의사항

- `br.read()`는 **아스키/유니코드 int값**을 반환 → `char`로 캐스팅 필요
  ```java
  char c = (char) br.read(); // '5' → 아스키 53을 char로 변환
  ```
- `bw.write()`는 반드시 **String**으로 변환해야 함

### 여러 값 입력받기

```java
// 방법 1: split
String[] arr = br.readLine().split(" ");

// 방법 2: StringTokenizer (더 빠름, 권장)
StringTokenizer st = new StringTokenizer(br.readLine());
int a = Integer.parseInt(st.nextToken()); // nextToken() 반환 타입은 String
String b = st.nextToken();
```

---

## 3. 정렬

### 기본 정렬: Arrays.sort

```java
int[] a = {5, 4, 3, 2, 1};
Arrays.sort(a); // 오름차순
```

### 내림차순 정렬 (기본 자료형)

```java
// Integer[] 사용 시 가능하지만 코테에서는 잘 안 씀
Arrays.sort(a, Collections.reverseOrder());

// 권장: 부호 반전 2회
negative(a);   // 전체 부호 반전
Arrays.sort(a); // 오름차순 정렬
negative(a);   // 다시 부호 반전 → 내림차순 완성
```

### 다중 조건 정렬: Comparable vs Comparator

| 구분 | 위치 | 특징 |
|------|------|------|
| `Comparable` | 클래스 내부 (`compareTo`) | 기본 정렬 기준 1개 |
| `Comparator` | 클래스 외부 별도 정의 | 여러 정렬 기준 설정 가능 |

#### Comparable (클래스 내부)

```java
class Score implements Comparable<Score> {
    int english, math;

    @Override
    public int compareTo(Score o) {
        if (this.english == o.english) {
            return o.math - this.math; // math 내림차순
        }
        return o.english - this.english; // english 내림차순
    }
}

Collections.sort(myarr); // Comparable 사용
```

#### Comparator (클래스 외부)

```java
class ScoreComparator implements Comparator<Score> {
    @Override
    public int compare(Score o1, Score o2) {
        if (o1.math == o2.math) return o2.english - o1.english;
        return o2.math - o1.math; // math 내림차순
    }
}

myarr.sort(new ScoreComparator()); // Comparator 사용
```

#### 반환값 규칙 정리

**compareTo(o)**
- 음수 → `this`가 앞 (this가 더 작음)
- 양수 → `this`가 뒤 (this가 더 큼)
- `this - o` → 오름차순
- `o - this` → 내림차순

**compare(o1, o2)**
- 음수 → `o1`이 앞
- 양수 → `o2`가 앞
- `o1 - o2` → 오름차순
- `o2 - o1` → 내림차순

---

## 4. 수학: 모듈러 분배 법칙

큰 수를 곱할 때 자료형 범위를 초과하는 문제가 생긴다.
덧셈, 뺄셈, 곱셈은 **분배 법칙**이 적용되므로 매 연산마다 나머지를 취해도 결과가 같다.

```
(a × b) % m == ((a % m) × (b % m)) % m
```

### 주의: 잘못된 코드

```java
// total = total × (i % 10007) → 분배 법칙 위반
total *= i % 10007; // 잘못됨
```

### 올바른 코드

```java
long total = 1L;
for (int i = 1; i <= 50; i++) {
    total = (total * i) % 10007; // 매 연산마다 % 적용
}
```

> 나눗셈에는 분배 법칙이 적용되지 않으므로 주의 (모듈러 역원 필요).

---

## 5. 합배열과 구간합

### 합배열 (Prefix Sum)

합배열 `S[i]`를 미리 구해두면 구간합 쿼리를 **O(N) → O(1)**로 줄일 수 있다.

```
S[i] = A[0] + A[1] + ... + A[i]
S[i] = S[i-1] + A[i]
```

### 1D 구간합

```java
// 합배열 생성 (1-indexed)
int[] prefixArr = new int[N + 1];
for (int i = 1; i <= N; i++) {
    prefixArr[i] = arr[i-1] + prefixArr[i-1];
}

// i번째 ~ j번째 구간합
int result = prefixArr[j] - prefixArr[i-1];
```

### 2D 구간합 (BOJ 11660)

`(x1, y1)`부터 `(x2, y2)`까지의 합:

```
D[x][y] = D[x-1][y] + D[x][y-1] - D[x-1][y-1] + A[x][y]

result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
```

---

## 6. 문제 풀이

### BOJ 11720 - 숫자의 합 (`One.java`)
- N자리 숫자를 입력받아 각 자리의 합 출력
- `br.read()`로 한 글자씩 읽어 처리
- **시간: 104ms**

```java
for (int i = 0; i < N; i++) {
    char in = (char) br.read();
    total += Long.parseLong(String.valueOf(in));
}
```

---

### BOJ 1546 - 평균 (`Two.java`)
- 최댓값 M을 구하고 `점수 / M * 100`으로 변환 후 평균 계산
- **시간: 204ms**

```java
total += (double) arr[i] / M * 100;
System.out.println(total / N);
```

---

### BOJ 11659 - 구간합 구하기 (`Three.java` / `ThreeShort.java`)
- 1D 합배열을 이용한 구간합
- Scanner → **1808ms** / BufferedReader → **532ms**

```java
// 합배열 생성
prefixArr[i] = Integer.parseInt(st.nextToken()) + prefixArr[i-1];

// 쿼리
bw.write(prefixArr[e] - prefixArr[s-1] + "\n");
```

---

### BOJ 11660 - 구간합 구하기 5 (`Four.java`) — 미완성
- 2D 합배열을 이용한 구간합
