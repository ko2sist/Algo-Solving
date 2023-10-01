import java.util.*;
import java.io.*;

// BJ #17142 - 연구소3
// Strategy: 구현

public class Main {
	static int N,M,total,size, minTime;
	static int[][] map;
	static List<Point> virus;
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
	
	public static void checkSubset(long selected) {
		boolean[][] visited = new boolean[N][N];
		Queue<Point> q = new ArrayDeque<>();
		int[][] res = new int[N][N];
		int t = 0;
		int cnt = 0;
		
		for(int i=0; i<size; i++) {
			if((selected & (1 << i)) == (1 << i)) {
				
				Point tmp = virus.get(i);
				q.add(tmp);
				visited[tmp.row][tmp.col] = true;
				res[tmp.row][tmp.col] = 0;
			}
		}

		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Point tmp = q.poll();
				int tr = tmp.row;
				int tc = tmp.col;
				
				if(res[tr][tc] > t && map[tr][tc] != 2) t = res[tr][tc];
				
				for(int i=0; i<4; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					if(map[nr][nc] == 1) continue;
					if(visited[nr][nc]) continue;
					
					q.add(new Point(nr,nc));
					visited[nr][nc] = true;
					res[nr][nc] = res[tr][tc]+1;
					
					if(map[nr][nc] == 0) cnt++;
				}
			}
		}
		
		if(cnt != total) return;
		
		minTime = Math.min(t, minTime);
	}
	
	public static void makeSubset(int num, int idx, long selected) {
		if(num == M) {
			checkSubset(selected);
			return;
		}

		if(M-num > size-idx) return;
		
		makeSubset(num, idx+1, selected);
		selected = selected | (1 << idx);
		makeSubset(num+1, idx+1, selected);
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        virus = new ArrayList<>();
        total = N*N;
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 2) {
        			virus.add(new Point(i,j));
        			total--;
        		}else if(map[i][j] == 1) {
        			total--;
        		}
        	}
        }
        size = virus.size();
        
        minTime = Integer.MAX_VALUE;
        makeSubset(0,0,0);
        
        if(minTime != Integer.MAX_VALUE) {
        	System.out.println(minTime);
        }else {
        	System.out.println(-1);
        }
    }
}