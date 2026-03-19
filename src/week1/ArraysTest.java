package week1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArraysTest {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};

        // 기본적인 .sort는 오름차순
        Arrays.sort(a);
        // 기본 자료형을 클래스형(Integer)로 사용하면 내림차순 가능
        // 하지만 코테에서는 클래스 자료형 잘 안씀
        // Integer[] a = {5, 4, 3, 2, 1};
        // Arrays.sort(a, Collections.reverseOrder());
        
        // 그래서 부호반전을 2번하여 내림차순 완성
        negative(a);
        Arrays.sort(a);
        negative(a);
        
        System.out.println(Arrays.toString(a));;
    }

    static void negative(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] *= -1;
        }
    }
}
