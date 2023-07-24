import java.io.*;
import java.util.*;

// BJ #11866
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        Arrays.fill(nums, 1);
        
        int out_cnt = 0;
        int num_cnt = 1;
        int idx = 0;
        sb.append("<");
        while(out_cnt < N) {
        	if(num_cnt == K) {
        		if(nums[idx%N]==1) {
        			out_cnt++;
        			nums[idx%N] = 0;
        			sb.append(idx%N+1);
        			sb.append(", ");
        			num_cnt = 1;
        		}
        	}else {
        		if(nums[idx%N]==1) {
        			num_cnt++;
        		}
        	}
        	idx++;
        }
        
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        System.out.println(sb);
    }
}