import java.util.*;
import java.io.*;
 
 
// SWEA #11315 - 오목 판정
// Strategy : 
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        // T: 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
 
        for(int t=1; t<T+1; t++) {
        	// N: 판 크기
            int N = Integer.parseInt(br.readLine());
            
            // table: 판 정보를 저장 할 배열
            boolean[][] table = new boolean[N][N];
            
            // 판 정보 입력
            for(int i=0; i<N; i++) {
            	String s = br.readLine();
            	for(int j=0; j<N; j++) {
            		if(s.charAt(j) == 'o') {
            			table[i][j] = true;
            		}
            	}
            }
            
            //
            String res = "NO";
            loop: for(int i=0; i<N; i++) {
            	int cnt_h = 0;			// horizontal
            	int cnt_v = 0;			// vertical
            	int cnt_d_LD = 0;		// diagonal_LeftDown
            	int cnt_d_TD = 0;		// diagonal_TopDown
            	int cnt_d_LU = 0;		// diagonal_LeftUp
            	int cnt_d_BU = 0;		// diagonal_BottomUp
            	
            	for(int j=0; j<N; j++) {
            		// 가로 체크
            		if(table[i][j]) {
            			cnt_h++;
            		}else{
            			if(cnt_h >= 5) {
            				res = "YES";
            				break loop;
            			}
            			cnt_h = 0;
            		}
            		
            		// 세로 체크
            		if(table[j][i]) {
            			cnt_v++;
            		}else{
            			if(cnt_v >= 5) {
            				res = "YES";
            				break loop;
            			}
            			cnt_v = 0;
            		}
            		
            		// 대각선 LD 체크
            		if(i+j < N && table[i+j][j] ) {
            			cnt_d_LD++;
            		}else {
            			if(cnt_d_LD >= 5) {
            				res = "YES";
            				break loop;
            			}
            			cnt_d_LD = 0;
            		}
            		// 대각선 TD 체크
            		if(i+j < N && table[j][i+j]) {
            			cnt_d_TD++;
            		}else {
            			if(cnt_d_TD >= 5) {
            				res = "YES";
            				break loop;
            			}
            			cnt_d_TD = 0;
            		}
            		// 대각선 LU 체크
            		if(i-j >=0 && table[i-j][j]) {
            			cnt_d_LU++;
            		}else {
            			if(cnt_d_LU >= 5) {
            				res = "YES";
            				break loop;
            			}
            			cnt_d_LU = 0;
            		}
            		// 대각선 BU 체크
            		if(i+j < N && table[N-1-j][i+j]) {
            			cnt_d_BU++;
            		}else {
            			if(cnt_d_BU >= 5) {
            				res = "YES";
            				break loop;
            			}
            			cnt_d_BU = 0;
            		}
            	}
            	
            	// 반복문이 종료되고 5칸 이상을 만족하는 경우를 체크
            	if(cnt_h >= 5 || cnt_v >= 5 || cnt_d_LD >= 5 || cnt_d_TD >= 5 || cnt_d_LU >= 5 || cnt_d_BU >= 5) {
            		res = "YES";
            	}
            }
            
            // 결과 저장
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        // 최종 결과 출력
        System.out.println(sb);
    }
}