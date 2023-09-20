import java.util.*;
import java.io.*;

// BJ #4386 - 별자리 만들기
// Strategy: MST(Kruskal)

public class Main {
	static int N;
	static double E, min;
	static int[] parent, rank;
	static double[][] point;
	static Graph graph;
	
	// Union-Find
	public static void makeSet() {
		parent = new int[N+1];
		rank = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	public static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		
		// parent를 찾아낸 루트로 바꾸면 find 연산 수행시 중복되는 연산을 줄여줌
		// 재귀적인 구현 덕분에 u에서 root까지 올라가는 경로상에 있는 모든 노드들에 대해서도
		// 경로 압축 최적화가 자동으로 수행된다.
		parent[u] = find(parent[u]);
		return parent[u];
	}
	
	public static void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u==v) return;
		
		if(rank[u] > rank[v]) {
			// swap
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		parent[u] = v;
		
		if(rank[u] == rank[v]) rank[v]++;
	}

	
	// Edge + 비용 계산
	public static double getCost(int src, int dst) {
		return Math.sqrt((Math.pow(point[src][0]-point[dst][0], 2)+Math.pow(point[src][1]-point[dst][1], 2)));
	}
	
	public static class Edge implements Comparable<Edge>{
		int src;
		int dst;
		double cost;
		
		public Edge(int src, int dst) {
			this.src = src;
			this.dst = dst;
			this.cost = getCost(src,dst);
		}

		@Override
		public int compareTo(Edge o) {
			if(this.cost > o.cost) return 1;
			else if(this.cost == o.cost) return 0;
			else return -1;
		}
	}


	// 그래프 
	public static class Graph{
		PriorityQueue<Edge> pq;
		
		public Graph() {
			this.pq = new PriorityQueue<>();
		}
		
		public void pushEdge(int src, int dst) {
			pq.add(new Edge(src, dst));
		}
		
		public Edge getMinEdge() {
			return pq.poll();
		}
	}
	
	
	// 크루스칼
	public static void Kruskal() {
		int cnt = 0;
		while(cnt != N-1) {
			while(true) {
				Edge minEdge = graph.getMinEdge();
				int u = minEdge.dst;
				int v = minEdge.src;
//				System.out.println(u + " " + v + " " + minEdge.cost);
				
				if(find(u) != find(v)) {
					union(u,v);
					min += minEdge.cost;
					break;
				}
			}
			cnt++;
		}
	}
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        	
        	// N: 별의 개수
        	N = Integer.parseInt(br.readLine());
        	
        	// for Union-find
        	makeSet();
        	
        	// 별의 좌표 저장
        	point = new double[N+1][2];
        	for(int i=1; i<=N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		point[i][0] = Double.parseDouble(st.nextToken());
        		point[i][1] = Double.parseDouble(st.nextToken());
        	}
        	
        	
        	// 그래프 생성 및 Edge 생성
        	graph = new Graph();
        	for(int i=1; i<=N-1; i++) {
        		for(int j=i+1; j<=N; j++) {
        			graph.pushEdge(i, j);
        		}
        	}
        	
        	// 최소 비용을 구하기 위해 크루스칼 알고리즘 실행
        	min = 0;
        	Kruskal();
        	
        	// 결과 출력
        	System.out.printf("%.2f",min);
    }
}