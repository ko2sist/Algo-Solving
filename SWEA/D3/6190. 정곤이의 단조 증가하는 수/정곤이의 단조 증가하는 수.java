import java.util.*;
import java.io.*;

// SWEA #6190 - 정훈이의 단조 증가하는 수
// Strategy:  
class Solution {
	// check(n): n이 단조 증가하는 수인지 체크하는 method
	public static boolean check(int n) {
		String s = String.valueOf(n);
		char[] arr = s.toCharArray();
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		// T: 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<T+1; t++){
        	// res: 결과 저장하는 변수
        	int max = -1;
        	
        	// N : 정수 개수
        	int N = Integer.parseInt(br.readLine());
        	
        	// nums: 정수 저장하는 배열
        	int[] nums = new int[N];
        	
        	// 정수 입력
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0; i<N; i++) {
        		nums[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	// 최대 단조 증가수 계산;
        	for(int i=0; i<N-1; i++) {
        		for(int j=i+1; j<N; j++) {
        			int tmp = nums[i] * nums[j];
        			if(check(tmp) && tmp > max) {
        				max = tmp;
        			}
        		}
        	}
        	
        	// 현재 테스트 케이스 결과 저장
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}
