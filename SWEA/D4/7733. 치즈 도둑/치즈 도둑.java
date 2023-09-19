import java.util.*;
import java.io.*;

// SWEA #7733 - 치즈 도둑
// Strategy: BFS

public class Solution {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	
	// bfs(r,c): r,c 에서부터 BFS 실행
	public static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tr = tmp[0];
			int tc = tmp[1];
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(cheese[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	// N: 치즈 크기
        	N = Integer.parseInt(br.readLine());
        	
        	// 치즈 정보 입력 받기
        	cheese = new int[N][N];
        	for(int i=0; i<N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			cheese[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// max: 치즈 덩어리 최대 개수
        	int max = 0;
        	
        	
        	// 0~100일 각각 덩어리 개수 체크 
        	for(int day=0; day<=100; day++) {
        		visited = new boolean[N][N];
        		int group = 0;	// 현재 날짜의 치즈 덩어리 개수 저장

        		// 현재 일수와 같은 정도의 치즈 먹기
        		for(int i=0; i<N; i++) {
        			for(int j=0; j<N; j++) {
        				if(cheese[i][j] == day) {
        					cheese[i][j] = 0;
        				}
        			}
        		}
        		
        		// 치즈 각 칸에서 BFS 실행
        		for(int i=0; i<N; i++) {
        			for(int j=0; j<N; j++) {
        				if(cheese[i][j] != 0 && !visited[i][j]) {
        					bfs(i,j);
        					group++;
        				}
        			}
        		}
        		
        		// max 갱신 및, 모든 치즈를 다 먹은 경우 중도에 종료
        		if(group > max) max = group;
        		if(group == 0) break;
        	}
        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t).append(" ").append(max).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}