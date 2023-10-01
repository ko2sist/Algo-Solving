import java.util.*;
import java.io.*;

// BJ #2839 - 설탕배달
// Strategy: DP

public class Main {
	public static int INF = (int)1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1];
        
        for(int i=1; i<=N; i++) {
        	if(i-3 < 0) {
        		dp[i] = INF;
        	}else if(i-5 < 0) {
        		if(dp[i-3] != -1) {
        			dp[i] = dp[i-3] + 1;
        		}
        	}else {
        		dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        	}
        }
        
//        System.out.println(Arrays.toString(dp));
        if(dp[N] < INF) {
        	System.out.println(dp[N]);
        }else {
        	System.out.println(-1);
        }
        
    }
}