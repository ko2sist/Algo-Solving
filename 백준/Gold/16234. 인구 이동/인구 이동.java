import java.util.*;
import java.io.*;

// BJ #16234 - 인구 이동
// Strategy: BFS
public class Main {
	static int N,L,R;
	static int[][] nums;
	static boolean[][] visited;
	static boolean check;
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
	
	public static int BFS(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		int sum = nums[r][c];
		int num = 1;
		List<Point> union = new ArrayList<>();
		
		
		q.add(new Point(r,c));
		visited[r][c] = true;
		union.add(new Point(r,c));
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int tr = tmp.row;
			int tc = tmp.col;
			int tp = nums[tr][tc];
			
			for(int i=0; i<4; i++) {
				int nr = tr+dr[i];
				int nc = tc+dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc]) continue;
				
				int np = nums[nr][nc];
				if(Math.abs(np-tp) < L || Math.abs(np-tp) > R) continue;
				
				Point p = new Point(nr,nc);
				q.add(p);
				union.add(p);
				visited[nr][nc] = true;
				num++;
				sum += nums[nr][nc];
				
			}
		}
		
		int n = sum/num;
		for(int i=0; i<union.size(); i++) {
			Point tmp = union.get(i);
			nums[tmp.row][tmp.col] = n;
		}
		
		return num;
	}
	
	public static int move() {
		int day = 0;
		while(true) {
			visited = new boolean[N][N];
			check = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]){
						int u = BFS(i,j);
						for(int[] line: nums) {
						}
						if(u > 1) check = true;
					}
				}
			}
			
			if(!check) break;
			day++;
		}
		
		return day;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        nums = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		nums[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        System.out.println(move());
    }
}