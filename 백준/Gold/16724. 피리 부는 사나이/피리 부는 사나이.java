import java.util.*;
import java.io.*;

// BJ #16724 - 피리부는 사나이
// Strategy: DFS, 분리집합

public class Main {
	static int N,M, cnt;
	static int NM;
	static int[] parent, rank;
	static boolean[][] visited;
	static Node[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Node[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				int dir = 0;
				switch(s.charAt(j)) {
					case 'U':
						dir = 0;
						break;
					case 'R':
						dir = 1;
						break;
					case 'D':
						dir = 2;
						break;
					case 'L':
						dir = 3;
						break;
					default:
				}
				map[i][j] = new Node(i,j,i*M+(j+1), dir);
			}
		}
		
		makeSet();
		cnt = 0;
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					DFS(i,j);
				}
			}
		}
		
		System.out.println(cnt);
    }
	
	public static void DFS(int row, int col) {
		Stack<Node> stack = new Stack<>();
		
		stack.add(map[row][col]);
		visited[row][col] = true;
		
		while(!stack.isEmpty()) {
			Node tmp = stack.pop();
			int dir = tmp.dir;
			
			int nr = tmp.row + dr[dir];
			int nc = tmp.col + dc[dir];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(visited[nr][nc]) {
				if(find(tmp.num) == find(map[nr][nc].num)) {
					cnt++;
				}
				continue;
			}
			
			stack.add(map[nr][nc]);
			visited[nr][nc] = true;
			union(tmp.num, map[nr][nc].num);
			
		}
	}
	
	public static void makeSet() {
		NM = N*M;
		parent = new int[NM+1];
		rank = new int[NM+1];
		for(int i=1; i<=NM; i++) {
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
		
		if(x==y) return;
		
		if(rank[x] > rank[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		parent[x] = y;
		
		if(rank[x] == rank[y]) rank[y]++;
	}
	
	public static class Node{
		int row;
		int col;
		int num;
		int dir;
		
		public Node(int row, int col, int num, int dir) {
			this.row = row;
			this.col = col;
			this.num = num;
			this.dir = dir;
		}
	}
}