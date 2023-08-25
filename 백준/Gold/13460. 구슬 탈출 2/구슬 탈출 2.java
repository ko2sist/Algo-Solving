import java.util.*;
import java.io.*;

// BJ #13460 - 구슬 탈출 2
// Strategy: BFS
public class Main {
	static int N,M,res;
	
	public static class Board{
		char[][] board;
		int num;
		int r;			// 빨간 공의 현재 위치 정보
		int c;			// 빨간 공의 현재 위치 정보
		char prev;
		
		public Board(char[][] board, int num, int r, int c, char prev) {
			this.board = board;
			this.num = num;
			this.r = r;
			this.c = c;
			this.prev = prev;
		}
		
		public void print() {
			System.out.println("\n");
			for(char[] line : board) {
				System.out.println(Arrays.toString(line));
			}
		}
		
		public Board Up() {
			char[][] res_board = new char[N][M];
			int res_num = num+1;
			int nr = 0;
			int nc = 0;
			char prev = 'U';
			
			
			
			loop: for(int i=0; i<M; i++) {
				int idx = N-1;
				int check_r = 0;
				int check_b = 0;
				Stack<Character> s = new Stack<>();
				for(int j=N-1; j>=0; j--) {
					char tmp = board[j][i];
					if(tmp == '#') {
						res_board[j][i] = '#';
						for(int k=j+1; k<=idx; k++) {
							if(res_board[k][i] == 'O') continue;
							
							if(!s.isEmpty()) {
								if(s.peek() == 'R') {
									nr = k;
									nc = i;
								}
								res_board[k][i] = s.pop();
							}else {
								res_board[k][i] = '.';
							}
						}
						idx = j-1;
						check_r = 0;
						check_b = 0;
					}else if(tmp != '.'){	
						if(tmp == 'R') {
							check_r = 1;
						}else if(tmp == 'B') {
							check_b = 1;
						}else if(tmp == 'O') {
							res_board[j][i] = 'O';
							if(check_r == 1 && check_b == 0) { // R이  나옴 
								prev = 'P';
								break loop;
							}else if(check_b == 1) {		
								prev = 'F';
								break loop;
							}
							continue;
						}
						s.add(tmp);
					}
				}
			}
			return new Board(res_board, res_num, nr, nc, prev);
		}
		
		public Board Down() {
			char[][] res_board = new char[N][M];
			int res_num = num+1;
			int nr = 0;
			int nc = 0;
			char prev = 'D';
			
			loop: for(int i=0; i<M; i++) {
				int idx = 0;
				int check_r = 0;
				int check_b = 0;
				Stack<Character> s = new Stack<>();
				for(int j=0; j<N; j++) {
					char tmp = board[j][i];
					if(tmp == '#') {
						res_board[j][i] = '#';
						for(int k=j-1; k>=idx; k--) {
							if(res_board[k][i] == 'O') continue;
							
							if(!s.isEmpty()) {			
								if(s.peek() == 'R') {
									nr = k;
									nc = i;
								}
								res_board[k][i] = s.pop();
							}else {
								res_board[k][i] = '.';
							}
						}
						idx = j+1;
						check_r = 0;
						check_b = 0;
					}else if(tmp != '.'){	
						if(tmp == 'R') {
							check_r = 1;
						}else if(tmp == 'B') {
							check_b = 1;
						}else if(tmp == 'O') {
							res_board[j][i] = 'O';
							if(check_r == 1 && check_b == 0) { // R이  나옴 
								prev = 'P';
								break loop;
							}else if(check_b == 1) {		
								prev = 'F';
								break loop;
							}
							continue;
						}
						s.add(tmp);
					}
				}
			}
			return new Board(res_board, res_num, nr, nc, prev);
		}
		
