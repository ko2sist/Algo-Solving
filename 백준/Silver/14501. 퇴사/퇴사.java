import java.io.*;
import java.util.*;

// BJ #14501 - 퇴사
// Strategy: DP
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			T[i] = t;
			P[i] = p;
		}
		
		
		int[] dp = new int[N+2];
		
		for(int i=N; i>0; i--) {
			int end = i+T[i]-1;
			if(end >= N+1) {
				dp[i] = dp[i+1];
			}else {
				dp[i] = Math.max(dp[i+1], dp[end+1] + P[i]);
			}
		}

		// 최종 결과 출력
		System.out.println(dp[1]);
	}
}