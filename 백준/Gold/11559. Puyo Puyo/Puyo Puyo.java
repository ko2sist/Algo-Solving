import java.util.*;
import java.io.*;

// #BJ 11559 - Puyo Puyo
// Strategy: 

public class Main {
	static char[][] field;
	static boolean check;	// 현재 단계에서 같은 색 뿌요가 4개이상인 그룹이 발견되는지 체크
	static boolean[][] visited;
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
	
	public static void BFS(int row, int col) {
		Queue<Point> q = new ArrayDeque<>();
		List<Point> group = new ArrayList<>();
		
		char color = field[row][col];
		Point p = new Point(row,col);
		q.add(p);
		group.add(p);
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int tr = tmp.row;
			int tc = tmp.col;
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
				if(visited[nr][nc]) continue;
				if(field[nr][nc] != color) continue;
				
				Point add = new Point(nr,nc);
				q.add(add);
				group.add(add);
				visited[nr][nc] = true;
			}
		}
		
		// 4개 이상의 그룹이면 뿌요 삭제
		if(group.size() >= 4) {
			check = true;
			for(Point remove : group) {
				field[remove.row][remove.col] = '.';
			}
		}
	}
	
	public static void gravity() {
		for(int j=0; j<6; j++) {
			Stack<Character> s = new Stack<>();
			for(int i=0; i<12; i++) {
				if(field[i][j] != '.') {
					s.add(field[i][j]);
				}
			}
			
			for(int i=11; i>=0; i--) {
				if(!s.isEmpty()) {
					field[i][j] = s.pop();
				}else {
					field[i][j] = '.';
				}
			}
		}
	}
	
	public static int getChain() {
		int chain = 0;
		
		while(true) {
			check = false;
			visited = new boolean[12][6];
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(!visited[i][j] && field[i][j] != '.') {
						BFS(i,j);
					}
				}
			}
			
			if(!check) break;
			chain++;
			gravity();
			
//			for(char[] line: field) {
//				System.out.println(Arrays.toString(line));
//			}
//			System.out.println();
		}
		
		return chain;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 필드 정보 입력
		field = new char[12][6];
		for(int i=0; i<12; i++) {
			String line = br.readLine();
			for(int j=0; j<6; j++) {
				field[i][j] = line.charAt(j);
			}
		}
		
		System.out.println(getChain());
	}
}
