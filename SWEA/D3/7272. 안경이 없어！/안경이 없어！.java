import java.util.*;
import java.io.*;


// SWEA #7272 - 안경이 없어!
// Strategy : 
class Solution {
	public static int holes(char c) {
		if(c == 66) {
			return 2;
		}else if(c == 65 || c == 68 || (c>=79 && c<=82)) {
			return 1;
		}else {
			return 0;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			
			String res = "";
			if(word1.length() != word2.length()) {
				res = "DIFF";
			}else {
				int len = word1.length();
				for(int i=0; i<len; i++) {
					if(holes(word1.charAt(i)) != holes(word2.charAt(i))) {
						res = "DIFF";
						break;
					}
				}
				
				if(!res.equals("DIFF")) {
					res = "SAME";
				}
			}
			
			// 결과 저장
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
