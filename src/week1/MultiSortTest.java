package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MultiSortTest {
    public static void main(String[] args) {

        ArrayList<Score> myarr = new ArrayList<>();
        myarr.add(new Score(80, 100));
        myarr.add(new Score(100, 50));
        myarr.add(new Score(70, 100));
        myarr.add(new Score(80, 90));

        // Comparable
        // class 내부에 설저
        // Collections.sort(myarr);
        
        // Comparator
        // class 외부 별도 정의
        // 한 클래스에 여러개 설정 가능하다는 장점
        myarr.sort(new ScoreComparator());
        for (Score s : myarr) {
            System.out.println(s.toString());
        }
    }
}

class Score implements Comparable<Score> {

    int english;
    int math;

    public Score(int english, int math) {
        this.english = english;
        this.math = math;
    }

    @Override
    public String toString() {
        return String.format("Score{english: %d, math: %d}", english, math);
    }
    
    // 음수가 반화되면 this가 앞에 위치
    // 양수가 반환되면 this가 뒤에 위치
    // this - o → 오름차순
    // o - this → 내림차순
    // 배열이 a, b, c, d가 존재한다면?
    // a vs b, a vs c, a vs d
    // b vs c 등이 계속 반복됨
    // [80, 100]이라면
    // 80.compareTo(100)이 됨, o = 100, this = 80
    // 양수면 80이 뒤로 이동
    @Override
    public int compareTo(Score o) {
        if (this.english == o.english) {
            return o.math - this.math;
        }
        
        return o.english - this.english;
    }
}


class ScoreComparator implements Comparator<Score> {
    // 뒷 값이 앞 값보다 크다면 내림차순 정렬
    // 결과가 0보다 크면 o2가 앞
    // 결과가 0보다 작다면 o1이 값
    // 80, 100이든 100, 80이든 두 결과의 값은 같을 수 밖에 없음
    // 쉽게 이해하기
    // compare(80, 100)이 있을 때
    // 80이 앞으로 가야하면 음수(오름차순), 뒤로가야하면 양수가 되어야함(내림차순)
    
    @Override
    public int compare(Score o1, Score o2) {
        if (o1.math == o2.math) return o2.english - o1.english;
        return o2.math - o1.math;
    }
}
