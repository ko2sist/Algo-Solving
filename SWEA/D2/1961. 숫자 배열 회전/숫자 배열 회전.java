import java.util.*;
import java.io.*;

// SWEA #1961 - 숫자 배열 회전
// Strategy:  
class Solution {
	// rot90(matrix): matrix를 시계방향으로 90도 회전한 행렬을 반환
	public static int[][] rot90(int[][] matrix){
        int n = matrix.length;
        int[][] matrix2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix2[j][n - 1 - i] = matrix[i][j];
            }
        }
        return matrix2;
    }
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			// N: 행렬의 행, 열 개수
			int N = Integer.parseInt(br.readLine());
			
			// matrix0: 회전을 하지 않은 행렬
			int[][] matrix0 = new int[N][N];
			
			// 행렬 저장
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					matrix0[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// matrix(A): 기존 행렬을 각도 A 만큼 회전시킨 행렬
			int[][] matrix90 = rot90(matrix0);
			int[][] matrix180 = rot90(matrix90);
			int[][] matrix270 = rot90(matrix180);
			
			// 결과 저장
			sb.append("#").append(t).append("\n");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(matrix90[i][j]);
				}
				sb.append(" ");
				for(int j=0; j<N; j++) {
					sb.append(matrix180[i][j]);
				}
				sb.append(" ");
				for(int j=0; j<N; j++) {
					sb.append(matrix270[i][j]);
				}
				sb.append("\n");
			}
		}
		
		// 최종 결과 출력
		System.out.println(sb);
    }
}
