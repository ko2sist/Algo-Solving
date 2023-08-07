import java.util.*;
import java.io.*;

// BJ #3985 - 롤 케이크
// Idea: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cake = new int[L];
		int max = 0;                 // 최대 기대값 저장
		int max_idx = 0;             // 최대 기대값의 방청객 번호 저장
		int[] arr = new int[N+1];    // 실제 받은 케이크 조각 저장
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Pi = Integer.parseInt(st.nextToken());
			int Ki = Integer.parseInt(st.nextToken());
			for(int j=Pi-1; j<Ki; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					arr[i]++;
				}	
			}
			
			if(Ki-Pi+1 > max) {
				max = Ki-Pi+1;
				max_idx = i;
			}
			
		}
		
		int real_max = 0;
		int real_max_idx = 0;
		for(int i=1; i<N+1; i++) {
			if(arr[i] > real_max) {
				real_max = arr[i];
				real_max_idx = i;
			}
		}
		
		System.out.println(max_idx);
		System.out.println(real_max_idx);
	}
}
