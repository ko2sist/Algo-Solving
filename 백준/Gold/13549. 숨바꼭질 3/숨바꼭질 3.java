import java.io.*;
import java.util.*;

// BJ #13549 - 숨바꼭질 3
// Strategy: BFS
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 최종 결과 출력
		if (K <= N) {
			System.out.println(N - K);
		} else {
			System.out.print(BFS(N, K));
		}
	}

	public static class Pair implements Comparable<Pair> {
		int point;
		int time;
		int uid;

		public Pair(int point, int time, int uid) {
			this.point = point;
			this.time = time;
			this.uid = uid;
		}

		public int compareTo(Pair o) {
			if (this.time != o.time) {
				return this.time - o.time;
			} else {
				return this.uid - o.uid;
			}
		}
	}

	public static int BFS(int n, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[100001];

		int uid = 0;
		pq.add(new Pair(n, 0, uid++));

		while (!pq.isEmpty()) {
			Pair tmp = pq.poll();
			int tmp_point = tmp.point;
			int tmp_time = tmp.time;
			
			if(tmp_point == k) {
				return tmp_time;
			}
			visited[tmp_point] = true;

			if (tmp_point * 2 <= 100000) {
				if (!visited[tmp_point * 2]) {
					pq.add(new Pair(tmp_point * 2, tmp_time, uid++));
				}
			}

			if (tmp_point + 1 <= 100000) {
				if (!visited[tmp_point + 1]) {
					pq.add(new Pair(tmp_point + 1, tmp_time + 1, uid++));
				}
			}

			if (tmp_point - 1 >= 0) {
				if (!visited[tmp_point - 1]) {
					pq.add(new Pair(tmp_point - 1, tmp_time + 1, uid++));
					uid++;
				}
			}

		}
		return 0;
	}

}