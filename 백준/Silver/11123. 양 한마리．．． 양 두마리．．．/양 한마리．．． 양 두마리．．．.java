import java.io.*;
import java.util.*;

// BJ #11123
// Strategy: DFS
public class Main {
	static int T,H,W;
	static char[][] grid;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void DFS(int row, int col) {
		Stack<Point> stack = new Stack<>();
		
		stack.add(new Point(row,col));
		visited[row][col] = true;
		
		while(!stack.isEmpty()) {
			Point tmp = stack.pop();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.col + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;	// 그리드의 범위를 벗어났을 때
				if(grid[nr][nc] == '.')	continue;	// 양이 없는 곳일 때
				if(visited[nr][nc]) continue;	// 이미 방문한 지점일 때
				
				stack.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T : 테스트 케이스 수
		T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 실행
		for(int t=0; t<T; t++) {
			// 그리드 크기 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			// 그리드 정보 입력
			grid = new char[H][W];
			for(int i=0; i<H; i++) {
				String s = br.readLine();
				for(int j=0; j<W; j++) {
					grid[i][j] = s.charAt(j);
				}
			}
			
			// 방문배열
			visited = new boolean[H][W];
			
			// 각 칸에 대해 DFS 실행, 무리의 수 체크
			int result = 0;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(grid[i][j] == '#' && !visited[i][j]) {
						DFS(i,j);
						result++;
					}
				}
			}
			
			// 현재 테스트 케이스 결과 저장
			sb.append(result).append("\n");
			
		}
		// 최종 결과 출력
		System.out.println(sb);
	}

}