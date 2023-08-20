import java.io.*;
import java.util.*;

// BJ #13913 - 숨바꼭질 4
// Strategy: BFS
public class Main {
	static StringBuilder sb;
	static int[] prev;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 최종 결과 출력
		if (K <= N) {
			sb.append(N - K).append("\n");
			for (int i = N; i >= K; i--) {
				sb.append(i).append(" ");
			}
		} else {
			int res = BFS(N, K);
			sb.append(res).append("\n");
			int[] route = new int[res+1];
			
			int idx = K;
			route[res] = K;
			
		    for(int i=res-1; i>=0; i--) {
		    	route[i] = prev[idx];
		    	idx = prev[idx];
		    }
		    for(int i=0; i<=res; i++) {
		    	sb.append(route[i]).append(" ");
		    }

		}

		System.out.println(sb);
	}

	public static class Pair {
		int point;
		int time;
	
		public Pair(int point, int time) {
			this.point = point;
			this.time = time;
		}
	}

	public static int BFS(int n, int k) {
		Queue<Pair> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		prev = new int[100001];
		
		q.add(new Pair(n, 0));
		visited[n] = true;
		
		while (!q.isEmpty()) {
			Pair tmp = q.poll();
			int tmp_point = tmp.point;
			int tmp_time = tmp.time;


			if (tmp_point * 2 <= 100000) {
				if(tmp_point*2 == k) {
					prev[tmp_point * 2] = tmp_point;
					return tmp_time+1;
				}
				if (!visited[tmp_point * 2]) {
					q.add(new Pair(tmp_point * 2, tmp_time + 1));
					visited[tmp_point*2] = true;
					prev[tmp_point * 2] = tmp_point;
				}
			}

			if (tmp_point + 1 <= 100000) {
				if(tmp_point+1 == k) {
					prev[tmp_point+1] = tmp_point;
					return tmp_time+1;
				}
				if (!visited[tmp_point + 1]) {
					q.add(new Pair(tmp_point + 1, tmp_time + 1));
					visited[tmp_point+1] = true;
					prev[tmp_point+1] = tmp_point;
				}
			}

			if (tmp_point - 1 >= 0) {
				if(tmp_point-1 == k) {
					prev[tmp_point-1] = tmp_point;
					return tmp_time+1;
				}
				if (!visited[tmp_point - 1]) {
					q.add(new Pair(tmp_point - 1, tmp_time + 1));
					visited[tmp_point-1] = true;
					prev[tmp_point-1] = tmp_point;
				}
			}
		}
		return 0;
	}
}

