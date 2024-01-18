import java.io.*;
import java.util.*;

// BJ #2293 - 동전1
// Strategy: DP

public class Main {
	static final int INF = (int)1e9;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n,k 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// dp 배열 생성
		int[] dp = new int[k+1];
		dp[0] = 1;	// 아무 동전도 고르지 않았을 경우를 위해 index 0에 1저장
		
		// 동전 입력, 오름차순 정렬
		List<Integer> coins = new ArrayList<>();
		for(int i=0; i<n; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(coins);
		
		// dp
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j >= coins.get(i)) {
					dp[j] += dp[j-coins.get(i)];
				}
			}
		}
		
		// 최종 결과 출력
		System.out.println(dp[k]);
		
	}
}