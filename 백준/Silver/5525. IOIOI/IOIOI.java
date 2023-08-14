import java.util.*;
import java.io.*;

// BJ #5525 - IOIOI
// Strategy: 보이어-무어
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N,M,S 입력
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		// 패턴 생성
		StringBuilder sb_P = new StringBuilder();
		sb_P.append("I");
		for(int i=0; i<N; i++) {
			sb_P.append("OI");
		}
		String P = sb_P.toString();
		
		// 보이어-무어 실행
		int res = 0;
		int idx_P = 0;
		int idx_S = 0;
		int len_P = P.length();
		int len_S = S.length();
		int[] skip = new int[Character.MAX_VALUE+1];
		
		// 건너뛰기 표 생성
		for(int i=0; i<Character.MAX_VALUE+1; i++) {
			skip[i] = len_P;
		}
		for(int i=0; i<len_P-1; i++) {
			skip[P.charAt(i)] = len_P-1-i;
		}
		
		// 개수 계산
		idx_S = len_P - 1;
		while(idx_S < len_S) {
			idx_P = len_P - 1;
			while(P.charAt(idx_P) == S.charAt(idx_S)){
				if(idx_P == 0) {
					res++;
					break;
				}
				idx_P--;
				idx_S--;
			}
			idx_S += Math.max(skip[S.charAt(idx_S)], len_P - idx_P);
		}
		
		// 최종 결과 출력
		System.out.println(res);
	}
}
