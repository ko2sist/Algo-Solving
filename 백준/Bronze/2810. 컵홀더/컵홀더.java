import java.util.*;
import java.io.*;

// BJ #2810 - 컵 홀더
// Idea: 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 좌석의 수
		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		
		String tmp = "";
		int res = 1;
		for(int i=0; i<N; i++) {
			if(seat.charAt(i) == 'S') {
				res++;
				tmp = "";
			}else {
				if("".equals(tmp)) {
					tmp += 'L';
				}else if("L".equals(tmp)) {
					res++;
					tmp = "";
				}
			}
		}
		if (res>N) {
			res = N;
		}
		// 최종 결과 출력
		System.out.println(res);
	}
}
