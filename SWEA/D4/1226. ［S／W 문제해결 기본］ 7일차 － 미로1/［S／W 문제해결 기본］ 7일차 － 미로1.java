import java.util.*;
import java.io.*;

// SWEA #1226 - 미로1
// Strategy: DFS

public class Solution {
	static int r, c, res;
	static int[][] map;
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
	
	public static void dfs() {
		Stack<Point> s = new Stack<>();
		boolean[][] visited = new boolean[16][16];
		
		s.add(new Point(r,c));
		visited[r][c] = true;
		
		while(!s.isEmpty()) {
			Point tmp = s.pop();
			int tr = tmp.row;
			int tc = tmp.col;
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc]) continue;
				
				if(map[nr][nc] == 3) {
					res = 1;
					return;
				}
				
				s.add(new Point(nr, nc));
				visited[nr][nc] = true;
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=10; t++) {
        	int tc = Integer.parseInt(br.readLine());
        	map = new int[16][16];
        	
        	for(int i=0; i<16; i++) {
        		String s = br.readLine();
        		for(int j=0; j<16; j++) {
        			map[i][j] = Character.getNumericValue(s.charAt(j));
        			if(map[i][j] == 2) {
        				r = i;
        				c = j;
        			}
        		}
        	}
        	
        	res = 0;
        	dfs();

        	sb.append("#"+t).append(" ").append(res).append("\n");
        }
        
        System.out.println(sb);
    }
}