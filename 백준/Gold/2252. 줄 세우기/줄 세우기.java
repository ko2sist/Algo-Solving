import java.util.*;
import java.io.*;
import java.math.BigInteger;

// BJ #2252 - 줄 세우기
// Strategy: 위상정렬(DFS)

public class Main {
	static int N, M;
	static List<List<Integer>> graph;
	static boolean[] visited;
	static Stack<Integer> stack;
	
	public static void dfs(int n) {
		visited[n] = true;
		
		for(int v : graph.get(n)) {
			if(!visited[v]) {
				dfs(v);
			}
		}
		stack.add(n);
	}
	
	public static void TS() {
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
		}
		
		visited = new boolean[N+1];
		stack = new Stack<>();
		
		TS();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
		
	}
}