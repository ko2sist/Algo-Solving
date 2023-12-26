import java.io.*;
import java.util.*;

// BJ #9093
// Strategy: 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				StringBuffer buff = new StringBuffer(st.nextToken());
				sb.append(buff.reverse()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}