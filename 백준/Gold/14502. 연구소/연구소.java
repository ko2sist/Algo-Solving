import java.util.*;
import java.io.*;

// BJ #14502 - 연구소
// Strategy: BFS + 백트래킹
public class Main {
	static int N,M;
	static int[][] lab;
	static List<Point> virus;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int max;
	
	public static class Point{
		int row;
		int column;
		
		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	public static void BFS() {
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			map[i] = lab[i].clone();
		}
		
		Queue<Point> q = new LinkedList<>();
		
		for(Point v : virus) {
			q.add(v);
		}
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.column + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(map[nr][nc] == 2 || map[nr][nc] == 1) continue;
				
				q.add(new Point(nr, nc));
				map[nr][nc] = 2;
			}
		}

		
		int res = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) res++;
			}
		}
		
		if(res > max) {
			max = res;
		}
	}
	
	
	public static void GetSafe(int num) {
		if(num == 3) {
			BFS();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(lab[i][j] == 0) {
					lab[i][j] = 1;
					GetSafe(num+1);
					lab[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		virus = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				lab[i][j] = tmp;
				if(tmp == 2) {
					virus.add(new Point(i,j));
				}
			}
		}

		max = 0;
		
		GetSafe(0);
		
		System.out.println(max);
	}
}