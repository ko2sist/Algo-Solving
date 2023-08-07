import java.util.*;
import java.io.*;

// BJ #2630 - 색종이 만들기
// Idea: 재귀함수 이용
public class Main {
	// custom class 
	public static class Pair{
		int blue;
		int white;
		
		public Pair() {}
		public Pair(int blue, int white) {
			this.blue = blue;
			this.white = white;
		}
		
		public void add(Pair p) {
			this.blue += p.blue;
			this.white += p.white;
		}
	}
	
	
	
	public static Pair get(int[][] paper, int i, int j, int exp) {
		if(exp == 0) {
			if(paper[i][j]==0) {
				return new Pair(0,1);
			}else {
				return new Pair(1,0);
			}
		}else {
			int same = 1;
			loop: for(int k=i; k<i+(int)Math.pow(2, exp); k++) {
				for(int l=j; l<j+(int)Math.pow(2, exp); l++) {
					if(paper[k][l] != paper[i][j]) {
						same = 0;
						break loop;
					}
				}
			}
			if(same == 1) {
				if(paper[i][j]==0) {
					return new Pair(0,1);
				}else {
					return new Pair(1,0);
				}
			}else {
				Pair res = new Pair();
				int tmp = (int)Math.pow(2, exp-1);
				// Quadrant 1
				res.add(get(paper, i, j, exp-1));
				// Quadrant 2
				res.add(get(paper, i, j+tmp, exp-1));
				// Quadrant 3
				res.add(get(paper, i+tmp, j, exp-1));
				// Quadrant 4
				res.add(get(paper, i+tmp, j+tmp, exp-1));
				
				return res;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 한 변의 길이 N
		int N = Integer.parseInt(br.readLine());
		
		// 종이의 색깔 저장
		int[][] paper = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		
		}
		
		int exp = 0;
		while (N!=1) {
			N/=2;
			exp++;
		}

		Pair res = get(paper, 0, 0, exp);
		sb.append(res.white).append("\n");
		sb.append(res.blue).append("\n");
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
