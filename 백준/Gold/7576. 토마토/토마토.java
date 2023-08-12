import java.io.*;
import java.util.*;

// BJ #7576 - 토마토
// Strategy: BFS
public class Main {	
	static int[][] tomato,res;		 // 상자 내의 토마토의 정보를 저장할 2차원 배열
	static boolean[][] visited;		 // BFS에 사용할 2차원 배열
	static int N,M;					 // 토마토 상자의 크기
	static List<Point> list;		 // 토마토 상자에서 초기에 익어있는 초마토의 위치
	static int[] dr = {1,0,-1,0};    // 4방 탐색을 위한 delta
	static int[] dc = {0,-1,0,1}; 	 // 4방 탐색을 위한 delta
	
	// Point: 토마토의 위치 정보를 저장하는 class
	public static class Point {
		int row;
		int coloumn;
		
		public Point(int row, int coloumn) {
			this.row = row;
			this.coloumn = coloumn;
		}
	}
	
	// BFS(l): BFS를 응용, 초기에 l에 들어있는 point들에서 시작해 모든 토마토의 익는 날짜 계산 
	public static void BFS(List<Point> l) {
		Queue<Point> q = new LinkedList<>();
		
		// BFS 실행
		for(int i=0; i<l.size(); i++) {
			q.add(l.get(i));
			visited[l.get(i).row][l.get(i).coloumn] = true;
		}
		
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + dr[i];
				int nc = tmp.coloumn + dc[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(tomato[nr][nc] == -1) continue;
				if(visited[nr][nc]) continue;
				
				q.add(new Point(nr,nc));
				res[nr][nc] = res[tmp.row][tmp.coloumn] + 1;
				visited[nr][nc] = true;
			}
		}
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 토마토 상자 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        // 변수 설정
        tomato = new int[N][M];
        res = new int[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();
        
        // 토마토 상자 정보 입력
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		tomato[i][j] = Integer.parseInt(st.nextToken());
        		if(tomato[i][j] == 1) {
        			list.add(new Point(i,j));
        		}
        	}
        }
        
        // 결과 저장
        BFS(list);
        int out = 0;
        loop: for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(!visited[i][j] && tomato[i][j] == 0) {
        			out = -1;
        			break loop;
        		}else {
        			if(res[i][j] >= out) {
        				out = res[i][j];
        			}
        		}
        	}
        }
        
        // 최종 결과 출력
        System.out.println(out);
    }
}