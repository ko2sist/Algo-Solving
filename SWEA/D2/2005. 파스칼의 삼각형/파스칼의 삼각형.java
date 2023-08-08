import java.util.*;
import java.io.*;

// SWEA #2005 - 파스칼의 삼각형
// Strategy: 파스칼 삼각형을 2차원 배열에 넣는다고 생각하면 2차원 배열의 어떤 칸에서
//			파스칼 삼각형에 대응하는 수는 오른쪽 위 대각선에 있는 수와 바로 위에 있는 수의 합이다.
class Solution {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			// N: 파스칼 삼각형의 줄 개수
			int N = Integer.parseInt(br.readLine());
			
			// pascal: 파스칼 삼각형을 저장할 배열
			int[][] pascal = new int[N][N];
			pascal[0][0] = 1;
			
			// 파스칼 삼각형 계산
			for(int i=1; i<N; i++) {
				for(int j=0; j<i+1; j++) {
					if(j==0) {
						pascal[i][j] = 1;
					}else {
						pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
					}
				}
			}
			
			// 결과 저장
			sb.append("#").append(t).append("\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<i+1; j++) {
					int tmp = pascal[i][j];
					if(tmp != 0) {
						sb.append(tmp).append(" ");
					}
				}
				sb.append("\n");
			}
		}
		
		// 최종 결과 출력
		System.out.println(sb);
    }
}
