import java.util.*;
import java.io.*;

// BJ #14921 - 용액 합성하기
// Strategy: 

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		
		int left = 0;
		int right = N-1;
		
		int num_left = nums[left];
		int num_right = nums[right];
		
		while(left < right) {
			int tmp = nums[left] + nums[right];
			
			if(Math.abs(tmp) < Math.abs(min)) {
				min = tmp;
				num_left = nums[left];
				num_right = nums[right];
			}
			
			if(tmp > 0) right--;
			if(tmp < 0) left++;
			if(tmp == 0) break;
		}
		
		System.out.println(num_left+num_right);
	}
}