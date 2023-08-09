import java.util.*;
import java.io.*;


// SWEA #4789 - 성공적인 공연 기획
// Strategy : 
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<T+1; t++) {
			String info = br.readLine();
			int len = info.length();
			
			// clap: 현재 박수를 치고 있는 사람의 수
			// need: 전체가 박수를 치기 위해 필요한 사람의 수
			int clap = 0;
			int need = 0;
			for(int i=0; i<len; i++) {
				if(clap >= i) {
					clap += Character.getNumericValue(info.charAt(i));
				}else {
					int n = Character.getNumericValue(info.charAt(i));
					if(n != 0) {
						need += i-clap;
						clap += n + (i-clap);
					}
				}
			}
			// 결과 저장
			sb.append("#").append(t).append(" ").append(need).append("\n");
			
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
