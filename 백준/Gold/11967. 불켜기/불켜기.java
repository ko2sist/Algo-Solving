import java.io.*;
import java.util.*;

// BJ #11967 - 불켜기
// Strategy: BFS
public class Main {
	static int N, M, result;
	static boolean[][] light, visited;
	static List<Point>[][] on; 
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static int BFS() {
		int result = 1;
		
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		
		q.add(new Point(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int tr = tmp.row;
			int tc = tmp.col;
			
			// 현재 방문한 방에서 켤 수 있는 불을 다 킨다.
			for(Point p : on[tr][tc]) {
				if(!light[p.row][p.col]) {
					light[p.row][p.col] = true;
					result++;
					
					// 불을 킨 방의 동서남북에 이미 방문한 방이 있으면 queue에 넣는다.
					for(int i=0; i<4; i++) {
						int nr = p.row + dr[i];
						int nc = p.col + dc[i];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
						if(visited[nr][nc]) {
							q.add(new Point(p.row, p.col));
							visited[p.row][p.col] = true;
							break;
						}
						
					}
				}
			}
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if(!light[nr][nc]) continue;
				
				q.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		light = new boolean[N][N];
		light[0][0] = true;
		
		on = new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				on[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			on[x-1][y-1].add(new Point(a-1,b-1));
		}
		
		System.out.println(BFS());
		
	}
}