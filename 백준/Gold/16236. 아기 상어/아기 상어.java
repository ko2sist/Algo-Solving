import java.util.*;
import java.io.*;

// BJ #16236 - 아기 상어
// Strategy: BFS

public class Main {
	static int N, r, c, size, time, cnt, tt;
	static int[] fish;
	static int[][] space;
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void BFS() {
		int rr = N;
		int cc = N;
		tt = Integer.MAX_VALUE;
		
		int[][] t = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<Integer> q_x = new LinkedList<>();
		Queue<Integer> q_y = new LinkedList<>();
		q_x.add(r);
		q_y.add(c);
		visited[r][c] = true;
		t[r][c] = 0;
		
		while(!q_x.isEmpty()) {
			int tr = q_x.poll();
			int tc = q_y.poll();
			
			if(t[tr][tc] >= tt) {
				break;
			}
			
				
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || space[nr][nc] > size) {
					continue;
				}
					
				if(visited[nr][nc]) continue;
				
				if(space[nr][nc] != 0 && space[nr][nc] < size) {
					if(nr < rr) {
						rr = nr;
						cc = nc;
						tt = t[tr][tc] + 1;
					}else if(nr == rr) {
						if(nc < cc) {
							rr = nr;
							cc = nc;
							tt = t[tr][tc] + 1;
						}
					}
					continue;
				}
					
				q_x.add(nr);
				q_y.add(nc);
				visited[nr][nc] = true;
				t[nr][nc] = t[tr][tc] + 1;
			}
		}
		
		if(tt != Integer.MAX_VALUE) {
			r = rr;
			c = cc;
			cnt++;
			fish[space[rr][cc]]--;
			space[rr][cc] = 0;
			if(cnt == size) {
				size++;
				cnt = 0;
			}
			time += tt;
		}
		
		
		
	}
	
	public static void Eat() {
		time = 0;
		size = 2;
		cnt = 0;
		
		while(true) {
			int num = 0;
			if(size < 7) {
				for(int i=1; i<size; i++) {
					num += fish[i];
				}
			}else {
				for(int i=1; i<7; i++) {
					num += fish[i];
				}
			}
			
			
			if(num == 0) break;
			
			BFS();
			
			if(tt == Integer.MAX_VALUE) break;
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		space = new int[N][N];
		
		fish = new int[7];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == 9) {
					r = i;
					c = j;
					space[i][j] = 0;
				}else if(space[i][j] != 0) {
					fish[space[i][j]]++;
				}
			}
		}

		Eat();
		
		// 최종 결과 출력
		System.out.println(time);
	}
}