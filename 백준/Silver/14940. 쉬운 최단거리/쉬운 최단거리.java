import java.io.*;
import java.util.*;

// BJ #14940 - 쉬운 최단거리
// Strategy: BFS 응용
public class Main {	
	static int[][] map;		// 지도 정보를 저장할 2차원 배열
	static int[][] res;		// 계산 결과를 저장할 2차원 배열
	static int n,m;         // 지도 크기 저장할 변수
	
	static int[] dr = {1,0,-1,0};    // 4방 탐색을 위한 delta
	static int[] dc = {0,-1,0,1}; 	 // 4방 탐색을 위한 delta
	static boolean[][] visited;    // BFS에 사용할 2차원 배열
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // n,m: 지도의 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int r = 0;
        int c = 0;
        
        // 지도 정보 입력
        map = new int[n][m];
        boolean found = false;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(!found && map[i][j] == 2) {
        			r = i;
        			c = j;
        			found = true;
        		}
        	}
        }
        
        // 최단거리 계산
        res = new int[n][m];
        visited = new boolean[n][m];
        cal(r,c);
        
        // 출력을 위한 결과 저장
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(!visited[i][j] && map[i][j]==1) {
        			sb.append(-1).append(" ");
        		}else {
        			sb.append(res[i][j]).append(" ");
        		}
        		
        	}
        	sb.append("\n");
        }
        
        
        // 최종 결과 출력
        System.out.println(sb);
    }
    
    // Point: 지점의 위치정보(row, column)을 저장하는 class
 	public static class Point{
 		int row;
 		int column;
 		public Point(int row, int column) {
 			this.row = row;
 			this.column = column;
 		}
 	}
 	
 	// cal(r,c): 목표지점 (r,c)에서 부터 모든 지점까지 최단거리를 계산하는 함수
 	public static void cal(int r, int c) {
 		Queue<Point> q = new LinkedList<>();
 		
 		// BFS 실행
 		q.add(new Point(r,c));
 		visited[r][c] = true;
 			
 		while(!q.isEmpty()) {
 			Point tmp = q.poll();
 				
 			for(int i=0; i<4; i++) {
 				int nr = tmp.row + dr[i];
 				int nc = tmp.column + dc[i];
 					
 				if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;  
 				if(map[nr][nc] == 0) continue;  // 방문 불가한 점
 				if(visited[nr][nc]) continue;   // 이미 방문한 점
 					
 				q.add(new Point(nr,nc));
 				res[nr][nc] = res[tmp.row][tmp.column] + 1;
 				visited[nr][nc] = true; 				
 			}
 		}
 	}
}