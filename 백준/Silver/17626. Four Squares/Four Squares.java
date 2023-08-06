import java.util.*;
import java.io.*;

// BJ #17626
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 계산할 정수 N
        int N = Integer.parseInt(br.readLine());
        
        // 반복문을 통해 계산 (DP 이용)
        // i가 어떤 수의 제곱수라면 arr[i]에 1 저장
        // 제곱수가 아니라면 i에 1~floor(sqrt(i))의 제곱을 빼가면서
        // 이전에 계산된 결과를 참조하여 제곱수의 합의 최소 개수를 구한다.
        int[] arr = new int[N+1];
        for(int i=1; i<N+1; i++) {
        	// i가 제곱수일 경우
        	if(Math.sqrt(i)%1 == 0) {
        		arr[i] = 1;
        	// i가 제곱수가 아닐 경우
        	}else {
        		int min = Integer.MAX_VALUE;
        		// i-j^2의 결과 값 참조 (j: 1~floor(sqrt(i)))
        		for(int j=1; j<(int)Math.sqrt(i)+1; j++) {
        			int tmp = 1 + arr[i-j*j];
        			if(tmp <= min) {
        				min = tmp;
        			}
        		}
        		arr[i] = min;
        	}
        }
        
        // 최종결과 출력
        System.out.println(arr[N]);

	}
}