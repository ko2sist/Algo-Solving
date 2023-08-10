import java.util.*;
import java.io.*;
 
 
// SWEA #1209 - sum
// Strategy : 
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
 
        for(int t=1; t<11; t++) {
        	int tc = Integer.parseInt(br.readLine());
        	
        	// arr: 숫자를 저장할 배열
        	int[][] arr = new int[100][100];
        	
        	// 숫자 저장
        	for(int i=0; i<100; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0; j<100; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	
        	
        	// 행,열, 대각선 합의 최댓값 계산
        	int max = 0;        // 전체 최댓값
        	int sum_d1 = 0;		// 대각선1의 합 (왼쪽 위에서 오른쪽 아래로 가는 대각선)
        	int sum_d2 = 0;		// 대각선2의 합 (왼쪽 아래에서 오른쪽 위로 가는 대각선)
        	for(int i=0; i<100; i++) {
        		int sum_h = 0;
        		int sum_v = 0;
        		for(int j=0; j<100; j++) {
        			sum_h += arr[i][j];     // 각 행의 합 계산
        			sum_v += arr[j][i];		// 각 열의 합 계산
        			
        			if(i==j) {				// 대각선 1의 합 계산
        				sum_d1 += arr[i][j];
        			}
        			
        			if(i+j == 99) {			// 대각선 2의 합 계산
        				sum_d2 += arr[i][j];
        			}
        		
        		}
        		
        		// 각 행, 열의 합은 i가 바뀔 때 초기화 되기 때문에 반복문 내에서 최댓값 갱신
        		int tmp_max_rc = Math.max(sum_h, sum_v);
        		if(tmp_max_rc >= max) {
        			max = tmp_max_rc;
        		}
        	}
        	
        	int tmp_max_d = Math.max(sum_d1, sum_d2);
        	if(tmp_max_d >= max) {
        		max = tmp_max_d;
        	}
        	
            // 결과 저장
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        // 최종 결과 출력
        System.out.println(sb);
    }
}