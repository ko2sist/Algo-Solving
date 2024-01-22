import java.io.*;
import java.util.*;

// BJ #1699 - 제곱수의 합
// Strategy: DP

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N : 제곱수 항의 최소 개수를 구할 자연수
		int N = Integer.parseInt(br.readLine());
		
		// 제곱수 항의 최소 개수를 저장할 dp 배열 생성 및 초기화
		int[] dp = new int[N+1];
		Arrays.fill(dp, (int)1e9);
		dp[0]= 0;
		
		// 제곱수 항의 최소 개수 구하기(DP 이용)
		for(int i=1; i<=N; i++) {
			// 1부터 N까지 제곱수 항의 최소 개수 갱신하기
			for(int j=1; j*j<=i; j++) {
				// i에서 i보다 같거나 작은 제곱수를 뺐을 때 그 수를 만드는데 
				// 필요한 제곱수 항의 최소 개수 + 1이  
				// 현재 저장 되어 있는 dp 배열의 값보다 작으면 갱신
				if(dp[i-j*j]+1 < dp[i]) {
					dp[i] = dp[i-j*j] + 1;
				}
			}
		}
		
		
		// 최종 결과 출력
		System.out.println(dp[N]);
	}
}