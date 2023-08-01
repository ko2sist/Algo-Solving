import java.io.*;
import java.util.*;

// BJ #1003
public class Main {
	public static int[] fibo(int n) {
		if(n==0) {
			return new int[] {1,0};
		}else if(n==1) {
			return new int[] {0,1};
		}else {
			int num0 = 0;
			int num1 = 1;
			for(int i=2; i<n+1; i++) {
				if(i%2 == 0) {
					num0 += num1;
					if(i==n) {
						int tmp = num0;
						num0 = num1;
						num1 = tmp;
					}
				}else {
					num1 += num0;
				}
			}
			return new int[] {num0, num1};
		}
	}
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
       
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	int[] tmp = fibo(Integer.parseInt(br.readLine()));
        	sb.append(tmp[0]).append(" ").append(tmp[1]).append("\n");
        }
        
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}