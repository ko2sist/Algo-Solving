import java.util.*;
import java.io.*;


// SWEA #1979 - 어디에 단어가 들어갈 수 있을까
// Strategy : 
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// N: 퍼즐의 크기
			// K: 단어의 길이
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			// puzzle: 퍼즐의 빈칸 정보를 저장할 배열
			int[][] puzzle = new int[N][N];

			// 퍼즐 정보 입력
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					puzzle[i][j] = tmp;
				}
			}
			
			// 빈칸 개수 찾기
			int res = 0;
			for(int i=0; i<N; i++) {
				int cnt_h = 0;
				int cnt_v = 0;
				for(int j=0; j<N; j++) {
					// 가로 체크
					if(puzzle[i][j] == 1) {
						cnt_h++;
					}else {
						if(cnt_h == K) {
							res++;
						}
						cnt_h = 0;
					}
					
					
					// 세로 체크
					if(puzzle[j][i] == 1) {
						cnt_v++;
					}else {
						if(cnt_v == K) {
							res++;
						}
						cnt_v = 0;
					}
					
				}
				if(cnt_h == K) {
					res++;
				}
				if(cnt_v == K) {
					res++;
				}
			}
			
			// 결과 저장
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
