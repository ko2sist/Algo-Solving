import java.util.*;
import java.io.*;

// BJ #2563 - 색종이
// Strategy: 100*100 배열 만들고 (초기값 0), 이후 색종이의 정보를 입력받아
//			정보에 해당하는 위치의 배열에서 찾아 흰색이라면 검은색으로 칠한다(값을 1로 바꾸기)
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 색종이의 수
		int N = Integer.parseInt(br.readLine());
		
		// white: 도화지
		// black: 색종이가 붙은 검은 영역의 넓이
		int[][] white = new int[100][100];
		int black = 0;
		
		// 색종이 정보 입력, 색종이가 붙은 영역 검은색으로 바꾸기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					if(white[j][k] == 0) {
						white[j][k] = 1;
						black++;
					}
				}
			}
		}
		

		// 최종 결과 출력
		System.out.println(black);

	}
}
