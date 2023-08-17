import java.io.*;
import java.util.*;

// BJ #7569 - 토마토
// Strategy: 그래프(3차원 배열), BFS
public class Main {
	static int M,N,H;
	static int[][][] box, res;
	static boolean[][][] visited;
	static int[] dh = {1,-1,0,0,0,0};
	static int[] dr = {0,0,-1,0,1,0};
	static int[] dc = {0,0,0,1,0,-1};
	
	public static class Point{
		int row;
		int column;
		int height;
		
		public Point(int height, int row, int column) {
			this.row = row;
			this.column = column;
			this.height = height;
		}
	}
	
	public static void BFS(List<Point> list) {
		Queue<Point> q = new LinkedList<>();
		
		for(int i=0; i<list.size(); i++) {
			Point tmp = list.get(i);
			q.add(tmp);
			visited[tmp.height][tmp.row][tmp.column] = true;
			res[tmp.height][tmp.row][tmp.column] = 1;
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-->0) {
				Point tmp = q.poll();
				
				for(int i=0; i<6; i++) {
					int nh = tmp.height + dh[i];
					int nr = tmp.row + dr[i];
					int nc = tmp.column + dc[i];
					
					if(nh <= 0 || nr <= 0 || nc <= 0 || nh > H || nr > N || nc > M) continue;
					if(box[nh][nr][nc] != 0) continue;
					if(visited[nh][nr][nc]) continue;
					
					q.add(new Point(nh,nr,nc));
					visited[nh][nr][nc] = true;
					res[nh][nr][nc] = res[tmp.height][tmp.row][tmp.column] + 1;
				}
			}
		}
		
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H+1][N+1][M+1];
        res = new int[H+1][N+1][M+1];
        visited = new boolean[H+1][N+1][M+1];
        
        List<Point> list = new ArrayList<>();	// 초기에 익은 토마토 정보 저장하는  list
        
        // 토마토 정보 저장
        for(int i=1; i<=H; i++) {
        	for(int j=1; j<=N; j++) {
        		st = new StringTokenizer(br.readLine());
        		for(int k=1; k<=M; k++) {
        			int tmp = Integer.parseInt(st.nextToken());
        			box[i][j][k] = tmp;
        			if(tmp == 1) {
        				list.add(new Point(i,j,k));
        			}
        		}
        	}
        }
        
        // BFS 실행
        BFS(list);
        
        // 결과 저장, 토마토가 존재하지만 미방문한 자리가 있으면 -1 출력
        int max = 0;
        loop: for(int i=1; i<=H; i++) {
        	for(int j=1; j<=N; j++) {
        		for(int k=1; k<=M; k++) {
        			int tmp = res[i][j][k];
        			if(tmp == 0 && box[i][j][k] != -1) {
        				max = -1;
        				break loop;
        			}
        			
        			if(tmp >= max) {
        				max = tmp;
        			}
        		}
        	}
        }
        
        // 최종 결과 출력
        if(max != -1) {
        	System.out.println(max-1);
        }else {
        	System.out.println(max);
        } 
    }
}