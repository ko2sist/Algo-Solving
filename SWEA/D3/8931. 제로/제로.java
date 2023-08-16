import java.util.*;
import java.io.*;

// SWEA #8931 - 제로
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// TC: testcase 개수
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int K = Integer.parseInt(br.readLine());	// K: 실행 횟수
			Stack<Integer> s = new Stack<>();			// s: 정수들을 저장할 스택
			
			for(int i=0; i<K; i++) {
				int tmp = Integer.parseInt(br.readLine());
				
				if(tmp != 0) {		// 0을 입력받은 경우 스택에서 하나 지우기
					s.add(tmp);
				}else {				// 0이외의 값을 입력받은 경우 스택에 저장
					s.pop();
				}
			}
			
			// 스택 내의 정수 합 계산
			int sum = 0;
			for(int i=s.size(); i>0; i--) {
				sum += s.pop();
			}
			
			// 결과 저장
			sb.append("#"+t).append(" ").append(sum).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
