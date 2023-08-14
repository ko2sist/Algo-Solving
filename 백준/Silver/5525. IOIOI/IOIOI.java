import java.util.*;
import java.io.*;

// BJ #6064 - 카잉 달력
// Strategy: 
public class Main {
	static int N,M;
	// search(txt, pat): txt에서 pat이 등장한 횟수를 반환 / 보이어-무어 알고리즘을 사용
	public static int search(String txt, String pat) {
		int m = 2*N+1;
		int n = M;
		
		int[] badchar = new int[256];
		for(int i=0; i<256; i++) {
			badchar[i] = -1;
		}
		for(int i=0; i<m; i++) {
			badchar[pat.charAt(i%2)] = i;
		}
		
		int res = 0;
		int s = 0;
		while(s <= (n-m)) {
			int j = m-1;
			while(j >= 0 && pat.charAt(j%2) == txt.charAt(s+j)) {
				j--;
			}
			
			if(j<0) {
				res++;
				s += (s+m < n)? m-badchar[txt.charAt(s+m)] : 1;
			}else {
				s += Math.max(1,  j - badchar[txt.charAt(s+j)]);
			}
		}
		return res;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N,M,S 입력
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		String P = "IO";
		

		
		// 최종 결과 출력
		System.out.println(search(S,P));
	}
}
