import java.util.*;
import java.io.*;

// BJ #11054 - 가장 긴 바이토닉 부분 수열
// Strategy: DP(LIS)

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp_f = new int[N];
        int[] dp_b = new int[N];
        
        for(int i=0; i<N; i++) {
        	dp_f[i] = 1;
        	for(int j=0; j<i; j++) {
        		if(nums[j] < nums[i]) {
        			dp_f[i] = Math.max(dp_f[i], dp_f[j]+1);
        		}
        	}
        }
        
        for(int i=N-1; i>=0; i--) {
        	dp_b[i] = 1;
        	for(int j=N-1; i<j; j--) {
        		if(nums[j] < nums[i]) {
        			dp_b[i] = Math.max(dp_b[i], dp_b[j]+1);
        		}
        	}
        }
        
        int max = 0;
        for(int i=0; i<N; i++) {
        	int tmp = dp_f[i] + dp_b[i] - 1;
        	if(tmp > max) max = tmp;
        }
        System.out.println(max);
    }
}