import java.util.*;
import java.io.*;

// BJ #20040 - 사이클 게임
// Strategy: 분리집합


public class Main {
	static int N;
	static int[] parent, rank;
	
	public static void makeSet() {
		parent = new int[N];
		rank = new int[N];
		for(int i=0; i<N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return;
		
		if(rank[x] > rank[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		parent[x] = y;
		
		if(rank[x] == rank[y]) rank[y]++;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		int idx = 0;
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			if(idx == 0) {
				if(find(x) == find(y)) {	// 사이클 형성
					idx = i;
				}
				union(x,y);
			}
			
		}
		
		System.out.println(idx);
	}
}