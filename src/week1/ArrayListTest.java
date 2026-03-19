package week1;

import java.util.ArrayList;

class Edge {
    int endNode;
    int value;
}

// 배열과 리스트
// 배열
// 인덱스로 바로 접근 가능, 삽입, 삭제 어려움 / 크기 변경 불가능
// 리스트
// 인덱스가 없어 접근 속도 느림 / 삽입, 삭제 빠름 / 크기 지정 안해도됨

public class ArrayListTest {
    public static void main(String[] args) {
        // 이차원 ArrayList 초기화 방법
        ArrayList<Edge>[] list = new ArrayList[10];

        // 각 list에 메모리 할당을 진행해야함
        for (int i = 0; i < 10; i++) {
            list[i] = new ArrayList<Edge>();
        }
    }
}
