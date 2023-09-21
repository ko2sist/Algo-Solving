import java.util.*;
import java.io.*;

// BJ #2098 - 외판원 순회
// Strategy: DP, TSP


public class Main {
	static final int INF = (int)1e9;
	static int N, END;
	static int[][] cost, dp;
	
	public static int TSP(int now, int visited) {
		// 모든 노드를 방문했을 때
		if(visited == END) {
			// 현재 노드에서 0번 노드로 가는 경로가 존재한다면
			if(cost[now][0] > 0) {
				return cost[now][0];	// 최소 비용 반환
			}
			
			return INF;	// 불가능한 경우에는 INF 반환
		}
		
		
		// 현재 상황을 이미 계산한 값이 존재한다면 그대로 사용
		if(dp[now][visited] != 0) return dp[now][visited];
		
		// 없다면 탐색 진행
		dp[now][visited] = INF;
		
		for(int i=0; i<N; i++) {
			// 현재 노드에서 i번 노드로 가는 경로가 없으면 continue
			if(cost[now][i] == 0) continue;
			
			// 이미 방문한 노드면 continue
			if((visited & (1<<i)) == (1<<i)) continue;
			
			// i반 노드 방문 처리 후 최소 비용 반환
			int temp = TSP(i, visited | 1<<i);
			dp[now][visited] = Math.min(dp[now][visited], cost[now][i] + temp);
		}
		
		// 최소 비용 반환
		return dp[now][visited];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		END = (1<<N) -1;
		
		cost = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][1 << N];
		
		System.out.println(TSP(0,1));
		
	}
}