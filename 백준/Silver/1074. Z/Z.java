import java.io.*;
import java.util.*;

// BJ #1074 - Z
// Strategy: 재귀함수
public class Main {
	// Z: N=1일때가 최소 단위인 재귀함수, Z방향 4분면에 대해 i,j를 변경 후 재귀 실행
	public static int Z(int N, int i, int j) {
		if(N == 1) {             // 기본 단위
			return i*2 + j;
		}else {
			int next_i = i;
			int next_j = j;
			int res = 0;
			int check = (int)Math.pow(2, N-1);
			
			
			if(i >= check) {     // Z방향에 따른 4분면을 계산하고, i,j 변경 후 재귀 실행
				next_i -= check;
				res += check*check*2;
			}
			if(j >= check) {
				next_j -= check;
				res += check*check;
			}
			return res + Z(N-1, next_i, next_j);
		}
	}
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // N,r,c 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        // 최종 결과 출력
        System.out.println(Z(N,r,c));

    }
}