import java.io.*;
import java.util.*;

// BJ #1535 - 안녕
// Strategy: DP(0-1 knapsack)

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[2][N+1];
		for(int i=0; i<2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N+1][100];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<100; j++) {
				if(arr[0][i] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[0][i]]+arr[1][i]);
				}
			}
		}
		
		System.out.println(dp[N][99]);
		
		
	}
}