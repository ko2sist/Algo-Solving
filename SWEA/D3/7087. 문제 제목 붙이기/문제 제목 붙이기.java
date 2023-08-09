import java.util.*;
import java.io.*;


// SWEA #7087 - 문제 제목 붙이기
// Strategy : 
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<T+1; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[26];
			
			// 입력 받은 제목들의 첫번째 문자에 대해 check 배열에서 true로 변경
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				char c = s.charAt(0);
				if(!check[c-65]) {       // A의 아스키 코드 값이 65임을 참고
					check[c-65] = true;
				}
			}
			
			// check 배열을 앞에서부터 순회, false가 나올때까지의 true 개수가 정답
			int res = 0;
			for(int i=0; i<26; i++) {
				if(check[i]) {
					res++;
				}else {
					break;
				}
			}

			// 결과 저장
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
