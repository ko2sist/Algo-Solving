import java.util.*;
import java.io.*;

// BJ #15649 - N과 M(1)
// Strategy: 백트래킹
public class Main {
	static int N, M;
	static StringBuilder sb;
	
	public static void back(int len, int[] selected, boolean[] visited) {
		if(len == M){
			for(int i=0; i<len; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				selected[len] = i;
				visited[i] = true;
				back(len+1, selected, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] selected = new int[M];
		boolean[] visited = new boolean[N+1];
		
		back(0, selected, visited);
		
		System.out.println(sb);
	}
}
