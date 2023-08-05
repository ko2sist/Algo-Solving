import java.util.*;
import java.io.*;

// BJ #9461
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 테이스 케이스의 개수 T
        int T = Integer.parseInt(br.readLine());
        
        // 각 케이스 별 N 입력 및 N의 최대값 저장
        int[] tc = new int[T];
        int max = 0;
        for(int i=0; i<T; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	tc[i] = tmp;
        	if(tmp >= max) {
        		max = tmp;
        	}
        }
        
        // P(N) 구하기 (반복문을 통해 N의 최대값 까지)
        // N이 커지면 int의 범위를 초과하기 때문에 long으로
        long[] P = new long[max+1];
        for(int i=1; i<max+1; i++) {
        	if(i==1 || i==2 || i==3) {
        		P[i] = 1;
        	}else if(i == 4) {
        		P[i] = 2;
        	}else {
        		P[i] = P[i-1] + P[i-5];
        	}
        }
        
        
        // 최종 결과 출력
        for(int i=0; i<T; i++) {
        	sb.append(P[tc[i]]).append("\n");
        }
        System.out.println(sb);  
	}
}