import java.util.*;
import java.io.*;

// BJ #1182 - 부분수열의 합
// Strategy: 백트래킹
public class Main {
	static int N,S;
	static int[] nums;
	static int res;
	
	public static void back(int max_len, int len, int[] selected, boolean[] visited) {
		if(len == max_len) {
			int sum = 0;
			for(int i=0; i<len; i++) {
				sum += nums[selected[i]];
			}
			if(sum == S) res++;
			return;
		}
		
		if(len == 0) {
			for(int i=0; i<N; i++) {	
				selected[len] = i;
				visited[i] = true;
				back(max_len, len+1, selected, visited);
				visited[i] = false;
			}
		}else {
			for(int i=selected[len-1]; i<N; i++) {
				if(!visited[i]) {
					selected[len] = i;
					visited[i] = true;
					back(max_len, len+1, selected, visited);
					visited[i] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		res = 0;
		for(int i=1; i<=N; i++) {
			boolean[] visited = new boolean[N];
			int[] selected = new int[i];
			
			back(i,0,selected,visited);
		}
		System.out.println(res);
	}
}
