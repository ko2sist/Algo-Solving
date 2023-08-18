import java.io.*;
import java.util.*;

// BJ #15663 - N과 M (9)
// Strategy: 백트래킹
public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb;
	
	public static void NM9(boolean[] visited, int[] selected, int len) {
		if(len == M) {
			for(int i=0; i<M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(i>=1 && arr[i] == arr[i-1] && !visited[i-1]) continue;
			if(!visited[i]) {
				selected[len] = arr[i];
				visited[i] = true;
				NM9(visited, selected, len+1);
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
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		boolean[] visited = new boolean[N];
		int[] selected = new int[M];
		
		NM9(visited, selected, 0);
		
		// 최종 결과 출력
		System.out.print(sb);
	}
}