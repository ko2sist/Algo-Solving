import java.util.*;
import java.io.*;

// SWEA #1218 - 괄호 짝짓기
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		loop: for(int t=1; t<=10; t++) {
			int n = Integer.parseInt(br.readLine());	// 글자수
			Stack<Character> s = new Stack<>();			// 괄호를 저장할 스택
			String str = br.readLine();					// 괄호들로 이루어진 문자열
			
			// 짝 일치 판별
			for(int i=0; i<n; i++) {
				char tmp = str.charAt(i);
				
				if(tmp == ')') {
					if(s.isEmpty() || s.pop() != '(') {
						sb.append("#"+t).append(" " + 0).append("\n");
						continue loop;
					}
				}else if(tmp == '}') {
					if(s.isEmpty() || s.pop() != '{') {
						sb.append("#"+t).append(" " + 0).append("\n");
						continue loop;
					}
				}else if(tmp == '>') {
					if(s.isEmpty() || s.pop() != '<') {
						sb.append("#"+t).append(" " + 0).append("\n");
						continue loop;
					}
				}else if(tmp == ']') {
					if(s.isEmpty() || s.pop() != '[') {
						sb.append("#"+t).append(" " + 0).append("\n");
						continue loop;
					}
				}else {
					s.push(tmp);
				}
			}
			// 모든 괄호의 짝이 맞았을 경우
			sb.append("#"+t).append(" " + 1).append("\n");
			
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
