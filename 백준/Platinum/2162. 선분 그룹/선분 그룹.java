import java.util.*;
import java.io.*;

// BJ #2162 - 선분 그룹
// Strategy: CCW, 분리집합


public class Main {
	static int N;
	static int[] parent, rank;
	static Line[] lines;
	
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
	
	public static class Point implements Comparable<Point>{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			return this.x-o.x;
		}

	}
	
	public static class Line{
		Point p1;
		Point p2;
		
		public Line(int x1, int y1, int x2, int y2) {
			this.p1 = new Point(x1, y1);
			this.p2 = new Point(x2, y2);
		}

	}

	public static int CCW(Point p1, Point p2, Point p3) {
		int S = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y)
				-(p2.x*p1.y + p3.x*p2.y + p1.x*p3.y);
		
		if(S>0) return 1;
		else if (S == 0) return 0;
		else return -1;
	}
	
	public static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
		int check1 = CCW(p1, p2, p3) * CCW(p1, p2, p4);
		int check2 = CCW(p3, p4, p1) * CCW(p3, p4, p2);
		
		// 두 직선이 일직선 상에 존재
		if(check1 == 0 && check2 == 0) {
			if(p1.compareTo(p2) > 0) {
				int tx = p1.x;
				int ty = p1.y;
				p1 = p2;
				p2 = new Point(tx,ty);
			}
			
			if(p3.compareTo(p4) > 0) {
				int tx = p3.x;
				int ty = p3.y;
				p3 = p4;
				p4 = new Point(tx,ty);
			}
			
			return p2.compareTo(p3) >= 0 && p4.compareTo(p1) >= 0;
		}
		
		return check1 <= 0 && check2 <= 0;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N: 선분 개수
		N = Integer.parseInt(br.readLine());
		
		// 선분 정보 입력
		lines = new Line[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			lines[i] = new Line(x1,y1,x2,y2);
		}
		
		makeSet();
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(isIntersect(lines[i].p1, lines[i].p2, lines[j].p1, lines[j].p2)) {
					union(i,j);
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		int[] cnt = new int[N];
		for(int i=0; i<N; i++) {
			int p = find(i);
			set.add(p);
			cnt[p]++;
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			if(cnt[i] > max) max = cnt[i];
		}
		
		System.out.println(set.size());
		System.out.println(max);
		
	}
}