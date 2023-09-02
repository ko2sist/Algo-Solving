import java.util.*;
import java.io.*;

// SWEA #2112 - 보호 필름
// Strategy: 백트래킹
public class Solution {
	static int D, W, K, min;
	static int[][] film;
	
    // check: 선택한 용액 조합으로 충격 테스트를 만족하는지 체크하는 method
	public static boolean check(int[] selected) {
		int[][] c = new int[D][W];
		
		for(int i=0; i<D; i++) {
			c[i] = film[i].clone();
		}
		
		for(int i=0; i<D; i++) {
			if(selected[i] == 0) {
				for(int j=0; j<W; j++) {
					c[i][j] = 0;
				}
			}else if(selected[i] == 1) {
				for(int j=0; j<W; j++) {
					c[i][j] = 1;
				}
			}
		}
		
		loop: for(int i=0; i<W; i++) {
			int cntA = 0;
			int cntB = 0;
			for(int j=0; j<D; j++) {
				if(c[j][i] == 0) {
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
	
	public static void back(int num, int idx, int[] selected) {
		if(num >= min) return;		// 용액 사용 횟수가 기존 min 이상이면 종료
		
		if(idx == D) {
//			System.out.println(Arrays.toString(selected));
			if(check(selected)) {
				min = num;
			}
			return;
		}
		
        // 용액 미사용
		selected[idx] = -1;
		back(num,idx+1,selected);
		
        // 용액 A 사용
		selected[idx] = 0;
		back(num+1, idx+1, selected);
		
        // 용액 B 사용
		selected[idx] = 1;
		back(num+1, idx+1, selected);
		
		
		
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
			
            // min: 용액 사용 최소 회수 저장
			min = Integer.MAX_VALUE;
			
            // selected: idx-> row, 해당 row에서 용액을 사용 했는지, 사용했다면 어떤 용액을 사용했는지 저장
			int[] selected = new int[D];
			Arrays.fill(selected, -1);	 // -1 -> 용액 미사용
			
            // 재귀 실행
			back(0,0,selected);
			
			// 현재 테스트케이스 결과 저장
			sb.append("#"+t+" ").append(min).append("\n");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}