import java.util.*;
import java.io.*;

// SWEA #1859 - 백만장자 프로젝트
// Strategy : Heap
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// N: 가격 정보 수
			int N = Integer.parseInt(br.readLine());
			
			// arr: 가격 정보를 저장하는 배열
			int[] arr = new int[N];
			
			// 날짜별 물건 가격 정보 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i] = tmp;
			}
			
			long sum = 0;		// 전체 이익의 합
			
			int max = 0;		// 지금까지 읽은 가격 중 최대 값
			
			// 최대 이익 계산
			for(int i=N-1; i>=0; i--) {	// 뒤에서 부터 읽음
				int tmp = arr[i];
				if(tmp > max) {			// 최대값이 갱신 될 때는 갱신만
					max = tmp;
				}else {					// 최대값과 현재 읽은 값의 차이 -> 이득
					sum += max-tmp;
				}
			}

			// 현재 테스트케이스 결과 저장
			sb.append("#"+t).append(" ").append(sum).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
