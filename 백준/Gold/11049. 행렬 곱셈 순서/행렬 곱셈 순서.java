import java.util.*;
import java.io.*;

// BJ #11049 - 행렬 곱셈 순서
// Strategy: DP

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] rc = new int[N+1][2];
        for(int i=1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	rc[i][0] = r;
        	rc[i][1] = c;
        }
        
        
        int[][] dp = new int[N+1][N+1];
        for(int d=1; d<=N-1; d++) {
        	for(int i=1; i<=N-1; i++) {
        		if(i+d > N) break;
        		
        		dp[i][i+d] = Integer.MAX_VALUE;
        		
        		for(int j=i; j<i+d; j++) {
        			dp[i][i+d] = Math.min(dp[i][i+d], dp[i][j] + dp[j+1][i+d] + rc[i][0]*rc[j][1]*rc[i+d][1]);
        		}
        	}
        }
//        
//        for(int[] line : dp) {
//        	System.out.println(Arrays.toString(line));
//        }
        System.out.println(dp[1][N]);
    }
}