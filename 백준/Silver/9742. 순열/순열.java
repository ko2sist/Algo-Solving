import java.io.*;
import java.util.*;

// BJ #9742 - 순열
// Strategy: 

public class Main {
	static int N, n, len_set;
	static char[] chars;
	static StringBuilder sb;
	
	
	public static void back(int len, char[] selected, boolean[] visited) {
		if(n > N) return;
		
		if(len == len_set) {
//			System.out.println(Arrays.toString(selected));
			n++;
			if(n == N) {
//				System.out.println(Arrays.toString(selected));
				for(int i=0; i<len_set; i++) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=0; i<len_set; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[len] = chars[i];
				back(len+1, selected, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String s = null;
		while((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			
			String set = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			
			chars = set.toCharArray();
			
			sb.append(set).append(" ").append(N).append(" = ");
		
			n = 0;
			len_set = set.length();
			Arrays.sort(chars);
			
			char[] selected = new char[len_set];
			boolean[] visited = new boolean[len_set];
			
			int fac = 1;
			for(int i=1; i<=len_set; i++) {
				fac *= i;
			}
			
			if(N > fac) {
				sb.append("No permutation").append("\n");
			}else {
				back(0, selected, visited);
			}
		}
		
		
		
		
		// 최종 결과 출력
		System.out.println(sb);
	}
}