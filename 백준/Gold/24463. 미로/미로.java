import java.io.*;
import java.util.*;

// BJ #24463 - 미로
// Strategy: DFS + 백트래킹

public class Main {
	static int N,M;
	static char[][] map;
	static int sr, sc;
	static int er, ec;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void DFS(int r, int c) {

		if(r == er && c == ec) {	// 끝 점에 도달한 경우
			map[r][c] = '.';
			
			// 결과 저장
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			// 최종 결과 출력
			System.out.println(sb);
			return;
		}
		
		for(int i=0 ; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;	// 범위를 벗어난 경우
			
			if(map[nr][nc] == '@') {
				map[nr][nc] = '.';
				DFS(nr,nc);
				map[nr][nc] = '@';
			}
		
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 미로 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 미로 정보 입력
		sr = -1;
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '.') {
					if(i==0 || i==N-1 || j==0 || j==M-1) {	// 벽에 있는 구멍일 경우 시작,도착점으로 기록
						if(sr != -1) {	// 시작점을 이미 찾은 경우
							er = i;
							ec = j;
						}else {			// 시작점을 아직 안 찾은 경우
							sr = i;
							sc = j;
						}
					}
					map[i][j] = '@';	// 최단 거리인 길만 '.'로 다시 표시할 것이기 때문에 미리 '@'로 처리
				}
			}
		}

		// 최단 경로 찾기(백트래킹 사용)
		map[sr][sc] = '.';
		DFS(sr,sc);

	}
}