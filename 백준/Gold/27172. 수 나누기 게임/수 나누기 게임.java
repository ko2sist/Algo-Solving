import java.util.*;
import java.io.*;

// BJ #27172 - 수 나누기 게임
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		
		int[] res = new int[1000001];
		boolean[] check = new boolean[1000001];
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			check[tmp] = true;
			nums[i] = tmp;
		}
		
		for(int i=0; i<N; i++) {
			int cnt = 2;
			int n = nums[i];
			while(n*cnt <= 1000000) {
				if(check[n*cnt]) {
					res[n]++;
					res[n*cnt]--;
				}
				cnt++;
			}
		}
		

		for(int i=0; i<N; i++) {
			sb.append(res[nums[i]]).append(" ");
		}
		System.out.println(sb);
	}
}
