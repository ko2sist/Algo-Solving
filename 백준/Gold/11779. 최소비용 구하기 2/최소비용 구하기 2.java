import java.util.*;
import java.io.*;

// BJ #11779 - 최소비용 구하기2
// Strategy: Dijkstra
public class Main {
	static List<List<Pair>> graph;
	static int N, M;
	static long INF = Long.MAX_VALUE;
	static int[] parents;

	public static class Pair implements Comparable<Pair> {
		int num;
		long dist;

		public Pair(int num, long dist) {
			this.num = num;
			this.dist = dist;
		}

		public int compareTo(Pair o) {
			if (this.dist > o.dist)
				return 1;
			else if (this.dist == o.dist)
				return 0;
			else
				return -1;
		}
	}

	public static long dijkstra(int start, int dest) {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[start] = 0;
		pq.add(new Pair(start, 0));

		while (!pq.isEmpty()) {
			Pair tmp = pq.poll();
			int tn = tmp.num;
			long td = tmp.dist;
			
			if(dist[tn] < td) continue;
			
			for (Pair adj: graph.get(tn)) {
				long check = td + adj.dist;
				if (dist[adj.num] > check) {
					parents[adj.num] = tn;
					dist[adj.num] = check;
					pq.add(new Pair(adj.num, check));
				}

			}
		}

		return dist[dest];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(s).add(new Pair(d,c));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		sb.append(dijkstra(start, dest)).append("\n");
		Stack<Integer> s = new Stack<>();
		
		s.add(dest);
		while(true) {
			if(dest == start) break;
			s.add(parents[dest]);
			dest = parents[dest];
		}
		
		sb.append(s.size()).append("\n");
		while(!s.isEmpty()) {
			sb.append(s.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}