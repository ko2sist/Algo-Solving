import java.util.*;
import java.io.*;

// SWEA #1247 - 최적경로
// Strategy: 백트래킹
public class Solution {
	static int N, min, size;
	static List<Point> client;
	static Point company, home;
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int dist(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	public static void back(int num, int sum, int prev_x, int prev_y, boolean[] visited) {
		if(sum >= min) return;
		
		if(num == N+2) {
//			if(sum < min) min = sum;
			min = sum;
			return;
		}
		
		if(num == N+1) {
			Point prev = new Point(prev_x, prev_y);
			int dist = dist(prev, home);
			back(num+1, sum+dist, home.x, home.y, visited);
		}
		
		
		for(int i=0; i<size; i++) {
			if(!visited[i]) {
				Point prev = new Point(prev_x, prev_y);
				Point tmp = client.get(i);
				int dist = dist(prev, tmp);
				visited[i] = true;
				back(num+1, sum+dist, tmp.x, tmp.y, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			
			client = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N+2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(i == 0) {
					company = new Point(x,y);
				}else if(i == 1) {
					home = new Point(x,y);
				}else {
					client.add(new Point(x,y));
				}
			}
			
			size = client.size();
			min = Integer.MAX_VALUE;
			
			boolean[] visited = new boolean[N];
			
			back(1, 0, company.x, company.y, visited);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
