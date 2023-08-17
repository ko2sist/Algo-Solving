import java.io.*;
import java.util.*;

// BJ #9019 - DSLR
// Strategy: BFS 응용?
public class Main {
	public static int D(int n) {
		return (n * 2) % 10000;
	}

	public static int S(int n) {
		if (n == 0) {
			return 9999;
		} else {
			return n - 1;
		}
	}

	public static int L(int n) {
		int[] d = new int[4];
		for (int i = 0; i < 4; i++) {
			d[i] = n % 10;
			n /= 10;
		}

		return d[3] + d[0] * 10 + d[1] * 100 + d[2] * 1000;
	}

	public static int R(int n) {
		int[] d = new int[4];
		for (int i = 0; i < 4; i++) {
			d[i] = n % 10;
			n /= 10;
		}

		return d[1] + d[2] * 10 + d[3] * 100 + d[0] * 1000;
	}

	public static class Cmd {
		int n;
		String s;

		public Cmd(int n, String s) {
			this.n = n;
			this.s = s;
		}
	}

	public static String find(int n1, int n2) {
		Queue<Cmd> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];

		q.add(new Cmd(n1, ""));
		String res = "";
		
		while (!q.isEmpty()) {
			Cmd tmp = q.poll();
			int tmp_n = tmp.n;
			String tmp_s = tmp.s;
			
			int n_D = D(tmp_n);
			String s_D = tmp_s + "D";
			if (n_D == n2) {
				res = s_D;
				break;
			}else if(!visited[n_D]){
				q.add(new Cmd(n_D, s_D));
				visited[n_D] = true;
			}
			
			int n_S = S(tmp_n);
			String s_S = tmp_s + "S";
			if (n_S == n2) {
				res = s_S;
				break;
			}else if(!visited[n_S]){
				q.add(new Cmd(n_S, s_S));
				visited[n_S] = true;
			}
			
			int n_L = L(tmp_n);
			String s_L = tmp_s + "L";
			if (n_L == n2) {
				res = s_L;
				break;
			}else if(!visited[n_L]){
				q.add(new Cmd(n_L, s_L));
				visited[n_L] = true;
			}
			
			int n_R = R(tmp_n);
			String s_R = tmp_s + "R";
			if (n_R == n2) {
				res = s_R;
				break;
			}else if(!visited[n_R]){
				q.add(new Cmd(n_R, s_R));
				visited[n_R] = true;
			}	
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			sb.append(find(n1,n2)).append("\n");

		}

		// 최종 결과 출력
		System.out.print(sb);
	}
}