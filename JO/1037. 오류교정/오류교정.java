import java.util.*;
import java.io.*;

// JO #1037 - 오류교정
// Strategy: 열과 행의 패리티 체크시 바꿔야 될 비트가 있는 행 or 열이 있다면 cc, cr에서 해당 idx에 1 저장, modi에 idx 저장
//			이후 cc, cr에 있는 1의 개수에 따라 결과 출력
			
public class JO {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N: 행렬의 행,열 개수
		int N = Integer.parseInt(br.readLine());
		
		// matrix: 패리티 성질을 체크할 행렬
		int[][] matrix = new int[N][N];
		
		// 행렬 정보 저장
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행 체크
		int[] cr = new int[N];
		int modi_row = 0;
		
		for(int i=0; i<N; i++) {
			int check_row = 0;
			for(int j=0; j<N; j++) {
				check_row += matrix[i][j];
			}
			if(check_row % 2 == 1) {
				cr[i] = 1;
				modi_row = i;
			}
		}
		
		// 열 체크
		int[] cc = new int[N];
		int modi_col = 0;
		
		for(int i=0; i<N; i++) {
			int check_col = 0;
			for(int j=0; j<N; j++) {
				check_col += matrix[j][i];
			}
			if(check_col % 2 == 1) {
				cc[i] = 1;
				modi_col = i;
			}
		}
		
		// cc, cr에 들어있는 1의 개수 계산
		int cnt_row = 0;
		int cnt_col = 0;
		for(int i=0; i<N; i++) {
			if(cr[i] == 1) {
				cnt_row++;
			}
			if(cc[i] == 1) {
				cnt_col++;
			}
		}
		
		// 최종 결과 출력
		if(cnt_row == 0 && cnt_col == 0) {
			System.out.println("OK");
		}else if(cnt_row != 1 || cnt_col != 1) {
			System.out.println("Corrupt");
		}else {
			System.out.printf("Change bit (%d,%d)", modi_row+1, modi_col+1);
		}
	}
}
