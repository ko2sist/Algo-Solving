import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;
	static StringBuilder sb;
    static int T,N,M,K,offset;
    static int[][] map;
    static PriorityQueue<Cell> cells;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static class Cell implements Comparable<Cell>{
        int row;	// 행
        int col;	// 열
        int life;	// 생명력
        int time;	// 활성화 이전 - 활성화 까지의 시간 / 활성화 이후 - 남은 수명
        
        public Cell(int row, int col, int life, int time) {
            this.row = row;
            this.col = col;
            this.life = life;
            this.time = time;
        }

		@Override
		public int compareTo(Cell o) {
			return this.life - o.life;
		}
    }
     
    public static void cultivate() {
    	Queue<Cell> tmp_q = new ArrayDeque<>();
    	
    	while(K-- >0) {
    		while(!cells.isEmpty()) {
    			Cell tmp = cells.poll();	// pq에서 세포 하나 뽑기
    			tmp.time--;					// 활성화까지의 시간 1 감소
    			
    			if(tmp.time < 0) {
    				for(int d=0; d<4; d++) {
    					int nr = tmp.row + dr[d];
    					int nc = tmp.col + dc[d];
    					if(visited[nr][nc]) continue;
    					tmp_q.add(new Cell(nr,nc,tmp.life, tmp.life));
    					visited[nr][nc] = true;
    					map[nr][nc] = tmp.life;
    				}
    			}
    			
    			if(tmp.life + tmp.time == 0) continue;
    			tmp_q.add(tmp);
    		}
    		
    		while(!tmp_q.isEmpty()) cells.add(tmp_q.poll());
    	}
    }
    
    public static void setting() throws Exception{
        // offset
        offset = K/2+1;
        
        // 세포 배양을 위한 배열, pq 선언
        map = new int[N+K+1][M+K+1];
        cells = new PriorityQueue<>(Collections.reverseOrder());
        visited = new boolean[N+K+1][M+K+1];

        // 세포 초기 정보 입력
        for(int i=offset; i<N+offset; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=offset; j<M+offset; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                	cells.add(new Cell(i,j,map[i][j], map[i][j]));
                	visited[i][j] = true;
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            
        	// 기본 정보 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            // 초기 세팅
            setting();
            
            // 세포 배양
            cultivate();
            
            // 현재 테스트케이스 결과 저장
            sb.append("#"+t+" ").append(cells.size()).append("\n");
        }
        // 최종 결과 출력
        System.out.println(sb);
    }
}