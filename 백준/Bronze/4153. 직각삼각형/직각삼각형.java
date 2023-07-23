import java.io.*;
import java.util.*;

// BJ #4153
public class Main {
    public static boolean right(int a, int b, int c){
        if(a>=b){
          if(a>=c){
              return (a*a == b*b + c*c);
          }else{
              return (c*c == a*a + b*b);
          }
        } else {
            if (b >= c) {
                return (b*b == a*a + c*c);
            } else {
                return (c*c == a * a + b * b);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if((A==0) && (B==0) && (C==0)){
                break;
            }else{
                if(right(A,B,C)==true){
                    sb.append("right").append("\n");
                }else {
                    sb.append("wrong").append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}