import java.util.*;
import java.io.*;

// BJ #15683 - 감시
// Strategy: 
public class Main {
	static int N,M,min,size;
	static List<Point> cctv;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] num_cctv;
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static int cal(int[] selected) {
		int res = 0;
		char[][] copy = new char[N][M];
		for(int i=0; i<N; i++) {
			copy[i] = map[i].clone();
		}
		
		for(int i=0; i<size; i++) {
			int cn = num_cctv[i];
			Point tmp = cctv.get(i);
			int r = tmp.row;
			int c = tmp.col;
			int dir = selected[i];
			
			if(cn == 1) {
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				while(nr >= 0 && nc >= 0 && nr < N && nc < M && copy[nr][nc] != '6') {
					if(copy[nr][nc] == '0') {
						copy[nr][nc] = '#';
					}
					nr += dr[dir];
					nc += dc[dir];
				}
			}else if(cn == 2) {
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				while(nr >= 0 && nc >= 0 && nr < N && nc < M && copy[nr][nc] != '6') {
					if(copy[nr][nc] == '0') {
						copy[nr][nc] = '#';
					}
					nr += dr[dir];
					nc += dc[dir];
				}
				
				nr = r-dr[dir];
				nc = c-dc[dir];
				while(nr >= 0 && nc >= 0 && nr < N && nc < M && copy[nr][nc] != '6') {
					if(copy[nr][nc] == '0') {
						copy[nr][nc] = '#';
					}
					nr -= dr[dir];
					nc -= dc[dir];
				}
			}else if(cn == 3) {
				for(int j=0; j<2; j++) {
					dir = (dir+j)%4;
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					while(nr >= 0 && nc >= 0 && nr < N && nc < M && copy[nr][nc] != '6') {
						if(copy[nr][nc] == '0') {
							copy[nr][nc] = '#';
						}
						nr += dr[dir];
						nc += dc[dir];
					}
				}
			}else if(cn == 4) {
				for(int j=0; j<3; j++) {
					dir = (dir+j)%4;
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					while(nr >= 0 && nc >= 0 && nr < N && nc < M && copy[nr][nc] != '6') {
						if(copy[nr][nc] == '0') {
							copy[nr][nc] = '#';
						}
						nr += dr[dir];
						nc += dc[dir];
					}
				}
			}else {
				for(int j=0; j<4; j++) {
					int nr = r+dr[j];
					int nc = c+dc[j];
					while(nr >= 0 && nc >= 0 && nr < N && nc < M && copy[nr][nc] != '6') {
						if(copy[nr][nc] == '0') {
							copy[nr][nc] = '#';
						}
						nr += dr[j];
						nc += dc[j];
					}
				}
			}
		}
		
//		for(char[] line : copy) {
//			System.out.println(Arrays.toString(line));
//		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j] == '0') res++;
			}
		}
		
		return res;
	}
	
	public static void back(int len, int[] selected) {
		if(len == size) {
//			System.out.println(Arrays.toString(num_cctv));
//			System.out.println(Arrays.toString(selected));
			int tmp = cal(selected);
			if(tmp < min) min = tmp;
			return;
		}
		
		Point tmp = cctv.get(len);
		int tr = tmp.row;
		int tc = tmp.col;
		
		if(map[tr][tc] == '1') {
			for(int i=0; i<4; i++) {
				selected[len] = i;
				back(len+1, selected);
			}
			
		}else if(map[tr][tc] == '2') {
			for(int i=0; i<2; i++) {
				selected[len] = i;
				back(len+1, selected);
			}
		}else if(map[tr][tc] == '3') {
			for(int i=0; i<4; i++) {
				selected[len] = i;
				back(len+1, selected);
			}
		}else if(map[tr][tc] == '4') {
			for(int i=0; i<4; i++) {
				selected[len] = i;
				back(len+1, selected);
			}
			
		}else {
			selected[len] = 1;
			back(len+1, selected);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		cctv = new ArrayList<>();
		num_cctv = new int[8];
		int idx = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] != '0' && map[i][j] != '6') {
					cctv.add(new Point(i,j));
					num_cctv[idx++] = map[i][j]-'0';
				}
			}
		}
		
		min = Integer.MAX_VALUE;
		size = cctv.size();
		
		int[] selected = new int[size];
		
		back(0, selected);
		
		System.out.println(min);
	}
}
