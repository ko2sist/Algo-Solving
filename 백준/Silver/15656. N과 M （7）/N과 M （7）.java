import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
//	static boolean[] visited;
	static int[] arr;
	static int[] brr;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];	//주의
		brr = new int[M];
//		visited = new boolean[N];

		for (int i = 0; i < N; i++) {	//주의
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		dfs(0);
		System.out.println(sb);

	}

	public static void dfs(int depth) {

		if (depth == M) {
			for (int val : brr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
//			if (!visited[i]) {
//				visited[i] = true;
				brr[depth] = arr[i];
				dfs(depth + 1);
//				visited[i] = false;
//			}
		}
	}
}