import java.io.*;
import java.util.*;

// BJ #5972 - 택배 배송
// Strategy: 다익스트라
public class Main {
	static final int INF = (int)1e9;
	static int N,M;
	static List<List<Pair>> graph;
	static int[] dist;
	
	public static class Pair implements Comparable<Pair>{
		int node;
		int cost;
		
		public Pair(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pair o) {
			return this.cost-o.cost;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N,M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 간선 정보 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(new Pair(B,C));
			graph.get(B).add(new Pair(A,C));
		}
		
		// 다익스트라 실행
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(1,0));
		
		while(!pq.isEmpty()) {
			Pair tmp = pq.poll();
			int tn = tmp.node;
			
			for(Pair pair : graph.get(tn)) {
				if(dist[pair.node] > dist[tn] + pair.cost) {
					dist[pair.node] = dist[tn] + pair.cost;
					
					pq.add(new Pair(pair.node, dist[pair.node]));
				}
			}
		}
		
		// 최종결과 출력
		System.out.println(dist[N]);
		
	}

}