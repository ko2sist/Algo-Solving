import java.util.*;
import java.io.*;

// BJ #2887 - 행성 터널
// Strategy: MST(Kruskal)


public class Main {
	static int N;
	static Point[] points, points_SX, points_SY, points_SZ;
	static PriorityQueue<Edge> pq;
	static int[] parent, rank;
	static long totalCost;
	
	public static void makeSet() {
		parent = new int[N];
		rank = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return;
		
		if(rank[x] > rank[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		parent[x] = y;
		
		if(rank[x] == rank[y]) rank[y]++;
	}
	
	public static class Point{
		int x;
		int y;
		int z;
		int num;
		
		public Point(int x, int y, int z, int num) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", z=" + z + ", num=" + num + "]";
		}
	}
	
	
	public static class Edge implements Comparable<Edge>{
		int src;
		int dst;
		long cost;
		
		public Edge(Point p1, Point p2) {
			this.src = p1.num;
			this.dst = p2.num;
			this.cost = Math.min(Math.min(Math.abs((long)p1.x-(long)p2.x), Math.abs((long)p1.y-(long)p2.y)), Math.abs((long)p1.z-(long)p2.z));
		}

		@Override
		public int compareTo(Edge o) {
			if(this.cost > o.cost) return 1;
			else if(this.cost == o.cost) return 0;
			else return -1;
		}

		@Override
		public String toString() {
			return "Edge [src=" + src + ", dst=" + dst + ", cost=" + cost + "]";
		}
	}
	
	public static void Kruskal() {
		int cnt = 0;
		while(cnt != N-1) {
			while(true) {
				Edge minEdge = pq.poll();
				int u = minEdge.src;
				int v = minEdge.dst;
				
				if(find(u) != find(v)) {
					union(u,v);
					totalCost += minEdge.cost;
					break;
				}
			}
			cnt++;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N: 행성 개수
		N = Integer.parseInt(br.readLine());
		
		// points: 행성 좌표 저장할 배열
		points = new Point[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(x,y,z,i);
		}
		
		// Edge 생성 및 저장
		pq = new PriorityQueue<>();
		
		points_SX = points.clone();
		points_SY = points.clone();
		points_SZ = points.clone();
		Arrays.sort(points_SX, (a,b)->a.x - b.x);
		Arrays.sort(points_SY, (a,b)->a.y - b.y);
		Arrays.sort(points_SZ, (a,b)->a.z - b.z);
		
		for(int i=0; i<N-1; i++) {
			pq.add(new Edge(points_SX[i], points_SX[i+1]));
			pq.add(new Edge(points_SY[i], points_SY[i+1]));
			pq.add(new Edge(points_SZ[i], points_SZ[i+1]));
		}
		
		
		// 크루스칼 알고리즘 실행
		totalCost = 0;
		makeSet();
		Kruskal();
		
		// 결과 출력
		System.out.println(totalCost);
	}
}