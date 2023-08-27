import java.io.*;
import java.util.*;

// BJ #14002 - 가장 긴 증가하는 부분 수열4
// Strategy: LIS + Binary Search
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		int[] lis = new int[N];
		int[] check = new int[N];
		int len = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			num[i] = tmp;
			
			if(i == 0) {
				lis[0] = tmp;
				len++;
			}else {
				if(lis[len-1] < tmp) {
					lis[len] = tmp;
					check[i] = len;
					len++;
				}else {
					int start = 0;
					int end = len-1;
					while(start < end) {
						int mid = (start+end) / 2;
						if(tmp > lis[mid]) {
							start = mid+1;
						}else {
							end = mid;
						}
					}
					lis[start] = tmp;
					check[i] = start;
				}
			}
		}
		
		sb.append(len).append("\n");
		
		Stack<Integer> s = new Stack<>();
		int idx = len-1;
		for(int i = N-1; i>=0; i--) {
			if(check[i] == idx) {
				s.add(num[i]);
				idx--;
			}
		}
		
		while(!s.isEmpty()) {
			sb.append(s.pop()).append(" ");
		}

		// 최종 결과 출력
		System.out.println(sb);
	}
}