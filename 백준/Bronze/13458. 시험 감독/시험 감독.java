import java.io.*;
import java.util.*;

// BJ #13458 - 시험감독
// Strategy: 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        long res = N;
        for(int i=0; i<N; i++) {
        	int tmp = nums[i]-B;
        	if(tmp > 0) {
        		if(tmp % C != 0) {
        			res += (nums[i]-B)/C + 1;
        		}else {
        			res += (nums[i]-B)/C;
        		}
        	}
        }
        
        System.out.println(res);
    }
}