import java.util.*;
import java.io.*;

// SWEA #1216 - 회문2
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		

		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			// 글자를 저장할 100*100 2차원 배열
			char[][] table = new char[100][100];
			
			// 글자 저장
			for(int i=0; i<100; i++) {
				String s = br.readLine();
				for(int j=0; j<100; j++) {
					table[i][j] = s.charAt(j);
				}
			}
			
			// Palindrome 체크
			int max = 1;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					// 가로 체크
					loop: for(int k=99-j; k>=2; k--) { // k -> length-1
						for(int l=0; l<(k+1)/2; l++) {
							if(table[i][j+l] != table[i][j+k-l]) {
								continue loop;
							}
						}
						if(k >= max) {
							max = k+1;
						}
					}
					// 세로 체크
					loop2: for(int k=99-j; k>=2; k--) { // k -> length-1
					for(int l=0; l<(k+1)/2; l++) {
						if(table[j+l][i] != table[j+k-l][i]) {
							continue loop2;
						}
					}
					if(k >= max) {
						max = k+1;
					}
				}
				}
			}
			// 결과 저장
			sb.append("#" + t).append(" "+ max).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
