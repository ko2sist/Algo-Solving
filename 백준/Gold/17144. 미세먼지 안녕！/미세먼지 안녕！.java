import java.util.*;
import java.io.*;

// BJ #17144 - 미세먼지 안녕
// Strategy: 구현
public class Main {
	static int R,C,T;
	static int[][] room;
	static int[] ac1, ac2;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void Diffuse() {
		int[][] tmp = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(room[i][j] == -1) {
					tmp[i][j] = -1;
					continue;
				}
				if(room[i][j] == 0) continue;
				
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					if(nr < 0 || nc < 0 || nr >= R || nc >= C || room[nr][nc] == -1) {
						continue;
					}
					cnt++;
					tmp[nr][nc] += room[i][j]/5;
				}
				
				tmp[i][j] += room[i][j] - (room[i][j]/5)*cnt;
			}
		}
		
		room = tmp;
	}
	
	public static void AC_ON() {
		// AC1
		int d = 1;
		int r = ac1[0];
		int c = ac1[1]+1;
		int prev = 0;
		while(true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
				d = (d+3)%4;
				continue;
			}
			
			if(room[nr][nc] == -1) {
				room[r][c] = prev;
				break;
			}		
			
			int tmp = room[r][c];
			room[r][c] = prev;
			prev = tmp;
			
			r = nr;
			c = nc;
		}
		
		// AC2
		d = 1;
		r = ac2[0];
		c = ac2[1]+1;
		prev = 0;
		while(true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
				d = (d+1)%4;
				continue;
			}
			
			if(room[nr][nc] == -1) {
				room[r][c] = prev;
				break;
			}		
			
			int tmp = room[r][c];
			room[r][c] = prev;
			prev = tmp;
			
			r = nr;
			c = nc;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 변수 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		ac1 = new int[] {-1,-1};
		ac2 = new int[] {-1,-1};
		
		
		// 방의 정보 입력
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) {
					if(ac1[0] == -1) {
						ac1[0] = i;
						ac1[1] = j;
					}else {
						ac2[0] = i;
						ac2[1] = j;
					}
				}
			}
		}

		// T초 동안 과정 진행
		for(int i=0; i<T; i++) {
			Diffuse();

			AC_ON();
		}
		
		
		// 결과 계산
		int res = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(room[i][j] == -1) continue;
				res += room[i][j];	
			}
		}
		
		// 최종 결과 출력
		System.out.println(res);
	}
}