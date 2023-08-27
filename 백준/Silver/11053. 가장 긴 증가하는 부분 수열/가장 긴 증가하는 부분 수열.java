import java.io.*;
import java.util.*;

// BJ #11053 - 가장 긴 증가하는 부분 수열
// Strategy: LIS + Binary Search
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] lis = new int[N];
		int len = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				lis[0] = tmp;
				len++;
			}else {
				if(lis[len-1] < tmp) {
					lis[len] = tmp;
					len++;
				}else {
					int start = 0;
					int end = len-1;
					while(start <= end) {
						int mid = (start+end) / 2;
						if(tmp > lis[mid]) {
							start = mid+1;
						}else if(tmp < lis[mid]){
							end = mid-1;
						}else {
							start = mid;
							break;
						}
					}
					lis[start] = tmp;
				}
			}
		}

		// 최종 결과 출력
		System.out.println(len);
	}
}