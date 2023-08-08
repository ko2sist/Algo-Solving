import java.util.*;
import java.io.*;

// BJ #2567 - 색종이2
// Strategy: 102*102 배열 만들고 (초기값 0), 102*102인 이유는 색종이가 도화지의 끝과 닿아 있는 경우도 체크하기 위해 상하좌우 여유 1칸씩
//			이후 색종이의 정보를 입력받아 정보에 해당하는 위치의 배열에서 찾아 흰색이라면 검은색으로 칠한다(값을 1로 바꾸기)
//			이후 도화지 배열을 순회하며 현재 칸이 흰색일 경우 상하좌우에 검은칸이 존재하면 검은 영역의 둘레 길이 +1	
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 색종이의 수
		int N = Integer.parseInt(br.readLine());
		
		// white: 도화지
		// black: 색종이가 붙은 검은 영역의 둘레 길이
		int[][] white = new int[102][102];
		int black = 0;
		
		// 색종이 정보 입력, 색종이가 붙은 영역 검은색으로 바꾸기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x+1; j<x+11; j++) {
				for(int k=y+1; k<y+11; k++) {
					if(white[j][k] == 0) {
						white[j][k] = 1;
					}
				}
			}
		}
		
		// 사방 탐색을 위한 배열
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		
		// 도화지 탐색, 검은 영역의 둘레 찾기
		for(int i=0; i<102; i++) {
			for(int j=0; j<102; j++) {
				// 현재 칸이 흰색일 경우, 상하좌우 탐색
				if(white[i][j] == 0) {
					for(int k=0; k<4; k++) {
						if(i+dr[k]<102 && i+dr[k]>=0 && j+dc[k]<102 && j+dc[k]>=0) {
							if(white[i+dr[k]][j+dc[k]] == 1) {
								black++;
							}
						}
					}
				}
			}
		}

		// 최종 결과 출력
		System.out.println(black);

	}
}
