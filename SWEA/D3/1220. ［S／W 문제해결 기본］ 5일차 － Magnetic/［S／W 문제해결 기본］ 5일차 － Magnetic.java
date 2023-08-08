import java.util.*;
import java.io.*;

// SWEA #1220 - Magnetic
// Strategy:  
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 10개의 테스트 케이스
		for(int t=1; t<11; t++) {
			// L: 테이블 한 변의 길이
			int L = Integer.parseInt(br.readLine());
			
			// table: 100x100 크기의 테이블
			// 자성체 정보 저장
			int[][] table = new int[L][L];
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// res: 교착 상태의 개수 저장
			int res = 0;
			
			// table 전체를 순회
			// 순회 중 N극을 만나면 아래로 내려가며 N극을 만나면 continue, S극을 만나면 res를 1 증가시킨 후, 다음 칸 순회
			// 순회 중 S극을 만나면 위로 올라가며 S극을 만나면 continue, N극을 만나면 res를 1 증가시킨 후, 다음 칸 순회
			// **이동하면서 N극 S극을 만났을 때는 table에서 극에 대한 정보를 0으로 바꾼다.
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					if(table[i][j] == 1) {
						table[i][j] = 0;
						for(int k = i+1; k<L; k++) {
							if(table[k][j] == 1) {
								table[k][j] = 0;
							}else if(table[k][j] == 2) {
								table[k][j] = 0;
								res++;
								break;
							}
						}
					}else if(table[i][j] == 2) {
						table[i][j] = 0;
						for(int k = i-1; k>=0; k--) {
							if(table[k][j] == 2) {
								table[k][j] = 0;
							}else if(table[k][j] == 1) {
								table[k][j] = 0;
								res++;
								break;
							}
						}
					}
				}
			}
			
			sb.append("#" + t + " " + res + "\n");
		}

		// 최종 결과 출력
		System.out.println(sb);

	}
}
