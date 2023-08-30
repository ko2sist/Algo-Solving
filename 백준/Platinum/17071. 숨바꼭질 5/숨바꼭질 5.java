import java.io.*;
import java.util.*;

// BJ #17071 - 숨바꼭질 5
// Strategy: BFS
public class Main {
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 최종 결과 출력
		System.out.println(BFS(N,K));
	}

	public static int BFS(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[2][500001];
		int time = 0;
		int goal = k;
		
		q.add(n);
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			int check = time % 2;
			
			while(size-- > 0) {
				int tmp_point = q.poll();

				if(tmp_point == goal) return time;
				
				
				if(tmp_point * 2 <= 500000 && !visited[check][tmp_point*2]) {
					q.add(tmp_point*2);
					visited[check][tmp_point*2] = true;
				}
				if(tmp_point + 1 <= 500000 && !visited[check][tmp_point+1]) {
					q.add(tmp_point+1);
					visited[check][tmp_point+1] = true;
				}
				if(tmp_point - 1 >= 0 && !visited[check][tmp_point-1]) {
					q.add(tmp_point-1);
					visited[check][tmp_point-1] = true;
				}
				
			}
			time++;
			goal += time;
			if(goal > 500000) return -1;
			if(visited[check][goal]) return time;
			
		}
		return -1;
	}

}