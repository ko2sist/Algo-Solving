import java.util.*;
import java.io.*;

// BJ #1753 - 최단경호
// Strategy:  Dijkstra
public class Main {
	static List<List<Node>> map;
	static int[] dist;
	
	public static class Node implements Comparable<Node>{
		int dist;
		int num;
		int uid;
		
		public Node(int dist, int num, int uid) {
			this.dist = dist;
			this.num = num;
			this.uid = uid;
		}
		
		public int compareTo(Node o) {
			if(this.dist != o.dist) {
				return this.dist - o.dist;
			}else {
				return this.uid - o.uid;
			}
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int uid = 0;
		dist[start] = 0;
		pq.add(new Node(0, start, uid++));
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			for(Node adj: map.get(tmp.num)) {
				if(dist[adj.num] > tmp.dist + adj.dist) {
					dist[adj.num] = tmp.dist + adj.dist;
					pq.add(new Node(tmp.dist + adj.dist, adj.num, uid++));
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		map = new ArrayList<>();
		dist = new int[V+1];
		
		for(int i=0; i<=V; i++) {
			map.add(new ArrayList<>());
		}
		
		for(int i=1; i<=V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map.get(u).add(new Node(w,v,1));
		}
		
		dijkstra(K);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			}else {
				sb.append(dist[i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
