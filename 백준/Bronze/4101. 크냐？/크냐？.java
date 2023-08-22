import java.util.*;
import java.io.*;

// BJ #4101 - 크냐?
// Strategy: 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if(n1 == 0 && n2 == 0) {
				break;
			}
			
			if(n1 > n2) {
				sb.append("Yes").append("\n");
			}else {
				sb.append("No").append("\n");
			}
		}

		System.out.println(sb);

	}
}
