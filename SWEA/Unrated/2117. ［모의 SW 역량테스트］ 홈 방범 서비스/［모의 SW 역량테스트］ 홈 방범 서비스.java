import java.util.*;
import java.io.*;

// SWEA #2117 - 홈 방범 서비스
// Strategy: BFS

public class Solution {
	static int N,M, res, total, limitK;
	static int[][] map;
	static int[] cost;
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
	
	public static void BFS(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		int K = 1;				// K: BFS 실행중의 depth
		int house = map[r][c];	// house: BFS를 실행하면서 발견한 집의 개수 저장
		
		q.add(new Point(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			if(house*M >= cost[K]) {	// 손해 없이 홈 방범 서비스 제공이 가능한지 체크
				if(house > res) res = house;	// 이전에 구한 값보다 현재 가능한 집의 개수가 크면 갱신
			}
			
			K++;	// depth 증가
			
			if(K > limitK ) break;		// K가 상한선보다 크면 종
			if(house >= total) break;	// 이미 맵에 존재하는 모든 집을 방문 했으면 종료
			
			int size = q.size();

			while(size-- > 0) {
				Point tmp = q.poll();
				int tr = tmp.row;
				int tc = tmp.col;
				for(int i=0; i<4; i++) {
					int nr = tr + dr[i];
					int nc = tc + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					if(visited[nr][nc]) continue;
					
					if(map[nr][nc] == 1) house++;
					
					q.add(new Point(nr,nc));
					visited[nr][nc] = true;
				}
			}
		}
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
        	N = Integer.parseInt(st.nextToken());	// N: 맵의 크기
        	M = Integer.parseInt(st.nextToken());	// M: 한 집이 낼 수 있는 비용
        	
        	// 맵 정보 입력
        	map = new int[N][N];	// map: 맵의 정보를 저장하는 2차원 배열
        	total = 0;				// total: 맵 전체에 존재하는 집의 개수를 저장
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			if(map[i][j] == 1) {
        				total++;
        			}
        		}
        	}
        	
        	
        	// cost: 운영 비용을 저장하는 배열
        	cost = new int[22];
        	limitK = N+1;	// K 값의 상한선
        	for(int i=1; i<=21; i++) {
        		cost[i] = i*i + (i-1)*(i-1);
        		if(cost[i] > total*M) {
        			limitK = i;	
        			break;
        		}
        	}
        	
        	// BFS 실행 (모든 칸에 대해)
        	res = 0;
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			BFS(i,j);
        		}
        	}
        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t+" ").append(res).append("\n");
    		
    	}
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}