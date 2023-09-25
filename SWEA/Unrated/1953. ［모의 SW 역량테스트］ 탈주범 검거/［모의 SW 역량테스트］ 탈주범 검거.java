import java.util.*;
import java.io.*;

// SWEA #1953 - 탈주범 검거
// Strategy: BFS

public class Solution {
	static int N,M,R,C,L,cnt;
	static int[][] map, res;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	R = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	L = Integer.parseInt(st.nextToken());
        	
        	map = new int[N][M];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<M; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	res = new int[N][M];
        	cnt = 0;
        	BFS();
        	
        	sb.append("#"+t+" ").append(cnt).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void BFS() {
    	Queue<Point> q = new ArrayDeque<>();
    	boolean[][] visited = new boolean[N][M];
    	
    	q.add(new Point(R,C));
    	visited[R][C] = true;
    	res[R][C] = 1;
    	
    	while(!q.isEmpty()) {
    		Point tmp = q.poll();
    		int tr = tmp.row;
    		int tc = tmp.col;
    		int tn = map[tr][tc];
    		int tt = res[tr][tc];
    		cnt++;
    		
    		if(tt >= L) continue;
    		
    		switch (tn) {
			case 1:
				for(int i=0; i<4; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					if(i==0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
					if(i==1 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;
					if(i==2 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
					if(i==3 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
					
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					res[nr][nc] = tt+1;
				}
				break;
				
			case 2:
				for(int i=0; i<3; i+=2) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					if(i==0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
					if(i==2 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
					
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					res[nr][nc] = tt+1;
				}
				break;
			case 3:
				for(int i=1; i<4; i+=2) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					if(i==1 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;
					if(i==3 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
					
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					res[nr][nc] = tt+1;
				}
				break;
			case 4:
				for(int i=0; i<2; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					if(i==0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
					if(i==1 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;
					
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					res[nr][nc] = tt+1;
				}
				break;
			case 5:
				for(int i=1; i<3; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					if(i==1 && (map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5)) continue;
					if(i==2 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
					
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					res[nr][nc] = tt+1;
				}
				break;
			case 6:
				for(int i=2; i<4; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					if(i==2 && (map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6)) continue;
					if(i==3 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
					
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					res[nr][nc] = tt+1;
				}
				break;
			case 7:
				for(int i=0; i<4; i+=3) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					if(i==0 && (map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7)) continue;
					if(i==3 && (map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7)) continue;
					
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					res[nr][nc] = tt+1;
				}
				break;
			default:
				break;
			}
    		
    	}
    }
    
    public static class Point{
    	int row;
    	int col;
    	
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
    }
}