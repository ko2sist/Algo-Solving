import java.util.*;
import java.io.*;

// BJ #10819 - 차이를 최대로
// Strategy: 백트래킹
public class Main {
	static int N, max;
	static int[] nums;
	
	
	public static int cal(int[] selected) {
		int res = 0;
		
		for(int i=0; i<N-1; i++) {
			res += Math.abs(nums[selected[i]]-nums[selected[i+1]]);
		}
		
		return res;
	}
	public static void back(int len, int[] selected, boolean[] visited) {
		if(len == N) {
			int res = cal(selected);
			if(res > max) max = res;
			return;
		}
		
		
		for(int i=0; i<N; i++) {
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
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		
		int[] selected = new int[N];
		boolean[] visited = new boolean[N];
		
		back(0,selected, visited);
		
		System.out.println(max);
	}
}
