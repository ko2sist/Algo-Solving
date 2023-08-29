import java.util.*;
import java.io.*;

// BJ #6603 - 로또
// Strategy: 백트래킹
public class Main {
	static StringBuilder sb;
	static int[] nums;
	static int N;
	
	public static void back(int len, int[] selected, boolean[] visited) {
		if(len == 6) {
			for(int i=0; i<6; i++) {
				sb.append(nums[selected[i]]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if(len == 0) {
			for(int i=0; i<N; i++) {
				selected[len] = i;
				visited[i] = true;
				back(len+1, selected, visited);
				visited[i] = false;
			}
		}else {
			for(int i = selected[len-1]; i<N; i++) {
				if(!visited[i]) {
					selected[len] = i;
					visited[i] = true;
					back(len+1, selected, visited);
					visited[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			nums = new int[N];
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			int[] selected = new int[6];
			boolean[] visited = new boolean[N];
			back(0,selected,visited);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
