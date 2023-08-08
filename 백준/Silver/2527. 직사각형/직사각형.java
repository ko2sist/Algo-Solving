import java.util.*;
import java.io.*;

// BJ #2527 - 직사각형
// Strategy:  
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x11 = Integer.parseInt(st.nextToken());
			int y11= Integer.parseInt(st.nextToken());
			int x12 = Integer.parseInt(st.nextToken());
			int y12 = Integer.parseInt(st.nextToken());
			
			int x21 = Integer.parseInt(st.nextToken());
			int y21= Integer.parseInt(st.nextToken());
			int x22 = Integer.parseInt(st.nextToken());
			int y22 = Integer.parseInt(st.nextToken());
			
			// check case d
			if(x21 > x12 || x11 > x22 || y11 > y22 || y21 > y12) {
				sb.append("d\n");
			}
			// check case c
			else if( ((x12==x21) || (x11==x22)) && ((y12==y21) || (y11==y22)) ) {
				sb.append("c\n");
			}
			// check case b
			else if( (((x12==x21) || (x11==x22)) && (((y22<=y12) && (y22>=y11)) || ((y21<=y12) && (y21>=y11)) || ((y11<=y22) && (y11>=y21)) || ((y12<=y22) && (y12>=y21)))) ||
					(((y12==y21) || (y11==y22)) && (((x22<=x12) && (x22>=x11)) || ((x21<=x12) && (x21>=x11)) || ((x11<=x22) && (x11>=x21)) || ((x12<=x22) && (x12>=x21))))) {
				sb.append("b\n");
			}
			// case a
			else {
				sb.append("a\n");
			}
			
		}

		// 최종 결과 출력
		System.out.println(sb);

	}
}
