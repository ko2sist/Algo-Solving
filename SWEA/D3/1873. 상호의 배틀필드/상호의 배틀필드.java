import java.util.*;
import java.io.*;

// SWEA #1873 - 상호의 배틀필드
// Strategy: 
public class Solution {
	static int[] dr = {-1,1,0,0};	// 상하좌우 순서
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static int r,c,d, W,H;
	
	public static void move(char ch) {
		if(ch == 'U') {
			d = 0;
			map[r][c] = '^';
		}else if(ch == 'D') {
			d = 1;
			map[r][c] = 'v';
		}else if(ch == 'L') {
			d = 2;
			map[r][c] = '<';
		}else {
			d = 3;
			map[r][c] = '>';
		}
		
		int nr = r + dr[d];
		int nc = c + dc[d];
		if(nr >= 0 && nc >=0 && nr < H && nc < W) {
			if(map[nr][nc] == '.') {
				char tmp = map[r][c];
				map[r][c] = '.';
				map[nr][nc] = tmp;
				r = nr;
				c = nc;
			}
		}
	}
	
	public static void Shoot() {
		int nr = r+dr[d];
		int nc = c+dc[d];
		while(nr >= 0 && nc >=0 && nr < H && nc < W) {
			if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				break;
			}else if(map[nr][nc] == '#') {
				break;
			}
			
			nr += dr[d];
			nc += dc[d];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			d = 0;	// 전차가 바라보는 방향
			r = 0;	// 전차의 위치 (row)
			c = 0;	// 전차의 위치 (column)
			
			// 맵 정보 입력
			for(int i=0; i<H; i++) {
				String s = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '^') {
						r = i;
						c = j;
						d = 0;
					}else if(map[i][j] == 'v') {
						r = i;
						c = j;
						d = 1;
					}else if(map[i][j] == '<') {
						r = i;
						c = j;
						d = 2;
					}else if(map[i][j] == '>') {
						r = i;
						c = j;
						d = 3;
					}
				}
			}
			
			// 입력된 cmd 실행
			int N = Integer.parseInt(br.readLine());
			String str_cmd = br.readLine();
			for(int i=0; i<N; i++) {
				char cmd = str_cmd.charAt(i);
				
				if(cmd == 'S') {
					Shoot();
				}else {
					move(cmd);
				}
			}
			
			// 현재 테스트케이스 결과 저장
			sb.append("#").append(t).append(" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
