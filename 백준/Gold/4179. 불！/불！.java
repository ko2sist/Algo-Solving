import java.io.*;
import java.util.*;

// BJ #4179 - 불;
// Strategy: BFS


public class Main {
	static int R,C;
	static int jr,jc;
	static char[][] map;
	static Queue<Point> fire;
	static boolean[][][] visited;
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
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(jr,jc));
		
		visited[0][jr][jc] = true;
		
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			int size_f = fire.size();
			time++;
			
			while(size_f-->0) {
				Point tmp = fire.poll();
				int tr = tmp.row;
				int tc = tmp.col;
				
				for(int i=0; i<4; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;	// 범위를 벗어난 경우
					if(visited[1][nr][nc]) continue;	// 이미 불이 퍼진 경우
					if(map[nr][nc] == '#') continue;	// 벽일 경우
						
					fire.add(new Point(nr,nc));
					visited[1][nr][nc] = true;
				}
			}
			
			while(size-->0) {
				Point tmp = q.poll();
				int tr = tmp.row;
				int tc = tmp.col;
								
				for(int i=0; i<4; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) return time;	// 범위를 벗어난 경우 => 탈출 가능
					if(visited[0][nr][nc] || visited[1][nr][nc]) continue;	// 이미 지나온 점이거나, 불이 퍼진 점일 경우
					if(map[nr][nc] == '#') continue;	// 벽일 경우
										
					q.add(new Point(nr,nc));
					visited[0][nr][nc] = true;
				}
			}
		}
		
		// 탈출하지 못하는 경우
		return -1;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		fire = new ArrayDeque<>();
		visited = new boolean[2][R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'J') {
					jr = i;
					jc = j;
				} else if(map[i][j] == 'F') {
					fire.add(new Point(i,j));
					visited[1][i][j] = true;
				}
			}
		}
		
		int result = BFS();
		
		if(result == -1) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(result);
		}
	}
}