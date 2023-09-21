import java.util.*;
import java.io.*;

// SWEA #1249 - 보급로
// Strategy: Dijkstra

public class Solution {
	static final int INF = (int)1e9;
	static int N;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	
	public static class Node implements Comparable<Node>{
		int row;
		int col;
		int dist;
		
		public Node(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	public static class Point{
		int row;
		int col;
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static int Dijkstra() {
		int[][] dist = new int[N][N];
		for(int[] line: dist) {
			Arrays.fill(line, INF);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist[0][0] = 0;
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int tr = tmp.row;
			int tc = tmp.col;
			int td = tmp.dist;
			
			if(dist[tr][tc] < td) continue;
			
			for(int i=0; i<4; i++) {
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				int nd = td + map[nr][nc];
				
				if(dist[nr][nc] > nd) {
					dist[nr][nc] = nd;
					pq.add(new Node(nr,nc,nd));
				}
			}
		}
		
		return dist[N-1][N-1];
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	// N: 지도 크기
        	N = Integer.parseInt(br.readLine());
        	
        	// 지도 정보 입력
        	map = new int[N][N];
        	for(int i=0; i<N; i++) {
        		String s = br.readLine();
        		for(int j=0; j<N; j++) {
        			map[i][j] = s.charAt(j)-'0';
        		}
        	}
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t+" ").append(Dijkstra()).append("\n");
        }
        // 최종 결과 출력
        System.out.println(sb);
    }
}