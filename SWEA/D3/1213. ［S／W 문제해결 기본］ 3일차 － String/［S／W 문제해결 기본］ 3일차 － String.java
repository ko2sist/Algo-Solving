import java.util.*;
import java.io.*;

// SWEA #1213 - String
// Strategy: s에서 1글자씩 앞으로 순회, f의 첫글자와 일치하는 글자가 나오면 len_f만큼
//			반복문을 돌려가면서 f의 모든 글자가 순서대로 나오는지 체크, 만약 그렇다면 res++
//			도중에 문자가 일치하지 않는 다면 s의 다음 글자로
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
			
			int res = 0;				// res: s에서 f가 등장한 횟수
			
			// 단어 검색
			loop: for(int i=0; i<len_s; i++) {
				if(s.charAt(i) == f.charAt(0)) {
					for(int j=1; j<len_f; j++) {
						if(i+j >= len_s || s.charAt(i+j) != f.charAt(j)) {
							continue loop;
						}
					}
					res++;
				}
			}
			
			// 결과 저장
			sb.append("#" + t).append(" " + res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
