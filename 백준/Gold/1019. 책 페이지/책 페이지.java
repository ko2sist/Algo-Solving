import java.util.*;
import java.io.*;

// BJ #1019 - 책 페이지
// Strategy: 
public class Main {
	public static int[] getNums(int n) {
		int[] res = new int[10];
		
		int len = String.valueOf(n).length();
		int a = 1;
		int nn = n;

		
		for(int i=0; i<len; i++) {
			int r = nn/10;
			int q = nn%10;

			for(int j=0; j<=9; j++) {				
				res[j] += r*a;
			}
			
			res[0] -= a;
			for(int j=0; j<=q; j++) {

				if(j != q) {
					res[j] += a;
				}else {
					res[j] += n%a + 1;
				}

			}

			nn /= 10;
			a *= 10;

		}
		

		return res;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] res = getNums(N);
		
		// 출력 저장
		for(int i=0; i<=9; i++) {
			sb.append(res[i]).append(" ");
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}