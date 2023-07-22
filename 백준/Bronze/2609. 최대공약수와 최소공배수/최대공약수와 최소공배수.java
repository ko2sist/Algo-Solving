import java.io.*;
import java.util.*;

// BJ #2231
public class Main {
    public static int gcd(int a, int b){
        if(a%b==0){
            return b;
        } else{
            return gcd(b,a%b);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int g = 0;

        if(a>=b){
            g = gcd(a,b);
        }else{
            g= gcd(b,a);
        }

        sb.append(g).append("\n");
        sb.append(a*(b/g));

        System.out.println(sb);
    }
}