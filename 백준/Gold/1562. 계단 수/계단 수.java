import java.util.*;
import java.io.*;

// BJ #1562 - 계단수
// Strategy: DP, 비트마스킹

public class Main {
	static final int MOD = 1000000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][][] dp = new long[N+1][10][1<<10];
		
		for(int i=1; i<10; i++) {
			dp[1][i][1<<i] = 1;
		}
		
		for(int i=2; i<N+1; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<1024; k++) {
					int bit = k | (1<<j);
					if(j==0) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]) % MOD;
					}else if(j==9) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % MOD;
					}else {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k] + dp[i-1][j-1][k]) % MOD;
					}
				}
			}
		}
		
		long res = 0;
		for(int i=0; i<10; i++) {
			res += dp[N][i][1023];
			res %= MOD;
		}
		System.out.println(res);
    }
}