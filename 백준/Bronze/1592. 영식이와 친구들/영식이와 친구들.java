import java.util.*;
import java.io.*;

// BJ #1592 - 영식이와 친구들
// Idea: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 사람 수
		// M: 공을 받을 수 있는 최대 횟수
		// L: 공의 이동 거리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// nums: 공을 받은 횟수를 저장하는 배열
		// idx: 현재 공을 가진 사람의 index
		int[] nums = new int[N];
		int idx = 0;
		int cnt = 0;
		while(true) {
			nums[idx]++;
			// 현재 공을 받은 사람이 공을 M번째 받은 경우일 경우 종료
			if(nums[idx] == M) {
				break;
			
			// 현재 공을 받은 횟수가 홀수번일 경우
			}else if(nums[idx] % 2 == 1) {
				idx = (idx+L) % N;
			// 현재 공을 받은 횟수가 짝수번일 경우
			}else {
				idx = (idx-L) % N;
				if(idx<0) {
					idx += N;
				}
			}
			cnt++;
		}
		
		
		// 최종 결과 출력
		System.out.println(cnt);
	}
}
