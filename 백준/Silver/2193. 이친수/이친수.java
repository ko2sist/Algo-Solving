import java.io.*;
import java.util.*;

// BJ #2193 - 이친수
// Strategy: DP

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N : 이친수의 자리수
		int N = Integer.parseInt(br.readLine());
		
		// dp : 이친수의 개수를 계산할 dp 배열
		long[] dp = new long[N+1];
		
		// 초기 조건 입력
		dp[0] = 0;
		dp[1] = 1;
		
		// 이친수의 개수 계산
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		// 최종 결과 출력
		System.out.println(dp[N]);
		
		
	}
}