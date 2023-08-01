import java.io.*;
import java.util.*;

// BJ #1463
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        set.add(N);
        
        
        // 정수 N이 들어있는 Set을 시작으로 Set에 들어있는 정수들에 대해 
        // 3가지 연산을 해서 다시 Set에 담는다. 이 과정 도중 1이 관찰되면
        // 즉시 반복문을 종료하고 현재의 depth를 출력한다.
        int depth = 1;
        loop1: while(true) {
        	Iterator<Integer> iter = set.iterator();
        	
        	// 연산이 완료된 정수들을 임시로 담아놓을 tmp_set
        	Set<Integer> tmp_set = new HashSet<>();
        	
        	while(iter.hasNext()) {
        		int X = iter.next();
        		
        		// 1이 입력되었을 경우를 위한 예외처리
        		if(X == 1) {
        			depth = 0;
        			break loop1;
        		}
        		
        		// 연산1: X가 3으로 나누어 떨어지면, 3으로 나눈다.
        		if(X % 3 == 0) {
        			if(X/3 == 1) {
        				break loop1;
        			}else {
        				tmp_set.add(X/3);
        			}
        		}
        		
        		// 연산2: X가 2로 나누어 떨어지면, 2로 나눈다.
        		if(X % 2 == 0) {
        			if(X/2 == 1) {
        				break loop1;
        			}else {
        				tmp_set.add(X/2);
        			}
        			
        		}
        		
        		// 연산3: 1을 뺀다.
        		if(X-1 == 1) {
        			break loop1;
        		}else {
        			tmp_set.add(X-1);
        		}  		
        	}
        	
        	// set의 내용을 임시 set의 내용으로 교체
        	// depth 증가
        	set = tmp_set;
    		depth++;
        }
     
        // 최종 결과 출력
        System.out.println(depth);
    }
}