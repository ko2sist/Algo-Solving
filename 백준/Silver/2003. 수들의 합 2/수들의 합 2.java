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
        for(int i=0; i<N; i++) {
        	int sum = 0;
        	for(int j=i; j<N; j++) {
        		sum += nums[j];
        		if(sum == M) {
        			result++;
        			break;
        		}
        	}
        }
        
        System.out.println(result);
	}
}