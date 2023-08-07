import java.util.*;
import java.io.*;

// BJ #14696 - 딱지놀이
// Strategy: Class with Comparable
public class Main {
	// 딱지 개수를 저장하는 Class 
	public static class Scab implements Comparable<Scab>{
		int star;
		int circle;
		int square;
		int triangle;
		
		public Scab() {};
		
		@Override
		public int compareTo(Scab o) {
			if(this.star > o.star) {
				return 1;
			}else if(this.star < o.star) {
				return -1;
			}else {
				if(this.circle > o.circle) {
					return 1;
				}else if(this.circle < o.circle) {
					return -1;
				}else {
					if(this.square > o.square) {
						return 1;
					}else if(this.square < o.square) {
						return -1;
					}else {
						if(this.triangle > o.triangle) {
							return 1;
						}else if(this.triangle < o.triangle) {
							return -1;
						}else {
							return 0;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N: 라운드의 수
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			Scab A = new Scab();
			Scab B = new Scab();
			
			// A의 딱지 개수 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0; j<a; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 4) {
					A.star++;
				}else if(tmp == 3) {
					A.circle++;
				}else if(tmp == 2) {
					A.square++;
				}else {
					A.triangle++;
				}
			}
			
			// B의 딱지 개수 입력
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int j=0; j<b; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 4) {
					B.star++;
				}else if(tmp == 3) {
					B.circle++;
				}else if(tmp == 2) {
					B.square++;
				}else {
					B.triangle++;
				}
			}
			
			// 승부 결과 저장
			if(A.compareTo(B) == 1) {
				sb.append("A").append("\n");
			}else if(A.compareTo(B) == -1) {
				sb.append("B").append("\n");
			}else {
				sb.append("D").append("\n");
			}
		}
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}
