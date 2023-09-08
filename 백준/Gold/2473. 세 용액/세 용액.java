import java.util.*;
import java.io.*;

// BJ #2473 - 세 용액
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
		
		Arrays.sort(nums);
		
		long min = Long.MAX_VALUE;
		int[] sel = new int[3];
		
		loop :for(int i=0; i<N-2; i++) {
			int left = i+1;
			int right = N-1;
			
			while(left < right) {
				long tmp = (long)nums[i] + (long)nums[left] + (long)nums[right];
				
				if(Math.abs(tmp) < Math.abs(min)) {
					min = tmp;
					sel[0] = nums[i];
					sel[1] = nums[left];
					sel[2] = nums[right];
				}
				
				if(tmp > 0) {
					right--;
				}else {
					left++;
				}
			}
			
		}
		
		Arrays.sort(sel);
		System.out.println(sel[0]+" "+sel[1]+" "+sel[2]);
		
		
	}
}