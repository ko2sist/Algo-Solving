import java.util.*;
import java.io.*;

// BJ #17404 - RGB거리2
// Strategy: DP


public class Main {
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[3][N+1][3];
		for(int i=1; i<=N; i++) {
			if(i==1) {
				for(int j=0; j<3; j++) {
					for(int k=0; k<3; k++) {
						if(j == k) {
							dp[j][i][k] = cost[i][k];
						}else {
							dp[j][i][k] = INF;
						}
					}
				}
			}else if(i == N) {
				dp[0][i][1] = Math.min(dp[0][i-1][0], dp[0][i-1][2]) + cost[i][1];
				dp[0][i][2] = Math.min(dp[0][i-1][0], dp[0][i-1][1]) + cost[i][2];
				
				dp[1][i][0] = Math.min(dp[1][i-1][1], dp[1][i-1][2]) + cost[i][0];
				dp[1][i][2] = Math.min(dp[1][i-1][0], dp[1][i-1][1]) + cost[i][2];
				
				dp[2][i][0] = Math.min(dp[2][i-1][1], dp[2][i-1][2]) + cost[i][0];
				dp[2][i][1] = Math.min(dp[2][i-1][0], dp[2][i-1][2]) + cost[i][1];
				
			}else{
				for(int j=0; j<3; j++) {
					dp[j][i][0] = Math.min(dp[j][i-1][1], dp[j][i-1][2]) + cost[i][0];
					dp[j][i][1] = Math.min(dp[j][i-1][0], dp[j][i-1][2]) + cost[i][1];
					dp[j][i][2] = Math.min(dp[j][i-1][0], dp[j][i-1][1]) + cost[i][2];
				}
			}
		}
		
		System.out.println( Math.min(Math.min(Math.min(dp[0][N][1], dp[0][N][2]),Math.min(dp[1][N][0], dp[1][N][2])), Math.min(dp[2][N][0], dp[2][N][1]))  );
	}
}