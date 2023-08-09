import java.util.*;
import java.io.*;


// SWEA #4047 - 영준이의 카드 카운팅
// Strategy : 
class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());

		loop : for(int t=1; t<T+1; t++) {
			String cards = br.readLine();
			int N = cards.length()/3;
			
			// check: 카드가 이미 존재하는지 확인하기 위한 배열
			// num_shape: 무늬 별로 몇 장의 카드를 입력 받았는지 저장하기 위한 배열
			int[] check = new int[53];
			int[] num_shape = new int[4];
			
			for(int i=0; i<N; i++) {
				// shape: 모양에 대한 글자 저장
				// number: 카드 번호
				// s: shape를 해당하는 번호에 맞게 변경한 것
				char shape = cards.charAt(i*3);
				int number = Integer.valueOf("" + cards.charAt(i*3+1) + cards.charAt(i*3+2));
				int s = 0;
				if(shape == 'S') {
					s = 0;
				}else if(shape == 'D') {
					s = 1;
				}else if(shape == 'H') {
					s = 2;
				}else {
					s = 3;
				}
				
				// 입력받은 카드가 이미 존재하는 지 체크, 가지고 있지 않다면 check를 1로 변경
				int idx = s*13 + number - 1;
				
				if(check[idx] == 1) {
					sb.append("#").append(t).append(" ERROR").append("\n");
					continue loop;
				}else {
					check[idx] = 1;
					num_shape[s]++;
				}
			}
			// 결과 저장
			sb.append("#").append(t).append(" ").append(13-num_shape[0]).append(" ").append(13-num_shape[1]).append(" ").append(13-num_shape[2]).append(" ").append(13-num_shape[3]).append("\n");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