		public Board Left() {
			char[][] res_board = new char[N][M];
			int res_num = num+1;
			int nr = 0;
			int nc = 0;
			char prev = 'L';		
			
			loop: for(int i=0; i<N; i++) {
				int idx = M-1;
				int check_r = 0;
				int check_b = 0;
				Stack<Character> s = new Stack<>();
				for(int j=M-1; j>=0; j--) {
					char tmp = board[i][j];
					if(tmp == '#') {
						res_board[i][j] = '#';
						for(int k=j+1; k<=idx; k++) {
							if(res_board[i][k] == 'O') continue;
							
							if(!s.isEmpty()) {
								if(s.peek() == 'R') {
									nr = i;
									nc = k;
								}
								res_board[i][k] = s.pop();
							}else {
								res_board[i][k] = '.';
							}
						}
						idx = j-1;
						check_r = 0;
						check_b = 0;
					}else if(tmp != '.'){	
						if(tmp == 'R') {
							check_r = 1;
						}else if(tmp == 'B') {
							check_b = 1;
						}else if(tmp == 'O') {
							res_board[i][j] = 'O';
							if(check_r == 1 && check_b == 0) { // R이  나옴 
								prev = 'P';
								break loop;
							}else if(check_b == 1) {		
								prev = 'F';
								break loop;
							}
							continue;
						}
						s.add(tmp);
					}
				}
			}
			return new Board(res_board, res_num, nr, nc, prev);
		}
		
		public Board Right() {
			char[][] res_board = new char[N][M];
			int res_num = num+1;
			int nr = 0;
			int nc = 0;
			char prev = 'R';
			
			
			
			loop: for(int i=0; i<N; i++) {
				int idx = 0;
				int check_r = 0;
				int check_b = 0;
				
				Stack<Character> s = new Stack<>();
				for(int j=0; j<M; j++) {
					char tmp = board[i][j];
					if(tmp == '#') {
						res_board[i][j] = '#';
						for(int k=j-1; k>=idx; k--) {
							if(res_board[i][k] == 'O') continue;
							
							if(!s.isEmpty()) {
								if(s.peek() == 'R') {
									nr = i;
									nc = k;
								}
								res_board[i][k] = s.pop();
							}else {
								res_board[i][k] = '.';
							}
						}
						idx = j+1;
						check_r = 0;
						check_b = 0;
					}else if(tmp != '.'){	
						if(tmp == 'R') {
							check_r = 1;
						}else if(tmp == 'B') {
							check_b = 1;
						}else if(tmp == 'O') {
							res_board[i][j] = 'O';
							if(check_r == 1 && check_b == 0) { // R이  나옴 
								prev = 'P';
								break loop;
							}else if(check_b == 1) {		
								prev = 'F';
								break loop;
							}
							continue;
						}
						s.add(tmp);
					}
				}
			}
			return new Board(res_board, res_num, nr, nc, prev);
		}
	}
	
	public static void Game(char[][] b, int r, int c) {
		Queue<Board> q = new ArrayDeque<>();
		
		q.add(new Board(b, 0, r, c, ' '));
		
		while(!q.isEmpty()) {
			Board tmp = q.poll();
			char[][] board = tmp.board;
			char prev = tmp.prev;
			int num = tmp.num;

			if(prev == 'P') {
				if(num < res) res = num;
				continue;
			}
			if(prev == 'F') continue;
			if(num >= 10) continue;
			
			int tr = tmp.r;
			int tc = tmp.c;
			
			if(prev != 'U' && prev != 'D' ) {
				q.add(tmp.Up());
			}
				
			if(prev != 'D' && prev != 'U' ) {
				q.add(tmp.Down());
			}
				
			if(prev != 'L' && prev != 'R' ) {
				q.add(tmp.Left());
			}
				
			if(prev != 'R' && prev != 'L') {
				q.add(tmp.Right());
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N,M: 보드 크기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// board: 보드 정보 저장하는 2차원 배열
		char[][] board = new char[N][M];
		
		int row = 0;		// 빨간 공의 위치 정보 저장
		int column = 0;		// 빨간 공의 위치 정보 저장
		
		// 보드 정보 입력
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				board[i][j] = c;
				if(c == 'R') {
					row = i;
					column = j;
				}
			}
		}
		
		res = 11;

		Game(board, row, column);
		
		if(res == 11) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}
}