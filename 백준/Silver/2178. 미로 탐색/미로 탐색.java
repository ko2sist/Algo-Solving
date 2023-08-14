import java.util.*;
import java.io.*;

// BJ #2178 - 미로탐색
// Strategy: BFS
public class Main {
	static int N,M;
	static int[][] maze;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int depth;
	
	public static class Point{
		int row;
		int column;
		
		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	public static void BFS() {
		depth = 1;
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Point tmp = q.poll();
				
				for(int i=0; i<4; i++) {
					int nr = tmp.row + dr[i];
					int nc = tmp.column + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(maze[nr][nc] == 0) continue;
					if(visited[nr][nc]) continue;
					
					if(nr == N-1 && nc == M-1) {
						depth++;
						return;
					}
					q.add(new Point(nr,nc));
					visited[nr][nc] = true;
				}
			}
			depth++;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N,M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// maze: 미로 정보 저장하는 2차원 배열
		maze = new int[N][M];
		
		
		// 미로 정보 입력
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		// 최소 거리 계산
		BFS();
		
		// 최종 결과 출력
		System.out.println(depth);
	}
}
