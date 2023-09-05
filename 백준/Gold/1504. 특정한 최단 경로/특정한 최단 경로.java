import java.util.*;
import java.io.*;

// BJ #1504 - 특정한 최단 경로
// Strategy: Dijkstra

public class Main {
	static int N, E, v1, v2, min;
	static int[][] graph;
	static final int INF = (int)1e9;
	static int[] dist;
	
	public static class Node implements Comparable<Node>{
		int num;
		int dist;
		
		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if(this.dist == o.dist) {
				return this.num - o.num;
			}
			return this.dist - o.dist;
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist = new int[N+1];
		for(int i=1; i<=N; i++) {
			dist[i] = INF;
		}
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			for(int i=1; i<=N; i++) {
				if(graph[tmp.num][i] != 0) {
					if(dist[i] > dist[tmp.num] + graph[tmp.num][i]) {
						dist[i] = dist[tmp.num] + graph[tmp.num][i];
						pq.add(new Node(i, dist[i]));
					}
				}
			}
		}
		
	}
	
	public static void find() {
		dijkstra(v1);
		
		int v12 = dist[v2];
		if(v12 == INF) {
			min = -1; 
			return;
		}
		
		dijkstra(1);
		
		int dist11 = dist[v1];
		int dist12 = dist[v2];	
		
		dijkstra(N);
		
		int distN1 = dist[v1];
		int distN2 = dist[v2];
		
		if(dist11 == INF && dist12 == INF) {
			min = -1;
			return;
		}
		
		if(distN1 == INF && distN2 == INF) {
			min = -1;
			return;
		}
		
//		if(dist11 == INF && distN2 == INF) {
//			min = dist12+v12+distN1;
//		}
//		
//		if(dist12 == INF && distN1 == INF) {
//			min = dist11+v12+distN2;
//		}
		
		min = Math.min(dist11+v12+distN2, dist12+v12+distN1);
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = c;
			graph[b][a] = c;
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		
		min = 0;
		
		
		find();
		
		System.out.println(min);
		
	}
}