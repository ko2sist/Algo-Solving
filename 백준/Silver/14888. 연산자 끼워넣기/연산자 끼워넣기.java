import java.util.*;
import java.io.*;

// BJ #14888 - 연산자 끼워넣기
// Strategy: 백트래킹
public class Main {
	static int N;
	static int max, min;
	static int[] nums, ops;
	
	public static void back(int len, int cal) {
		if(len == N) {
			if(cal > max) max = cal;
			if(cal < min) min = cal;
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(ops[i] != 0) {
				ops[i]--;
				if(i==0) {
					back(len+1, cal+nums[len]);
				}else if(i == 1) {
					back(len+1, cal-nums[len]);
				}else if(i == 2) {
					back(len+1, cal*nums[len]);
				}else {
					back(len+1, cal/nums[len]);
				}
				ops[i]++;
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
		
		ops = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		back(1, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
}
