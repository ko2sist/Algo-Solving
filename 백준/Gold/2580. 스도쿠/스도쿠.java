import java.util.*;
import java.io.*;

// BJ #2580 - 스도쿠
// Strategy: 백트래킹
public class Main {
	static List<Point> zeros;
	static int[][] board;
	static int max_len;
	static StringBuilder sb;
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static boolean checkRow(int r, int n) {
		for(int i=0; i<9; i++) {
			if(board[r][i] == n) {
				return false;
			}
		}
		
		return true;
	}
	public static boolean checkCol(int c, int n) {
		for(int i=0; i<9; i++) {
			if(board[i][c] == n) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkBox(int r, int c, int n) {
		int qr = r/3;
		int qc = c/3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[3*qr+i][3*qc+j] == n) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static void back(int len) {
		if(len == max_len) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
			return;
		}
		
		for(int i=1; i<=9; i++) {
			Point tmp = zeros.get(len);
			int tr = tmp.row;
			int tc = tmp.col;
			
			if(!checkRow(tr, i)) continue;
			if(!checkCol(tc, i)) continue;
			if(!checkBox(tr, tc, i)) continue;
			
			board[tr][tc] = i;
			back(len+1);
			board[tr][tc] = 0;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		board = new int[9][9];
		zeros = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) {
					zeros.add(new Point(i,j));
				}
			}
		}
		
		max_len = zeros.size();
		back(0);
	}
}
