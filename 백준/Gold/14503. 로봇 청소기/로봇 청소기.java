import java.util.*;
import java.io.*;

// BJ #14503 - 로봇 청소기
// Strategy: 구현
public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static class Robot{
		int N;
		int M;
		int r;
		int c;
		int d;
		int[][] room;
		
		public Robot(int n, int m, int r, int c, int d, int[][] room) {
			N = n;
			M = m;
			this.r = r;
			this.c = c;
			this.d = d;
			this.room = room;
		}
		
		
		
		public int Operation() {
			int res = 0;
			
			while(true) {
				if(room[r][c] == 0) {
					room[r][c] = -1;
					res++;
				}
				
				boolean check = false;
				for(int i=0; i<4; i++) {
					int nr = r+dr[i];
					int nc = c+dc[i];
					
					if(room[nr][nc] == 0) {
						check = true;
						break;
					}
				}
				
				if(!check) {	// 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
					int nr = r-dr[d];
					int nc = c-dc[d];
					if(room[nr][nc] == 1) {
						break;
					}else {
						r = nr;
						c = nc;
					}
				}else {			// 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
					d = (d+3)%4;
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(room[nr][nc] == 0) {
						r = nr;
						c = nc;
					}
				}
				
				
			}
			
			return res;
		}
	}
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Robot robot = new Robot(N,M,r,c,d,room);
		
		System.out.println(robot.Operation());
	}
}
