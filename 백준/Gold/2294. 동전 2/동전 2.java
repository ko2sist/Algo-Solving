import java.util.*;
import java.io.*;

// BJ #2294 - 동전2
// Strategy: DP

public class Main {
	static int N,K;
	static int[] dp;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        Set<Integer> coin_set = new HashSet<>();
        for(int i=0; i<N; i++) {
        	coin_set.add(Integer.parseInt(br.readLine()));
        }
        
        List<Integer> coins = new ArrayList<>(coin_set);
        
        dp = new int[K+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i=1; i<=K; i++) {
        	for(int j=0; j<coins.size(); j++) {
        		int c = coins.get(j);
        		if(i >= c) {
        			dp[i] = Math.min(dp[i], dp[i-c] + 1);
        		}
        	}
        }
        
        if(dp[K] >= INF) {
        	System.out.println(-1);
        }else {
        	System.out.println(dp[K]);
        }
        
    }
}