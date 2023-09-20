import java.util.*;
import java.io.*;

// BJ #14938 - 서강그라운드
// Strategy: 플로이드-워셜 알고리즘

public class Main {
	static final int INF = (int)1e9;
	static int N,M,R;
	static int[] items;
	static int[][] graph, dist;
	
	public static class Node{
		int dest;
		int cost;
		
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
	
	public static void floyd() {
		dist = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) {
					dist[i][j] = 0;
				}else if(graph[i][j] != 0) {
					dist[i][j] = graph[i][j];
				}else {
					dist[i][j] = INF;
				}
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// items: 각 구역에 있는 사이템의 수
		items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		// 그래프 생성
		graph = new int[N+1][N+1];
		
		// 그래프 입력
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			graph[a][b] = c;
			graph[b][a] = c;
		}
		
		// 플로이드-워셜 실행
		floyd();
		
		
		// 최댓값 찾기
		int max = 0;
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) {
					sum += items[j];
				}else {
					if(dist[i][j] <= M) {
						sum += items[j];
					}
				}
			}
			
			if(sum > max) max = sum;
		}
		
		System.out.println(max);
	}
}