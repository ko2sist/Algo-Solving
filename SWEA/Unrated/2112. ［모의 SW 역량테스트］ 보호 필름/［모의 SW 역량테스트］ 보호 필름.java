import java.util.*;
import java.io.*;

// SWEA #2112 - 보호 필름
// Strategy: 백트래킹
public class Solution {
	static int D, W, K, min;
	static int[][] film;
	
	// 현재 필름이 충격 테스트 통과 가능한지 체크하는 method
	public static boolean check() {
		loop: for(int i=0; i<W; i++) {
			int cntA = 0;
			int cntB = 0;
			for(int j=0; j<D; j++) {
				if(film[j][i] == 0) {
					cntA++;
					cntB = 0;
					if(cntA == K) {
						continue loop;
					}
					if(j == D-1) {
						return false;
					}
				}else {
					cntB++;
					cntA = 0;
					if(cntB == K) {
						continue loop;
					}
					if(j == D-1) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static void back(int num, int idx) {
		if(num >= min) return;	// 용액 사용 횟수가 현재 min 이상이면 종료
		
		if(idx == D) {
			if(check()) {
				min = num;
			}
			return;
		}
		
		int[] copy = film[idx].clone();
		
		// 용액 미사용
		back(num,idx+1);
		
		// 용액 A 사용
		for(int i=0; i<W; i++) {
			film[idx][i] = 0;
		}		
		back(num+1, idx+1);
		
		// 용액 B 사용
		for(int i=0; i<W; i++) {
			film[idx][i] = 1;
		}
		back(num+1, idx+1);
		
		// 방문 해제
		film[idx] = copy;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());	// D: 두께(세로)
			W = Integer.parseInt(st.nextToken());	// W: 가로
			K = Integer.parseInt(st.nextToken());	// K: 합격기준
			
			
			// 필름 정보 입력
			film = new int[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// min: 용액 최소 사용 회수 저장
			min = Integer.MAX_VALUE;
			
			// 백트래킹 실행
			back(0,0);
			
			// 현재 테스트케이스 결과 저장
			sb.append("#"+t+" ").append(min).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}