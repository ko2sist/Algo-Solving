import java.util.*;
import java.io.*;

// BJ #16953 - A->B
// Strategy: 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int res = 1;
		
		while(true) {
			if(A == B) break;
			if(B < A) {
				res = -1;
				break;
			}
			
			if(B%10 == 1) {
				B = (B-1) / 10;
				res++;
			}else if(B%2 == 0) {
				B = B / 2;
				res++;
			}else {
				res = -1;
				break;
			}
		}
		
		System.out.println(res);
	}
}