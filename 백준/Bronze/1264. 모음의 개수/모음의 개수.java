import java.util.*;
import java.io.*;

// BJ 
// Strategy: 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			String tmp = br.readLine();
			int cnt = 0;
			
			if(tmp.equals("#")) {
				break;
			}
			
			for(int i=0; i<tmp.length(); i++) {
				char c = tmp.charAt(i);
				if(c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
					cnt++;
				}
				if(c == 65 || c == 69 || c == 73 || c == 79 || c == 85) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);

	}
}
