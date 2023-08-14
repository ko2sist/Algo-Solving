import java.util.*;
import java.io.*;

// BJ #2667 - 단지번호붙이기
// Strategy: BFS
public class Main {
	static int N;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	public static class Point{
		int row;
		int column;
		
		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	public static int BFS(Point p) {
		int num = 1;
		Queue<Point> q = new LinkedList<>();
		
		q.add(p);
		visited[p.row][p.column] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.column + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == '0' || visited[nr][nc]) continue;
				
				q.add(new Point(nr,nc));
				visited[nr][nc] = true;
				num++;
			}
		}
		
		return num;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N: 지도의 크기
		N = Integer.parseInt(br.readLine());
		
		// 
		map = new char[N][N];
		visited = new boolean[N][N];
		
		// 지도 정보 입력
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		// BFS 실행, 단지 탐색
		PriorityQueue<Integer> res = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					res.add(BFS(new Point(i,j)));
				}
			}
		}
		
		// 결과 저장
		sb.append(res.size()).append("\n");
		while(!res.isEmpty()) {
			sb.append(res.poll()).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
