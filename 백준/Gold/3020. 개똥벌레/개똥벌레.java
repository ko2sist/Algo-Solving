import java.util.*;
import java.io.*;


// BJ #3020 - 개똥벌레
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		// top : 종유석
		// bot : 석순
		int[] top = new int[H+2];
		int[] bot = new int[H+2];
		
		for(int i=0; i<N/2; i++) {
			bot[Integer.parseInt(br.readLine())]++;
			top[H-Integer.parseInt(br.readLine())+1]++;
		}
		
		// 누적합
		for(int i=1; i<=H; i++) {
			bot[i] = bot[i] + bot[i-1];
		}
		
		for(int i=H; i>=1; i--) {
			top[i] = top[i] + top[i+1];
		}
		
//		System.out.println(Arrays.toString(top));
//		System.out.println(Arrays.toString(bot));
		
		int min = N;
		int cnt = 0;
		for(int i=1; i<=H; i++) {
			int diff = (bot[H] - bot[i-1]) + (top[1]-top[i+1]);
			if(diff < min) {
				min = diff;
				cnt = 1;
			}else if(diff == min) {
				cnt++;
			}
		}
		
		System.out.println(min+" "+cnt);
	}
}
