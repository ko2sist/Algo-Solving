import java.util.*;
import java.io.*;

// BJ #16118 - 달빛 여우
public class Main {
	static final int INF = (int)1e9;
	static int N,M;
	static List<List<Edge>> graph;
	static int[] dist_fox, dist_wolf_fast, dist_wolf_slow;
	
	public static class Edge{
		int node;
		int cost;
		
		public Edge(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	
	public static class Pair implements Comparable<Pair>{
		int node;
		int dist;
		boolean fast;
		
		public Pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
		
		public Pair(int node, int dist, boolean fast) {
			this.node = node;
			this.dist = dist;
			this.fast = fast;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dist - o.dist;
		}
	}
	
	public static void dijkstra() {
		PriorityQueue<Pair> pq_fox = new PriorityQueue<>();
		PriorityQueue<Pair> pq_wolf = new PriorityQueue<>();
		
		// 여우 
		pq_fox.add(new Pair(1,0));
		dist_fox[1] = 0;
		while(!pq_fox.isEmpty()) {
			Pair tmp = pq_fox.poll();
			
			if(dist_fox[tmp.node] < tmp.dist) continue;
			
			for(Edge e : graph.get(tmp.node)) {
				int cal = tmp.dist + e.cost*2;
				if(dist_fox[e.node] > cal) {
					dist_fox[e.node] = cal;
					pq_fox.add(new Pair(e.node, cal));
				}
			}
		}
		
		// 늑대
		pq_wolf.add(new Pair(1,0, true));
		dist_wolf_slow[1] = 0;
		while(!pq_wolf.isEmpty()) {
			Pair tmp = pq_wolf.poll();
			
			if(tmp.fast) {
				if(dist_wolf_slow[tmp.node] < tmp.dist) continue;
			}else {
				if(dist_wolf_fast[tmp.node] < tmp.dist) continue;
			}
			
			if(tmp.fast) {	// 지금 가는 오솔길을 빠르게 이동
				for(Edge e : graph.get(tmp.node)) {
					int cal = tmp.dist + e.cost;
					if(dist_wolf_fast[e.node] > cal) {
						dist_wolf_fast[e.node] = cal;
						pq_wolf.add(new Pair(e.node, cal, false));
					}
				}
			}else {			// 지금 가는 오솔길을 느리게 이동
				for(Edge e : graph.get(tmp.node)) {
					int cal = tmp.dist + e.cost*4;
					if(dist_wolf_slow[e.node] > cal) {
						dist_wolf_slow[e.node] = cal;
						pq_wolf.add(new Pair(e.node, cal, true));
					}
				}
			}
		}
	}
	
	public static void getDist() {
		dist_fox = new int[N+1];
		dist_wolf_fast = new int[N+1];
		dist_wolf_slow = new int[N+1];
		Arrays.fill(dist_fox, INF);
		Arrays.fill(dist_wolf_fast, INF);
		Arrays.fill(dist_wolf_slow, INF);
		
		dijkstra();
	}
	
	public static int getRes() {
		int res = 0;
		for(int i=2; i<=N; i++) {
			if(dist_fox[i] < Math.min(dist_wolf_fast[i], dist_wolf_slow[i])) res++;
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Edge(b,c));
			graph.get(b).add(new Edge(a,c));
		}
		
		getDist();
//		System.out.println(Arrays.toString(dist_fox));
//		System.out.println(Arrays.toString(dist_wolf_fast));
//		System.out.println(Arrays.toString(dist_wolf_slow));
		
		System.out.println(getRes());
	}
}
