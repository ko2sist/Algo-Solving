import java.util.*;
import java.io.*;

// BJ #2638 - 치즈
// Strategy: BFS

// 외부 공기층 전체를 BFS로 찾아 표시, map 전체 순회하며
// 외부공기와 2칸이상 맞닿는 치즈 찾아 표시, 이후 치즈 녹이기
// 위의 과정 반복해서 모든 치즈가 녹으면 종료

public class Main {
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void findAir(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(new int[] {r,c});
		visited[r][c] = true;
		map[r][c] = 2;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 1 ) continue;
				
				q.add(new int[] {nr,nc});
				visited[nr][nc] = true;
				map[nr][nc] = 2;
 			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int total = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) total++;
			}
		}
		
	
		int fr = 0;
		int fc = 0;
		
		int time = 0;
		while(total > 0) {
			findAir(fr, fc);
			
			int melt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						int cnt = 0;
						for(int k=0; k<4; k++) {
							int nr = i+dr[k];
							int nc = j+dc[k];
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
							if(map[nr][nc] == 2) cnt++;
						}
						
						if(cnt >= 2) {
							map[i][j] = 3;		// 3 -> 현재 과정이 끝나고 녹을 치즈
							melt++;
							fr = i;
							fc = j;
						}
					}
				}
			}
			
			// 치즈 녹이기
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 3) map[i][j] = 2;
				}
			}
			
			total -= melt;
			time++;
			
		}
		
		System.out.println(time);
	}
}