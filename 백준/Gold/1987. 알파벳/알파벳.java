import java.util.*;
import java.io.*;

// BJ #1987 - 알파벳
// Strategy: 백트래킹
public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int R,C;
	static char[][] board;
	static int max;
	
	public static void back(int len, int r, int c, boolean[] visited) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			
			char tmp = board[nr][nc];
			
			if(!visited[tmp-'A']) {
				visited[tmp-'A'] = true;
				back(len+1, nr, nc, visited);
				visited[tmp-'A'] = false;
			}
		}

		if(len > max) max = len;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		max = Integer.MIN_VALUE;
		boolean[] visited = new boolean[26];
		visited[board[0][0]-'A'] = true;
		
		back(1, 0, 0, visited);
		
		System.out.println(max);
	}
}
