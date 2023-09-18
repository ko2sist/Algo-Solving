import java.util.*;
import java.io.*;

// BJ #7579 - 앱
// Strategy: DP, 0-1 knapsack

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] m = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
        	m[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int[] c = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
        	c[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] res = new int[N+1][100*N+1];
        for(int i=1; i<=N; i++) {
        	for(int j=0; j<=100*N; j++) {
        		if(c[i] <= j) {
        			res[i][j] = Math.max(res[i-1][j], res[i-1][j-c[i]]+m[i]);
        		}else {
        			res[i][j] = res[i-1][j];
        		}
        	}
        }
        
        loop: for(int j=0; j<=100*N; j++) {
        	for(int i=1; i<=N; i++) {
        		if(res[i][j] >= M) {
        			System.out.println(j);
        			break loop;
        		}
        	}
        }
    }
}