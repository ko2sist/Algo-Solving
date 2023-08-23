import java.util.*;
import java.io.*;

// BJ #15652 - N과 M (4)
// Strategy: Backtracking
public class Main {
	static StringBuilder sb;
	static int N,M;
	
	public static void NM4(int[] selected, int len) {
		if(len == M) {
			for(int i=1; i<=M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(i >= selected[len]) {
				selected[len+1] = i;
				NM4(selected, len+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] selected = new int[M+1];
		NM4(selected, 0);
		System.out.println(sb);
	}
}