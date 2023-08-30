import java.util.*;
import java.io.*;

// BJ #14890 - 경사로
// Strategy: 구현
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
	
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		
		loop:for(int i=0; i<N; i++) {
			int hr = map[i][0];
			int hc = map[0][i];
			int cntr = 0;
			int cntc = 0;
			int cntr_down = 0;
			int cntc_down = 0;
			boolean down_r = false;
			boolean down_c = false;
			boolean check_r = true;
			boolean check_c = true;
			
			// 가로 체크
			for(int j=0; j<N; j++) {
				if(map[i][j] == hr) {
					if(down_r) {
						cntr_down++;
						if(cntr_down == L) {
							down_r = false;
							cntr = 0;
						}
					}else {
						cntr++;
					}
				}else {
					if(down_r && cntr_down < L) {
						check_r = false;
						break;
					}
					
					if(map[i][j] == hr+1) {
						if(cntr >= L) {
							hr += 1;
							cntr = 1;
						}else {	// 불가능한 행
							check_r = false;
							break;
						}
					}else if(map[i][j] == hr-1) {
						down_r = true;
						cntr_down = 1;
						hr -= 1;
						if(cntr_down == L) {
							down_r = false;
							cntr = 0;
						}
					}else {	//	 불가능한 행
						check_r = false;
						break;
					}
				}
			}
			
			if(down_r && cntr_down < L) {
				check_r = false;
			}
			
			
			
			
			// 세로 체크
			for(int j=0; j<N; j++) {
				if(map[j][i] == hc) {
					if(down_c) {
						cntc_down++;
						if(cntc_down == L) {
							down_c = false;
							cntc = 0;
						}
					}else {
						cntc++;
					}
				}else {
					if(down_c && cntc_down < L) {
						check_c = false;
						break;
					}
					
					if(map[j][i] == hc+1) {
						if(cntc >= L) {
							hc += 1;
							cntc = 1;
						}else {
							check_c = false;
							break;
						}
					}else if(map[j][i] == hc-1){
						down_c = true;
						cntc_down = 1;
						hc -= 1;
						if(cntc_down == L) {
							down_c = false;
							cntc = 0;
						}
					}else {
						check_c = false;
						break;
					}
				}
			}
			
			if(down_c && cntc_down < L) {
				check_c = false;
			}
			
			
			
			
			if(check_r) {
				res++;
			}
			if(check_c) {
				res++;
			}
		}
		
		
		System.out.println(res);
	}
}
