import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		
		// 10개의 수를 입력받아 총합을 구하고
		// 최대, 최소를 총합에서 뺀 뒤 8로 나눈 평균을 구한다.
		for(int i=1; i<T+1; i++) {
			int max = 0;        // 입력 범위가 0~10000 이기 때문에
			int min = 10000;    // 초기 max는: 0, 초기 min: 10000
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				// 현재 입력된 정수 tmp
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp >= max){   // max 갱신
					max = tmp;
				}
				if(tmp <= min) {  // min 갱신
					min = tmp;
				}
				sum += tmp;       // 총합 sum 계산
			}
			// 결과 저장
			String s = "#"+i+" "+(int)(Math.round((sum-max-min)/8.0))+"\n";
			sb.append(s);
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
