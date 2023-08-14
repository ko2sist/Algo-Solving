import java.util.*;
import java.io.*;

// # BJ #21736 - 헌내기는 친구가 필요해
public class Main {
	static int[] dr = {-1,0,1,0};	// 4방 탐색을 위한 델타
	static int[] dc = {0,1,0,-1};	// 4방 탐색을 위한 델타
	static int R,C, N,M;			// R,C 초기에 도연이의 위치 정보 / N,M 캠퍼스의 크기 정보
	static char[][] campus;			// 캠퍼스 정보를 저장할 2차원 배열
	static int res = 0;				// 도연이가 만난 사람 수 저장
	
	public static class Point{
		int row;
		int column;
		
		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	public static void BFS(int r, int c) {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.column + dc[i];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(campus[nr][nc] == 'X') continue;
				if(visited[nr][nc]) continue;
				
				if(campus[nr][nc] == 'P') res++;
				q.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 캠퍼스 크기 N,M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 캠퍼스 정보 입력
		campus = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				campus[i][j] = s.charAt(j);
				if(campus[i][j] == 'I') {
					R = i;
					C = j;
				}
			}
		}
		// 결과 계산 - BFS 사용
		BFS(R,C);
		
		// 최종 결과 출력
		if(res == 0) {
			System.out.println("TT");
		}else {
			System.out.println(res);
		}
	}
}
