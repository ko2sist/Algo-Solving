import java.util.*;
import java.io.*;

// BJ #15686 - 치킨 배달
// Strategy: 백트래킹
public class Main {
	static int N,M;
	static int[][] map;
	static int max_len;
	static int size;
	static int min;
	static List<Point> house, chicken;
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static int distance(Point p1, Point p2) {
		return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);
	}
	
	public static int cal(int[] selected) {
		int res = 0;
		
		for(int i=0; i<house.size(); i++) {
			int m = Integer.MAX_VALUE;
			for(int j=1; j<=M; j++) {
				int tmp = distance(house.get(i), chicken.get(selected[j]));
				if(tmp < m) m = tmp;
			}
			res += m;
		}
		
		return res;
	}
	
	public static void back(int len, int[] selected, boolean[] visited) {
		if(len == M+1) {
			int c = cal(selected);
			if(c < min) min = c;
			return;
		}
		
		
		for(int i=selected[len-1]; i<size; i++) {
			if(!visited[i]) {
				selected[len] = i;
				visited[i] = true;
				back(len+1, selected, visited);
				visited[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chicken.add(new Point(i,j));
				}else if(map[i][j] == 1) {
					house.add(new Point(i,j));
				}
				
			}
		}
		
		size = chicken.size();
		max_len = M;
		min = Integer.MAX_VALUE;
		
		int[] selected = new int[M+1];
		boolean[] visited = new boolean[size];
		selected[0] = 0;
		
		back(1,selected,visited);
		
		System.out.println(min);
	}
}
