import java.io.*;
import java.util.*;

// BJ #14716 - 현수막
// Strategy: BFS
public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void BFS(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		
		visited[r][c] = true;
		q.add(new Point(r,c));
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int tr = tmp.row;
			int tc = tmp.col;
			
			for(int i=0; i<8; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
						
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 0) continue;
				
				q.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[M][N];
		int result = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					BFS(i,j);
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}