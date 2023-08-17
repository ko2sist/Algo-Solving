import java.io.*;
import java.util.*;

// BJ #10026 - 적록색약
// Strategy: BFS
public class Main {
	static int N;
	static char[][] color;
	static boolean[][] visited, visited_RG;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static class Point{
		int row;
		int columns;
		
		public Point(int row, int columns) {
			this.row = row;
			this.columns = columns;
		}
	}
	
	public static void BFS(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		char cc = color[r][c];
		
		q.add(new Point(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.columns + dc[i];
				
				if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;
				if(color[nr][nc] != cc) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
		}
	}
	
	public static void BFS_RG(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		char cc = color[r][c];
		
		q.add(new Point(r,c));
		visited_RG[r][c] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.columns + dc[i];
				
				if(nr <= 0 || nc <= 0 || nr > N || nc > N) continue;
				if(cc == 'B') {
					if(color[nr][nc] != cc) continue;
				}else {
					if(color[nr][nc] == 'B') continue;
				}
				if(visited_RG[nr][nc]) continue;
				
				q.add(new Point(nr,nc));
				visited_RG[nr][nc] = true;
			}
		}
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 변수 설정
        N = Integer.parseInt(br.readLine());
        
        color = new char[N+1][N+1];
        visited = new boolean[N+1][N+1];
        visited_RG = new boolean[N+1][N+1];
        
        
        // 색깔 정보 입력
        for(int i=1; i<=N; i++) {
        	String s = br.readLine();
        	for(int j=1; j<=N; j++) {
        		color[i][j] = s.charAt(j-1);
        	}
        }
        
        
        // 구역 개수 계산
        int res = 0;
        int res_RG = 0;
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		if(!visited[i][j]) {
        			BFS(i,j);
        			res++;
        		}
        		
        		if(!visited_RG[i][j]) {
        			BFS_RG(i,j);
        			res_RG++;
        		}
        	}
        }
        
        // 최종 결과 출력
        System.out.printf("%d %d", res, res_RG);
    }
}