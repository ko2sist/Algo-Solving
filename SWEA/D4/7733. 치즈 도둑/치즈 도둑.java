import java.util.*;
import java.io.*;

// SWEA #7733 - 치즈 도둑
// Strategy: BFS

public class Solution {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(cheese[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	N = Integer.parseInt(br.readLine());
        	
        	cheese = new int[N][N];
        	for(int i=0; i<N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			cheese[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int max = 0;
        	
        	
        	for(int day=0; day<=100; day++) {
        		visited = new boolean[N][N];
        		int group = 0;

        		for(int i=0; i<N; i++) {
        			for(int j=0; j<N; j++) {
        				if(cheese[i][j] == day) {
        					cheese[i][j] = 0;
        				}
        			}
        		}
        		
        		for(int i=0; i<N; i++) {
        			for(int j=0; j<N; j++) {
        				if(cheese[i][j] != 0 && !visited[i][j]) {
        					bfs(i,j);
        					group++;
        				}
        			}
        		}
        		
        		if(group > max) max = group;
        		if(group == 0) break;
        	}

        	sb.append("#"+t).append(" ").append(max).append("\n");
        }
        
        System.out.println(sb);
    }
}