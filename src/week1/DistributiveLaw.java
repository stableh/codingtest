package week1;

public class DistributiveLaw {
    public static void main(String[] args) {
        // 덧셈, 뺄셈, 나눗셈은 분배 법칙이 적용된다.
        
        // 1부터 50까지 곱한 값을 10007로 나눈 나머지를 구하시오
        // 그냥 구하면 연산 중 자료값의 범위를 넘어서게됨
        // 1~50 곱한 값 % 10007
        // 모든 연산에 % 10007을 해도 된다는 것
        
        // 그냥 1을 적어도 자동으로 (long) 1로 변환됨
        long total = 1L;
        
        
        // total *= i % 10007; 가 불가능한 이유
        // total = total × (i mod 10007) 이런 연산으로 진행되기 때문
        for (int i = 1; i <= 50; i++) {
            // 이건 정상적으로 분배 법칙 적용
            total = (total * i) % 10007;
        }

        System.out.println(total);
    }
}
