import java.util.*;
import java.io.*;

// SWEA #1289 - 원재의 메모리 복구하기
// Strategy:  
class Solution {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		// T: 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<T+1; t++){
        	// res: 결과 저장하는 변수
        	int res = 0;
        	
        	// code: 메모리의 원래 값을 저장하는 배열
        	char[] code = br.readLine().toCharArray();
        	
        	// 메모리 수정 여부를 체크하기 위한 변수
        	char tmp = '0';
        	
        	// 메모리 수정 횟수 계산
        	for(int i=0; i<code.length; i++) {
        		if(code[i] != tmp) {
        			res++;
        			if(tmp == '0') tmp = '1';
        			else tmp = '0';
        		}
        	}
        	
        	// 현재 테스트 케이스 결과 저장
            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
}
