import java.util.*;
import java.io.*;


// SWEA #4698 - 테네스의 특별한 소수
// Strategy : 에라토스테네스의 체
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 에라토스체네스의 체를 실행하기 위한 boolean 배열
			boolean[] check = new boolean[B+1];
			for(int i=2; i<B+1; i++) {
				check[i] = true;
			}
			
			// 에라토스 체네스의 체 실행 ( i가 소수일 경우 check[i] = true )
			for(int i=2; i<B+1; i++) {
				if(check[i]) {
					for(int j=2; j*i < B+1; j++) {
						check[j*i] = false;
					}
				}
			}
			
			// 걸러진 체를 순회하며 i가 소수일 때, D를 포함하는지 체크
			int res = 0;
			for(int i=A; i<B+1; i++) {
				if(check[i]) {
					int n = i;
					boolean includeD = false;
					while(n>0) {
						if(n%10 == D) {
							includeD = true;
							break;
						}
						n /= 10;
					}
					
					if(includeD) {
						res++;
					}
				}
			}
			// 결과 저장
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
