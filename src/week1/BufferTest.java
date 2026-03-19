package week1;

import java.io.*;
import java.util.StringTokenizer;

public class BufferTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*int a1 = Integer.parseInt(br.readLine());*/

        // System.out.println으로는 바로 출력 가능
        /*System.out.println(a1);*/

        // bw를 이용한다면 String 변환 필요
        /*bw.write(String.valueOf(a1));
        bw.write("\n");
        bw.flush();*/

        
        // read()는 int 값을 반환
        // read()를 사용하고 싶다면 char a2 = (char) br.read();
        /*String a2 = String.valueOf(br.readLine());
        bw.write(a2);
        bw.flush();*/

        // 여러 값 입력 받기
        // 방법 1
        /*String line = br.readLine();
        String[] arr = line.split(" ");

        bw.write(arr[0] + ' ');
        bw.write(arr[1] + ' ');

        bw.flush();*/
        
        // 방법 2
        StringTokenizer st = new StringTokenizer(br.readLine());

        // nextToken의 반환 값은 String
        int a = Integer.parseInt(st.nextToken());
        String b = st.nextToken();

        // bw.write은 반드시 String으로 변환 후 출력해야함
        bw.write(String.valueOf(a));
        bw.write(b);
        
        bw.flush();
    }
}
