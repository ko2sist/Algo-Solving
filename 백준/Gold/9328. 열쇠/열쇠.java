import java.util.*;
import java.io.*;

// BJ #9328 - 열쇠
// Strategy: 


public class Main {
	static int H, W ,cnt;
	static char[][] map;
	static Set<Character> keys;
	static Queue<Point> q;
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
	
	public static void Find() {
		cnt = 0;
		
		while(keys.size() > 0) {
			// 찾은 열쇠로 문 따기
			for(int i=0; i<H+2; i++) {
				for(int j=0; j<W+2; j++) {
					if(keys.contains(map[i][j])) {
						map[i][j] = '.';
					}
				}
			}
			
			// keys 초기화
			keys = new HashSet<>();
			
			// BFS 실행
			q = new ArrayDeque<>();
			visited = new boolean[H+2][W+2];
			
			q.add(new Point(0,0));
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				Point tmp = q.poll();
				int tr = tmp.row;
				int tc = tmp.col;
				
				for(int i=0; i<4; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr<0 || nc<0 || nr>=H+2 || nc>=W+2) continue;
					if(visited[nr][nc]) continue;
					
					// 문에 막힐 경우
					if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') continue;
					
					// 벽에 막힐 경우
					if(map[nr][nc] == '*') continue;
					
					// 열쇠 찾을 경우
					if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
						keys.add((char) (map[nr][nc] - 32));
						map[nr][nc] = '.';

					}
						
					// 서류 찾을 경우
					if(map[nr][nc] == '$') {
						cnt++;
						map[nr][nc] = '.';
					}
					
					// 빈칸일 경우 + (열쇠 찾은 경우 + 서류 찾은 경우)
					q.add(new Point(nr,nc));
					visited[nr][nc] = true;
				}
			}
			
//			for(char[] line: map) {
//				System.out.println(Arrays.toString(line));
//			}
//			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			// map 정보 입력
			map = new char[H+2][W+2];
			for(int i=1; i<H+1; i++) {
				String s = br.readLine();
				for(int j=0; j<W+2; j++) {
					if(j==0 || j==W+1) {
						map[i][j] = '.';
						continue;
					}
					map[i][j] = s.charAt(j-1);
				}
			}
			Arrays.fill(map[0], '.');
			Arrays.fill(map[H+1], '.');
			
			
			// 열 수 있는 문의 정보를 저장
			keys = new HashSet<>();
			String str_key = br.readLine();
			for(int i=0; i<str_key.length(); i++) {
				keys.add((char) (str_key.charAt(i)-32));
			}
			
			// 탐색 실행, 결과 저장
			Find();
			sb.append(cnt).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}