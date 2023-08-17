import java.io.*;
import java.util.*;

// BJ #14500 - 테크로미노
// Strategy: 
public class Main {
	static int N,M;
	static int[][] paper;
	
	public static int cal1(int r, int c) {	// 일자형 테트로미노
		int sum1 = 0;
		if(c <= M-4) {
			for(int i=0; i<4; i++) {
				sum1 += paper[r][c+i];
			}
		}
		
		int sum2 = 0;
		if(r <= N-4) {
			for(int i=0; i<4; i++) {
				sum2 += paper[r+i][c];
			}
		}
		
		return Math.max(sum1, sum2);
	}
	
	public static int cal2(int r, int c) {	// 정사각형 테트로미노
		int sum = 0;
		
		if(r <= N-2 && c <= M-2) {
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					sum += paper[r+i][c+j];
				}
			}
		}
		
		return sum;
	}
	
	public static int cal3(int r, int c) {	// ㄱ자 테트로미노
		int sum1 = 0;
		if(r <= N-3 && c <= M-2) {
			sum1 = paper[r][c] +  paper[r+1][c] +  paper[r+2][c] +  paper[r+2][c+1];
		}
		int sum2 = 0;
		if(r <= N-2 && c <= M-3) {
			sum2 = paper[r][c] +  paper[r+1][c] +  paper[r+1][c+1] +  paper[r+1][c+2];
		}
		int sum3 = 0;
		if(r <= N-2 && c <= M-3) {
			sum3 = paper[r][c] +  paper[r][c+1] +  paper[r][c+2] +  paper[r+1][c];
		}
		int sum4 = 0;
		if(r <= N-2 && c <= M-3) {
			sum4 = paper[r][c] +  paper[r][c+1] +  paper[r][c+2] +  paper[r+1][c+2];
		}
		int sum5 = 0;
		if(r <= N-3 && c <= M-2) {
			sum5 = paper[r][c] +  paper[r+1][c] +  paper[r+2][c] +  paper[r][c+1];
		}
		int sum6 = 0;
		if(r <= N-3 && c <= M-2) {
			sum6 = paper[r][c] +  paper[r][c+1] +  paper[r+1][c+1] +  paper[r+2][c+1];
		}
		int sum7 = 0;
		if(r >= 2 && c <= M-2) {
			sum7 = paper[r][c] +  paper[r][c+1] +  paper[r-1][c+1] +  paper[r-2][c+1];
		}
		int sum8 = 0;
		if(r >= 1 && c <= M-3) {
			sum8 = paper[r][c] +  paper[r][c+1] +  paper[r][c+2] +  paper[r-1][c+2];
		}
		
		return Math.max(Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4)), Math.max(Math.max(sum5, sum6), Math.max(sum7, sum8)));
	}
	
	public static int cal4(int r, int c) {	// ㄹ자 테트로미노
		int sum1 = 0;
		if(r <= N-2 && c <= M-3) {
			sum1 = paper[r][c] +  paper[r][c+1] +  paper[r+1][c+1] +  paper[r+1][c+2];
		}
		int sum2 = 0;
		if(r <= N-3 && c <= M-2) {
			sum2 = paper[r][c] +  paper[r+1][c] +  paper[r+1][c+1] +  paper[r+2][c+1];
		}
		int sum3 = 0;
		if(r <= N-3 && c >= 1) {
			sum3 = paper[r][c] +  paper[r+1][c] +  paper[r+1][c-1] +  paper[r+2][c-1];
		}
		int sum4 = 0;
		if(r >= 1 && c <= M-3) {
			sum4 = paper[r][c] +  paper[r][c+1] +  paper[r-1][c+1] +  paper[r-1][c+2];
		}
		return Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
	}
	
	public static int cal5(int r, int c) {	// ㅗ자 테트로미노
		int sum1 = 0;
		if(r <= N-2 && c <= M-3) {
			sum1 = paper[r][c] +  paper[r][c+1] +  paper[r][c+2] +  paper[r+1][c+1];
		}
		int sum2 = 0;
		if(r <= N-3 && c <= M-2) {
			sum2 = paper[r][c] +  paper[r+1][c] +  paper[r+2][c] +  paper[r+1][c+1];
		}
		int sum3 = 0;
		if(r >= 1 && c <= M-3) {
			sum3 = paper[r][c] +  paper[r][c+1] +  paper[r][c+2] +  paper[r-1][c+1];
		}
		int sum4 = 0;
		if(r <= N-3 && c >= 1) {
			sum4 = paper[r][c] +  paper[r+1][c] +  paper[r+2][c] +  paper[r+1][c-1];
		}
		
		return Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int tmp1 = cal1(i,j);
				int tmp2 = cal2(i,j);
				int tmp3 = cal3(i,j);
				int tmp4 = cal4(i,j);
				int tmp5 = cal5(i,j);
				int tmax = Math.max(Math.max(Math.max(tmp1, tmp2), tmp3), Math.max(tmp4,tmp5));
				if(tmax > max) {
					max = tmax;
				}
			}
		}
		// 최종 결과 출력
		System.out.print(max);
	}
}