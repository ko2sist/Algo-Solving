import java.io.*;
import java.util.*;

// BJ #14442 - 벽 부수고 이동하기 2
// Strategy: BFS
public class Main {
	static int N,M,K;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	public static class Point{
		int row;
		int col;
		int wall;
		int dist;
		
		public Point(int row, int col, int wall, int dist) {
			this.row = row;
			this.col = col;
			this.wall = wall;
			this.dist = dist;
		}
	}
	
	public static int BFS() {
		Queue<Point> q = new ArrayDeque<>();
		
		q.add(new Point(0,0,0,1));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int tr = tmp.row;
			int tc = tmp.col;
			int td = tmp.dist;
			int tw = tmp.wall;
			
			if(tr == N-1 & tc == M-1) return td;
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
//				if(tw == K && map[nr][nc] == 1) continue;
				
				if(map[nr][nc] == 0) {
					if(visited[tw][nr][nc]) continue;
					q.add(new Point(nr,nc,tw,td+1));
					visited[tw][nr][nc] = true;
				}else {
					if(tw < K) {
						if(visited[tw+1][nr][nc]) continue;
						q.add(new Point(nr,nc,tw+1,td+1));
						visited[tw+1][nr][nc] = true;
					}else {
						continue;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		visited = new boolean[K+1][N][M];
		
		System.out.println(BFS());
		
	}

}