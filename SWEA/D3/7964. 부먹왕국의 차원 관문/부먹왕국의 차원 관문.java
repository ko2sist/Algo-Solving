import java.util.*;
import java.io.*;

// SWEA #7964 - 부먹왕국의 차원관문
// Strategy: 도시를 순회하며 탐색, 동시에 0의 개수를 셈. 0의 개수가 제한거리가 되면 
// 			그 자리에 관문을 설치하고 0의 개수를 초기화. 도시 순회가 끝날때까지 반복
class Solution {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// city: 도시의 개수
			// limit: 제한거리
			int city = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			
			// install: 도시 별 차원관문 설치 정보를 저장하는 배열
			int[] install = new int[city];
			
			// 차원관문 설치 정보 저장
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<city; i++) {
				install[i] = Integer.parseInt(st.nextToken());
			}
			
			// cnt: 제한 거리를 체크하기 위한 count
			// num: 새로 설치가 필요한 관문 개수
			int cnt = 0;
			int num = 0;
			
			// 관문 개수 계산
			for(int i=0; i<city; i++) {
				if(install[i] == 0) {
					cnt++;
					if(cnt == limit) {
						install[i] = 1;
						num++;
						cnt = 0;
					}
				}else {
					cnt = 0;
				}
			}
			// 결과 저장
			sb.append("#").append(t).append(" ").append(num).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
    }
}
