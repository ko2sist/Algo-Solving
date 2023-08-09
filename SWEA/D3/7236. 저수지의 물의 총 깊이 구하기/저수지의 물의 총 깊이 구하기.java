import java.util.*;
import java.io.*;


// SWEA #7236 - 저수지의 물의 총 깊이 구하기
// Strategy : brute-force, 8방 탐색
class Solution {
	// getDepth: 8방 탐색을 통해 현재 구획의 물 깊이를 구하는 함수
	public static int getDepth(char[][] water, int i, int j, int N) {
		int[] dr = {0,1,1,1,0,-1,-1,-1};
		int[] dc = {1,1,0,-1,-1,-1,0,1};
		int res = 0;
		
		for(int k=0; k<8; k++) {
			if(i+dr[k]>=0 && i+dr[k]<N && j+dc[k]>=0 && j+dc[k]<N) {
				if(water[i+dr[k]][j+dc[k]] == 'W') {
					res++;
				}
			}
		}
		
		if(res == 0) {
			res = 1;
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<T+1; t++) {
			// N: 저수지 구획의 크기
			int N = Integer.parseInt(br.readLine());
			
			// 저수지 정보 입력
			char[][] water = new char[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					water[i][j] = st.nextToken().charAt(0);
				}
			}
			
			// 저수지 순회하며 8방 탐색, 최대 깊이 갱신
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(water[i][j] == 'W') {
						int tmp = getDepth(water, i, j, N);
						if(tmp >= max) {
							max = tmp;
						}
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
