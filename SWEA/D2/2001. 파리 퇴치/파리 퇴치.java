import java.util.*;
import java.io.*;


// SWEA #2001 - 파리 퇴치
// Strategy : 
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// N: 배열 크기
			// M: 파리채 크기
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// flies: 파리의 마리 수를 저장하는 배열
			// 파리 정보 저장
			int[][] flies = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					flies[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 배열 순회, max 갱신
			int max = 0;
			for(int i=0; i<N-(M-1); i++) {
				for(int j=0; j<N-(M-1); j++) {
					int tmp = 0;
					for(int k=i; k<i+M; k++) {
						for(int l=j; l<j+M; l++) {
							tmp+= flies[k][l];
						}
					}
					if(tmp >= max) {
						max = tmp;
					}
				}
			}
			
			// 결과 저장
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
