import java.util.*;
import java.io.*;

// BJ #10830 - 행렬제곱
// Strategy: 분할정복

public class Main {
    static int N;
    static long[][] m;
    
    public static long[][] multiple(long[][] m1, long[][] m2){
        long[][] tmp = new long[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
               
                for(int k=0; k<N; k++) {
                    tmp[i][j] += m1[i][k]*m2[k][j];
                }
                tmp[i][j] %= 1000;
                
            }
        }
        
        return tmp;
    }
    
    public static long[][] get(long b) {
        if(b == 1) {
            return m;
        }else if(b==2) {
            return multiple(m,m);
        }
        
        
        if(b % 2 == 0) {
            long[][] tmp = get(b/2);
            return multiple(tmp, tmp);
        }else {
            long[][] tmp = get(b/2);
            return multiple(multiple(tmp,tmp),m); 
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        m = new long[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                m[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        long[][] res = get(B);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(res[i][j]%1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}