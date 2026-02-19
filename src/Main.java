import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String st = sc.next();

        char[] list = st.toCharArray();
        
        int sum = 0;
        for (char a : list) {
            sum += Integer.parseInt(String.valueOf(a));
        }

        System.out.println(sum);
        
        
    }
}
