import java.util.*;
import java.io.*;

// SWEA #1949 - 등산로 조성
// Strategy: DFS

public class Solution {
	static int N,K,maxH,maxL;
	static int[][] map, len;
	static boolean[][] visited, visited_after;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	
	
	public static class Point{
		int row;
		int col;
		int height;
		int after;
		
		public Point(int row, int col, int height, int after) {
			this.row = row;
			this.col = col;
			this.height = height;
			this.after = after;
		}
	}
	
	public static void DFS(Point p, int len) {
		int tr = p.row;
		int tc = p.col;
		int th = p.height;
		int ta = p.after;

		// maxL 갱신
		if(len > maxL) maxL = len;
		
		// 방문처리
		visited[tr][tc] = true;
		
		// 사방탐색
		for(int i=0; i<4; i++) {
			int nr = tr + dr[i];
			int nc = tc + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			if(ta == 0) {
				if(map[nr][nc] >= th) {
					if(map[nr][nc] - (th-1) <= K) {
						DFS(new Point(nr, nc, th-1, 1), len+1);
					}
				}else {
					DFS(new Point(nr, nc, map[nr][nc], 0), len+1);	
				}
			}else {
				if(map[nr][nc] >= th) continue;
				else {
					DFS(new Point(nr, nc, map[nr][nc], 1), len+1);
				}
			}
		}
		
		// 방문 처리 해제
		visited[tr][tc] = false;
	}
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        
        // T: 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        
        // 테스트 케이스 실행
        for(int t=1; t<=T; t++) {
        	
        	// 기본 정보 입력
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	
        	// 지도 정보 입력
        	map = new int[N][N];	// map: 지도 정보 저장하는 2차원 배열
        	maxH = 0;				// maxH: 가장 높은 봉우리의 높이 저장
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			if(map[i][j] > maxH) {
        				maxH = map[i][j];
        			}
        		}
        	}
        	
        	// 가장 높은 봉우리들의 위치 저장
        	List<Point> high_peaks = new ArrayList<>();
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			if(map[i][j] == maxH) {
        				high_peaks.add(new Point(i,j,map[i][j],0));
        			}
        		}
        	}
        	
        	// DFS 실행
        	maxL = 0;	// maxL: 가장 긴 등산로의 길이 저장
        	for(int i=0; i<high_peaks.size(); i++) {
        		Point peak = high_peaks.get(i);
        		visited = new boolean[N][N];			// 공사를 하지 않았을때의 방문배열
        		visited_after = new boolean[N][N];		// 공사를 하고 난 이후의 방문배열
        		DFS(peak,1);
        	}
        	
        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t+" ").append(maxL).append("\n");
    		
    	}
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}