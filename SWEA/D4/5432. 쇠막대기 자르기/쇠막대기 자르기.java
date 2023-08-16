import java.util.*;
import java.io.*;

// SWEA #5432 - 쇠막대기 자르기
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: testcase 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();			  // 막대기, 레이저의 배치를 표시하는 문자열
			Stack<Character> s = new Stack<>();	  // 계산에 사용할 스택
			int sum = 0;						  // 잘린 막대기의 개수를 저장할 변수
			
			boolean lazer = false;
			for(int i=0; i<str.length(); i++) {
				char tmp = str.charAt(i);
				if(tmp == ')') {
					s.pop();
					if(lazer) {				// )이 연속해서 나오는 경우를 체크하기 위해 lazer를 false로
						sum += s.size();
						lazer = false;
					}else {					// )이 연속해서 나오면 레이저의 존재가 아니라 막대기의 끝을 의미하기 때문에 sum++
						sum++;
					}
				}else {
					s.add(tmp);
					if(!lazer) {
						lazer = true;
					}
					
				}
			}
			
			
			
			// 결과 저장
			sb.append("#"+t).append(" ").append(sum).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
