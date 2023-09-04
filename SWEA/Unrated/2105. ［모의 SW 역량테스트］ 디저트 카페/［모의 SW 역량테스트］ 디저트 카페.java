import java.util.*;
import java.io.*;

// SWEA #2015 - 디저트 카페
// Strategy: 
public class Solution {
	static int N, max, start_r, start_c;
	static int[][] map;
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	static boolean[] visited;
	
	public static boolean check(int num1, int num2, int r, int c) {
//		System.out.println(num1 + " " + num2);
		boolean[] copy = visited.clone();
		
		for(int i=0; i<num1; i++) {
//			System.out.println(r+ " " + c);
			int nr = r + dr[2];
			int nc = c + dc[2];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || copy[map[nr][nc]]) return false;
			
			r = nr;
			c = nc;
//			System.out.println(r+" "+c);
			copy[map[nr][nc]] = true;
		}
		
		for( int i=0; i<num2; i++) {
			int nr = r + dr[3];
			int nc = c + dc[3];
			
			if(i == num2-1) continue; 
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || copy[map[nr][nc]]) return false;
			
			r = nr;
			c = nc;
			copy[map[nr][nc]] = true;
		}

		return true;
	}
	public static void back(int num1, int num2, int r, int c, int d) {
		if(d==2) {
			if(num1+num2 > max/2) {
				if(check(num1, num2, r, c)) {
					max = (num1+num2)*2;
				}
			}
			return;
		}
		
		if(d==0) {
			int nr = r + dr[0];
			int nc = c + dc[0];
			if(nr >= 0 && nc >=0 && nr < N && nc < N && !visited[map[nr][nc]]) {
				visited[map[nr][nc]] = true;
				back(num1+1, num2, nr, nc, d);
				visited[map[nr][nc]] = false;
			}
			
			nr = r + dr[1];
			nc = c + dc[1];
			if(nr >= 0 && nc >=0 && nr < N && nc < N && !visited[map[nr][nc]] && num1 > 0) {
				visited[map[nr][nc]] = true;
				back(num1, num2+1, nr, nc, d+1);
				visited[map[nr][nc]] = false;
			}
			
		}else if(d==1) {
			int nr = r+dr[1];
			int nc = c+dc[1];
			if(nr >= 0 && nc >=0 && nr < N && nc < N && !visited[map[nr][nc]]) {
				visited[map[nr][nc]] = true;
				back(num1, num2+1, nr, nc, d);
				visited[map[nr][nc]] = false;
			}
			
			nr = r + dr[2];
			nc = c + dc[2];
			if(nr >= 0 && nc >=0 && nr < N && nc < N && !visited[map[nr][nc]]) {
				back(num1, num2, r, c, d+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE;
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
//					if(!visited[i][j]) {
//						cal(i,j);
//					}
					
//					System.out.println("ij " + i + " " + j);
					visited = new boolean[101];
					visited[map[i][j]] = true;
					back(0,0,i,j,0);
//					for(boolean[] line: visited) {
//						System.out.println(Arrays.toString(line));
//					}
//					System.out.println();
				}
			}
			
			if(max == Integer.MIN_VALUE) {
				sb.append("#"+t+" ").append(-1).append("\n");
			}else {
				sb.append("#"+t+" ").append(max).append("\n");
			}
			

		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
