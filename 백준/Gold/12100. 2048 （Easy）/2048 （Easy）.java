import java.util.*;
import java.io.*;

// BJ #12100 - 2048(easy)
// Strategy: 백트래킹
public class Main {
	static int N,res;
	public static class Map{
		int[][] map;
		int max;
		
		public Map(int[][] map, int max) {
			this.map = map;
			this.max = max;
		}
		
		public Map Up() {
			int[][] res_map = new int[N][N];
			int res_max = 0;
			
			for(int i=0; i<N; i++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int j=0; j<N; j++) {
					if(map[j][i] != 0) {
						q.add(map[j][i]);
					}
				}
				
				int idx = 0;
				while(!q.isEmpty()) {
					int tmp = q.poll();
					if(!q.isEmpty() && tmp == q.peek()) {
						tmp += q.poll();	
					}
					res_map[idx][i] = tmp;
					if(tmp > res_max) res_max = tmp;
					idx++;
				}
				
				for(int j=idx; j<N; j++) {
					res_map[j][i] = 0;
				}
			}
			return new Map(res_map, res_max);
		}
		
		public Map Down() {
			int[][] res_map = new int[N][N];
			int res_max = 0;
			
			for(int i=0; i<N; i++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int j=N-1; j>=0; j--) {
					if(map[j][i] != 0) {
						q.add(map[j][i]);
					}
				}
				
				int idx = N-1;
				while(!q.isEmpty()) {
					int tmp = q.poll();
					if(!q.isEmpty() && tmp == q.peek()) {
						tmp += q.poll();	
					}
					res_map[idx][i] = tmp;
					if(tmp > res_max) res_max = tmp;
					idx--;
				}
				
				for(int j=idx; j>=0; j--) {
					res_map[j][i] = 0;
				}
			}
			return new Map(res_map, res_max);
		}
		
		public Map Left() {
			int[][] res_map = new int[N][N];
			int res_max = 0;
			
			for(int i=0; i<N; i++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int j=0; j<N; j++) {
					if(map[i][j] != 0) {
						q.add(map[i][j]);
					}
				}
				
				int idx = 0;
				while(!q.isEmpty()) {
					int tmp = q.poll();
					if(!q.isEmpty() && tmp == q.peek()) {
						tmp += q.poll();	
					}
					res_map[i][idx] = tmp;
					if(tmp > res_max) res_max = tmp;
					idx++;
				}
				
				for(int j=idx; j<N; j++) {
					res_map[i][j] = 0;
				}
			}
			return new Map(res_map, res_max);
		}
		
		public Map Right() {
			int[][] res_map = new int[N][N];
			int res_max = 0;
			
			for(int i=0; i<N; i++) {
				Queue<Integer> q = new ArrayDeque<>();
				for(int j=N-1; j>=0; j--) {
					if(map[i][j] != 0) {
						q.add(map[i][j]);
					}
				}
				
				int idx = N-1;
				while(!q.isEmpty()) {
					int tmp = q.poll();
					if(!q.isEmpty() && tmp == q.peek()) {
						tmp += q.poll();	
					}
					res_map[i][idx] = tmp;
					if(tmp > res_max) res_max = tmp;
					idx--;
				}
				
				for(int j=idx; j>=0; j--) {
					res_map[i][j] = 0;
				}
			}
			return new Map(res_map, res_max);
		}
		
	}
	
	
	public static void Game(Map map, int num) {
		int max = map.max;
		if(num == 5) {	// 최대 5회
			if(max > res) res = max;
			return;
		}
		
		if(res != 0 && max <= (res/(int)Math.pow(2, 5-num))) {	// 앞으로 더 진행해도 현재 최대 값 이상을 만들 수 없을 경우 진행x
			return;
		}
		
		Game(map.Up(), num+1);
		Game(map.Down(), num+1);
		Game(map.Left(), num+1);
		Game(map.Right(), num+1);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int max = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp > max) max = tmp;
			}
		}
		
		res = 0;
		
		Game(new Map(map, max), 0);
		
		System.out.println(res);
	}
}