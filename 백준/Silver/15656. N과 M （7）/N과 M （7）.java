import java.io.*;
import java.util.*;

// BJ #15656
public class Main {
	public static StringBuilder maker(int[] nums, int len) {
		StringBuilder sb = new StringBuilder();
		String result = "";
		if(len == 1) {
			for(int i=0; i<nums.length; i++) {
				sb.append(nums[i]);
				sb.append("\n");
			}
			return sb;
		} else {
			sb = maker(nums, len-1);
			String[] sb_arr = sb.toString().split("\n");
			sb.setLength(0); // sb 초기화
			int ln = nums.length;
			int ls = sb_arr.length;
			
			for(int i=0; i<ln; i++) {
				for(int j=0; j<ls; j++) {
					sb.append(nums[i]);
					sb.append(" "); 
				    sb.append(sb_arr[j]);
				    sb.append("\n");
				}
			}
			return sb;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		System.out.print(maker(nums, M));
	}
}
