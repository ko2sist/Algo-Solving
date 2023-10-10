import java.util.*;
import java.io.*;

// BJ #23288 - 주사위 굴리기2
// Strategy: 

public class Main {
	static int N,M,K, cnt;
	static int[][] map, point;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Dice dice;
	static int R,C;
	static boolean[][] visited;
	
	public static class Dice{
		int row;
		int col;
		int d;
		
		int top;
		int bottom;
		int front;
		int back;
		int left;
		int right;
		
		public Dice() {
			row = 0;
			col = 0;
			d = 1;
			
			top = 1;
			bottom = 6;
			front = 5;
			back = 2;
			left = 4;
			right = 3;
		}
		
		public void move() {
			if(d == 0) {	// 위
				int tmp = top;
				top = front;
				front = bottom;
				bottom = back;
				back = tmp;
				row--;
			}else if(d==1) {	// 오른쪽
				int tmp = top;
				top = left;
				left = bottom;
				bottom = right;
				right = tmp;
				col++;
			}else if(d==2) {	// 아래
				int tmp = top;
				top = back;
				back = bottom;
				bottom = front;
				front = tmp;
				row++;
			}else if(d==3) {	// 왼쪽
				int tmp = top;
				top = right;
				right = bottom;
				bottom = left;
				left = tmp;
				col--;
			}
		}
	}
	
	public static void DFS(int r, int c, int n) {
		visited[r][c] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(map[nr][nc] != n) continue;
			if(visited[nr][nc]) continue;
			
			DFS(nr,nc,n);
		}
	}
	
	public static void Fill(int r, int c, int n) {
		visited[r][c] = true;
		point[r][c] = n;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(map[nr][nc] != n) continue;
			if(visited[nr][nc]) continue;
			
			DFS(nr,nc,n);
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 기본 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 지도 정보 입력
        map = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 각 칸의 점수 계산
        point = new int[N][M];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(point[i][j] == 0) {
        			cnt = 0;
        			visited = new boolean[N][M];
        			DFS(i,j, map[i][j]);
        			visited = new boolean[N][M];
        			Fill(i,j,map[i][j]*cnt);
        		}
        	}
        }
        
        // 주사위 생성 
        dice = new Dice();
        
        // 점수 계산
        int res = 0;
        while(K-- > 0) {
        	int tr = dice.row;
        	int tc = dice.col;
        	int td = dice.d;
        	
        	int nr = tr + dr[td];
        	int nc = tc + dc[td];
        	
        	if(nr < 0 || nc < 0 || nr >= N || nc >= M) {	// 이동 방향에 칸이 없을 경우
        		dice.d = (td+2) % 4; // 이동 방향 반대로
        		td = dice.d;
        		nr = tr + dr[td];
            	nc = tc + dc[td];
        	}
        	
        	dice.move(); 	// 주사위 굴리기
        	res += point[nr][nc];	// 도착한 칸에 대한 점수 획득
        	
        	int A = dice.bottom;	// 주사위 바닥면 정수
        	int B = map[nr][nc];	// 이동한 칸에 있는 정수
        	
        	if(A > B) {	// 이동 방향 시계 방향 90도 회전
        		dice.d = (td + 1) % 4;
        	}else if (A < B) {	// 이동 방향 반시계 90도 회전
        		dice.d = (td + 3) % 4;
        	}
        }
        
        // 최종 결과 출력
        System.out.println(res);
	}
}