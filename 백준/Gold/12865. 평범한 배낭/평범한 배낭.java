import java.io.*;
import java.util.*;

// BJ #12865 - 평범한 배낭
// Strategy: DP - 0-1 knapsack problem
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] res = new int[N+1][K+1];
        
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int W = Integer.parseInt(st.nextToken());
        	int V = Integer.parseInt(st.nextToken());
        	
        	for(int j=1; j<=K; j++) {
        		if(W > j) {
        			res[i][j] = res[i-1][j];
        		}else {
        			res[i][j] = Math.max(res[i-1][j], V+res[i-1][j-W]);
        		}
        	}
        }

        // 최종 결과 출력
        System.out.print(res[N][K]);
    }
}