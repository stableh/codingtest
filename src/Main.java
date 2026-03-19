import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        System.out.println(s);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int b = Integer.parseInt(br.readLine());
        String s2 = String.valueOf(b);

        bw.write(s2);
        
        //출ㄹ3
        bw.flush();
        
        
    }
}

