import java.util.*;
import java.io.*;

// BJ #2003 - 수들의 합 2
// Strategy: 

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
	
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        int end = 0;
        int sum = 0;
        
        for(int start=0; start<N; start++) {
        	while(sum < M && end < N) {
        		sum += nums[end];
        		end++;
        	}
        	
        	if(sum == M) result++;
        	
        	sum -= nums[start];
        }
        
        System.out.println(result);
	}
}