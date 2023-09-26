import java.util.*;
import java.io.*;

// BJ #2573 - 빙산
// Strategy: BFS, 구현

public class Main {
	static int N,M,cnt,time;
	static int[][] map;
	static boolean[][] visited;
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
	public static void melt() {
		int[][] copy = new int[N][M];
		for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] != 0) {
        			int c = 0;
        			for(int k=0; k<4; k++) {
        				if(map[i+dr[k]][j+dc[k]] == 0) {
        					c++;
        				}
        			}
        			copy[i][j] = map[i][j]-c;
        			if(copy[i][j] < 0) copy[i][j] = 0;
        		}
        	}
        }
		map = copy;
	}
    
	public static void BFS(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		
		q.add(new Point(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int tr = tmp.row;
			int tc = tmp.col;
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(map[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
		}
		
		cnt++;
	}
    
	public static int getYear() {
		time = 1;
		
		while(true) {
			cnt = 0;
			melt();
			
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						BFS(i,j);
					}
				}
			}
			
			if(cnt >= 2) {
				return time;
			}else if(cnt == 0) {
				break;
			}
			
			time++;
		}
		
		return 0;
	}
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        System.out.println(getYear());
    }
}