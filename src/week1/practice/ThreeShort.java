package week1.practice;

// 656ms
// arr1 제거 버전: 532ms
// arr1은 굳이 필요없음
// for (int i = 1; i <= N; i++) {
//            prefixArr[i] =Integer.parseInt(st.nextToken()) + prefixArr[i-1];
//        }
import java.io.*;
import java.util.StringTokenizer;

public class ThreeShort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        
        int[] prefixArr = new int[N + 1];
        prefixArr[0] = 0;
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        // 이렇게 구간합 구하기
        for (int i = 1; i <= N; i++) {
            prefixArr[i] = arr1[i-1] + prefixArr[i-1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bw.write(prefixArr[e] - prefixArr[s-1] + "\n");
        }
        bw.flush();
    }
}
