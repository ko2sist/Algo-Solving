import java.util.*;
import java.io.*;

// BJ #15657 - N과 M (8)
// Strategy: Backtracking
public class Main {
	static StringBuilder sb;
	static int N,M;
	static int[] nums;
	
	public static void NM4(int[] selected, int len) {
		if(len == M) {
			for(int i=1; i<=M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(nums[i] >= selected[len]) {
				selected[len+1] = nums[i];
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
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int[] selected = new int[M+1];
		NM4(selected, 0);
		System.out.println(sb);
	}
}