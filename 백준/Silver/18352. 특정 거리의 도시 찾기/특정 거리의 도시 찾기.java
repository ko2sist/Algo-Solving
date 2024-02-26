import java.io.*;
import java.util.*;

// BJ #18352 - 특정 거리의 도시 찾기
// Strategy: Dijkstra

public class Main {
	static final int INF = (int)1e9;
	static int N,M,K,X;
	static List<List<Integer>> graph;
	static int[] dist;
	
	public static class Pair implements Comparable<Pair>{
		int num;
		int cost;
		
		public Pair(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}
	
	public static void Dijkstra(int n) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		
		pq.add(new Pair(n,0));
		visited[n] = true;
		
		while(!pq.isEmpty()) {
			Pair tmp = pq.poll();
			
			int tn = tmp.num;
			int tc = tmp.cost;
			
			for(int node: graph.get(tn)) {
				if(dist[node] > tc + 1) {
					dist[node] = tc + 1;
					pq.add(new Pair(node, tc+1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 기본 정보 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 도시 간선 정보 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
		
		// 거리 배열 생성
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		// 다익스트라 실행
		Dijkstra(X);
		
		// 결과 저장
		boolean check = false;
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				sb.append(i).append("\n");
				check = true;
			}
		}
		
		// 최종 결과 출력
		if(check) {
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
	}
}