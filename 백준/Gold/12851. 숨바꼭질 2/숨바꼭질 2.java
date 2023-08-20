import java.io.*;
import java.util.*;

// BJ #12851 - 숨바꼭질 2
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
		if (K <= N) {
			sb.append(N-K).append("\n");
			sb.append(1);
		} else {
			BFS(N, K);
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

	public static void BFS(int n, int k) {
		Queue<Pair> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];

		int uid = 0;
		q.add(new Pair(n, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			int res = 0;
			
			while(size-- > 0) {
				Pair tmp = q.poll();
				int tmp_point = tmp.point;
				int tmp_time = tmp.time;
				
				if(tmp_point == k) {
					res++;
				}
				visited[tmp_point] = true;

				if (tmp_point * 2 <= 100000) {
					if (!visited[tmp_point * 2]) {
						q.add(new Pair(tmp_point * 2, tmp_time + 1));
					}
				}

				if (tmp_point + 1 <= 100000) {
					if (!visited[tmp_point + 1]) {
						q.add(new Pair(tmp_point + 1, tmp_time + 1));
					}
				}

				if (tmp_point - 1 >= 0) {
					if (!visited[tmp_point - 1]) {
						q.add(new Pair(tmp_point - 1, tmp_time + 1));
					}
				}
				
				if(size == 0 && res != 0) {
					sb.append(tmp_time).append("\n");
					sb.append(res);
					return;
				}
			}
		}
	}

}