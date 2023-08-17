import java.io.*;
import java.util.*;

// BJ #1107 - 리모컨
// Strategy: 
public class Main {
	static boolean[] button;	// 채널 번호 사용 가능/불가능을 저장하는 배열
	
	// check(c): 채널 번호 c의 유효성을 검사하는 함수
	public static boolean check(int c) {
		if(c == 0) return button[0];
		if(c < 0) return false;
		
		
		while(c>0) {
			if(!button[c%10]) {
				return false;
			}
			c /= 10;
		}
		return true;
	}
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        // 채널 번호 사용 가능 정보 저장
        button = new boolean[10];
        for(int i=0; i<10; i++) {
            button[i] = true;
        }
        if(M!=0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                button[tmp] = false;
            }
        }
        
        //

        
        // 탐색
        int min = Math.abs(100-N);
        int idx = 0;
        while(true) {
        	if(N <= 100 && N+idx > 100) break;
        	if(N >= 100 && N-idx < 100) break;
  	
        	
        	if(check(N-idx)) {
        		int tmp = idx + String.valueOf(N-idx).length();
        		if(tmp <= min) {
        			min = tmp;
        			break;
        		}
        	}
        	
        	if(check(N+idx)) {
        		int tmp = idx + String.valueOf(N+idx).length();
        		if(tmp <= min) {
        			min = tmp;
        	        break;
        		}
        	}
        	idx++;
        }
        
        // 최종 결과 출력
        System.out.println(min);
    }
}