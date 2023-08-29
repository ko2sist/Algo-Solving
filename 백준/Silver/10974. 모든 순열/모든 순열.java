import java.util.*;
import java.io.*;

// BJ #10974 - 모든 순열
// Strategy: 백트래킹
public class Main {
	static int N, max;
	static int[] nums;
	static StringBuilder sb;
	
	public static void back(int len, int[] selected, boolean[] visited) {
		if(len == N) {
			for(int i=0; i<N; i++) {
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
		
		N = Integer.parseInt(br.readLine());
		
		max = Integer.MIN_VALUE;
		
		int[] selected = new int[N];
		boolean[] visited = new boolean[N+1];
		
		back(0,selected, visited);
		
		System.out.println(sb);
	}
}
