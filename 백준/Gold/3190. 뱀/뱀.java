import java.util.*;
import java.io.*;

// BJ #3190 - 뱀
// Strategy: 
public class Main {
	static int[] dr = {-1,0,1,0};	// 상우하좌 순서
	static int[] dc = {0,1,0,-1};
	static int N, res;
	static int[][] board;
	static PriorityQueue<Direction> pq;
	static List<Point> snake;
	
	public static class Point{
		int row;
		int column;
		
		public Point(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	public static class Direction implements Comparable<Direction>{
		int X;
		char C;
		
		public Direction(int x, char c) {
			X = x;
			C = c;
		}

		@Override
		public int compareTo(Direction o) {
			return this.X - o.X;
		}
	}
	
	public static void Game() {
        snake = new ArrayList<>();
        snake.add(new Point(0,0));
		
		int d = 1;
		res = 1;
		
		loop: while(true) {
			Direction tmp = pq.poll();
			for(int i=res; i<=tmp.X; i++) {
				Point head = snake.get(0);
				int nr = head.row + dr[d];
				int nc = head.column + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) break loop;
				if(board[nr][nc] == -1) break loop;
				
				if(board[nr][nc] == 1) {	// 이동한 칸에 사과 존재
					snake.add(0, new Point(nr,nc));
				}else{						// 이동한 칸에 사과 존재x
					snake.add(0, new Point(nr,nc));
					Point tail = snake.get(snake.size()-1);
					board[tail.row][tail.column] = 0;
					snake.remove(snake.size()-1);
				}
				
				board[nr][nc] = -1;
				res++;
			}
			
			char dir = tmp.C;
			if(dir =='L') {
				d -= 1;
				if(d < 0) d += 4;
			}else if(dir == 'D'){
				d += 1;
				if(d >= 4) d-= 4;
			}
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        
        
        // N: 보드 크기, K: 사과 개수
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        // board
        board = new int[N][N];
        
        // board에 사과 정보 저장
        for(int i=0; i<K; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	board[r-1][c-1] = 1;
        }
        // 뱀 초기 위치 설정(뱀이 존재하는 위치는 -1로 표시)
        board[0][0] = -1;
        
        
        
        // pq: 방향 변환 정보 저장하는 PQ
        pq = new PriorityQueue<>();
        pq.add(new Direction(10000, ' '));
        
        // L: 방향 전환 정보 개수
        int L = Integer.parseInt(br.readLine());
        
        // 방향 전환 정보 저장
        for(int i=0; i<L; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int X = Integer.parseInt(st.nextToken());
        	char C = st.nextToken().charAt(0);
        	
        	pq.add(new Direction(X,C));
        }
        
        // 게임 실행
        Game();
        
        // 최종 결과 출력
        System.out.println(res);
    }
}