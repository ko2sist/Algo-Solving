import java.util.*;
import java.io.*;

// BJ #4485 - 녹색 옷 입은 애가 젤다지?
// Strategy: 다익스트라

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N, min;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static class Point implements Comparable<Point>{
		int row;
		int col;
		int dist;
		
		public Point(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist-o.dist;
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        		
        int p = 1;
        while(true) {
        	N = Integer.parseInt(br.readLine());
        	if(N==0) break;
        	
        	map = new int[N][N];
        	for(int i=0; i<N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int[][] dist = new int[N][N];
        	for(int[] line:dist) {
        		Arrays.fill(line, INF);
        	}
        	
        	PriorityQueue<Point> pq = new PriorityQueue<>();
        	pq.add(new Point(0,0,map[0][0]));
        	dist[0][0] = map[0][0];
        	
        	
        	while(!pq.isEmpty()) {
        		Point tmp = pq.poll();
        		int tr = tmp.row;
        		int tc = tmp.col;
        		int td = tmp.dist;
        		
        		for(int i=0; i<4; i++) {
        			int nr = tr + dr[i];
        			int nc = tc + dc[i];
        			
        			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
        			
        			if(dist[nr][nc] > td + map[nr][nc]) {
        				dist[nr][nc] = td + map[nr][nc];
        				pq.add(new Point(nr,nc,dist[nr][nc]));
        			}
        		}
        	}
        	
//        	for(int[] line: dist) {
//        		System.out.println(Arrays.toString(line));
//        	}
//        	System.out.println();
        	
        	sb.append("Problem ").append(p).append(": ").append(dist[N-1][N-1]).append("\n");
        	p++;
        }
        System.out.println(sb);
	}
}