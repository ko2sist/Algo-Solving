import java.util.*;
import java.io.*;
import java.math.BigInteger;

// BJ #9466 - 텀 프로젝트
// Strategy: 백트래킹(dfs)?

public class Main {
	static int n, res;
	static int[] graph;
	static boolean[] visited, checked;
	
	public static void dfs(int n) {
		if(checked[n]) return;
		
		if(visited[n]) {
			checked[n] = true;
			res++;
		}
		
		visited[n] = true;
		dfs(graph[n]);
		checked[n] = true;
		visited[n] = false;
	}
	
	public static void check() {		
		for(int i=1; i<=n; i++) {
			if(!checked[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			
			graph = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				int v = Integer.parseInt(st.nextToken());
				graph[i] = v;
			}
			
			checked = new boolean[n+1];
			visited = new boolean[n+1];
			res = 0;
			check();
			sb.append(n-res).append("\n");
		}
		System.out.println(sb);
	}
}