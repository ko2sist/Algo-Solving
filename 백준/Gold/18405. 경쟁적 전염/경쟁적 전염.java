import java.io.*;
import java.util.*;

// BJ #18405 - 경쟁적 전염
// Strategy: 

public class Main {
	static int N,K,S,X,Y;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Point> pq;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static class Point implements Comparable<Point>{
		int row;
		int col;
		int num;
		
		public Point(int row, int col, int num) {
			this.row = row;
			this.col = col;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			return this.num - o.num;
		}
	}
	
	public static void spread() {
		int time = 0;
		
		while(time < S) {
			int size = pq.size();
			PriorityQueue<Point> tmp_pq = new PriorityQueue<>();
			
			while(size-- > 0) {
				Point tmp = pq.poll();
				
				for(int i=0; i<4; i++) {
					int nr = tmp.row + dr[i];
					int nc = tmp.col + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					if(map[nr][nc] != 0) continue;
					
					map[nr][nc] = tmp.num;
					tmp_pq.add(new Point(nr, nc, tmp.num));
					
				}
			}
			
			time++;
			pq = tmp_pq;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N,K 입력
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 맵 정보 입력
		map = new int[N][N];
		pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					pq.add(new Point(i,j,map[i][j]));
				}
			}
		}
		
		// S,X,Y 입력
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		// 바이러스 확산 
		spread();
		
		
		
		// 결과 출력
		System.out.println(map[X-1][Y-1]);
	}
}