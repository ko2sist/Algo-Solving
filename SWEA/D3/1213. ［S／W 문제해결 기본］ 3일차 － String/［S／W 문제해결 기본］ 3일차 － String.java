import java.util.*;
import java.io.*;

// SWEA #1213 - String
// Strategy: 보이어-무어
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			String f = br.readLine();	// f: 찾으려하는 문자열
			String s = br.readLine();	// s: 문장
			int len_f = f.length();		// len_f: f의 길이
			int len_s = s.length();		// len_s: s의 길이
			int idx_f;					// f의 커서 (보이어-무어)
			int idx_s;					// s의 커서 (보이어-무어)
			int[] skip = new int[Character.MAX_VALUE +1];	// 건너뛰기 표
			
			int res = 0;				// res: s에서 f가 등장한 횟수
			
			// 건너뛰기 표 만들기
			for(idx_s = 0; idx_s <= Character.MAX_VALUE; idx_s++) {
				skip[idx_s] = len_f;
			}
			for(idx_s = 0; idx_s < len_f-1; idx_s++) {
				skip[f.charAt(idx_s)] = len_f-1 - idx_s;
			}
			
			// 검색
			while(idx_s < len_s) {
				idx_f = len_f-1;
				while(s.charAt(idx_s) == f.charAt(idx_f)) {
					if(idx_f == 0) {
						res++;
						break;
					}
					idx_f--;
					idx_s--;
				}
				idx_s += Math.max(skip[s.charAt(idx_s)], len_f-idx_f);
				
			}
			
			// 결과 저장
			sb.append("#" + t).append(" " + res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
