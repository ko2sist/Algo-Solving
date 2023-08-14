import java.util.*;
import java.io.*;

// SWEA #1989 - 초심자의 회문 검사
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		loop: for(int t=1; t<=T; t++) {
			String s = br.readLine();
			
			for(int i=0; i<s.length()/2; i++) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					sb.append("#" + t).append(" "+ 0).append("\n");
					continue loop;
				}
			}
			sb.append("#" + t).append(" "+ 1).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
