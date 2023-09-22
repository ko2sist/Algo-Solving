import java.util.*;
import java.io.*;

// SWEA #5656 - 벽돌깨기
// Strategy: 구현

public class Solution {
	static int N,W,H,min;
	static int[][] map, copy;
	static int[] selected;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void gravity() {
		for(int i=0; i<W; i++) {
			Stack<Integer> stack = new Stack<>();
			for(int j=0; j<H; j++) {
				if(copy[j][i] != 0) {
					stack.add(copy[j][i]);
				}
			}
			
			for(int j=H-1; j>=0; j--) {
				if(!stack.isEmpty()) {
					copy[j][i] = stack.pop();
				}else {
					copy[j][i] = 0;
				}
			}
		}
	}
	
	public static void Break(int row, int col) {
		int cnt = copy[row][col];
		copy[row][col] = 0;
		
		for(int i=0; i<cnt; i++) {
			for(int k=0; k<=3; k++) {
				int nr = row + i*dr[k];
				int nc = col + i*dc[k];
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
				if(copy[nr][nc] == 0) continue;
				
				Break(nr,nc);
			}
		}
		
	}
	
	public static int breakBricks(int[] selected) {
		copy = new int[H][W];
		for(int i=0; i<H; i++) {
			copy[i] = map[i].clone();
		}
		
		for(int s=0; s<N; s++) {
			int col = selected[s];
			int r = 0;
			int c = 0;
			// 현재 열의 최상단 벽돌 위치 찾기
			for(int i=0; i<H; i++) {
				if(copy[i][col] != 0) {
					Break(i,col);
					break;
				}
			}
			
			gravity();
			
		}
		
		
		int res = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(copy[i][j] != 0) {
					res++;
				}
			}
		}
		
		
		return res;
	}
	public static void back(int num, int[] selected) {
		if(num == N) {
			int cnt = breakBricks(selected);
			if(cnt < min) min = cnt;;
			return;
		}
		
		for(int i=0; i<W; i++) {
			selected[num] = i;
			back(num+1, selected);
		}
		
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // T: 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	H = Integer.parseInt(st.nextToken());
        	
        	map = new int[H][W];
        	for(int i=0; i<H; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<W; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	min = (int)1e9;
        	selected = new int[N];
        	back(0,selected);
        	
        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t).append(" ").append(min).append("\n");
        	
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}