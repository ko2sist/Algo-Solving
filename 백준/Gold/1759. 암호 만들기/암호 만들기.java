import java.util.*;
import java.io.*;

// BJ #1759 - 암호 만들기
// Strategy: 백트래킹
public class Main {
	static int L,C;
	static char[] ch;
	static StringBuilder sb;
	
	public static boolean check(int[] selected) {
		boolean c = false;
		int vowels = 0;		// 자음
		int consonants = 0;	// 모음
		
		for(int i=0; i<L; i++) {
			char tmp = ch[selected[i]];
			if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') {
				consonants ++;
			}else {
				vowels++;
			}
			
			if(consonants >= 1 && vowels >= 2) {
				c = true;
				break;
			}
		}
		
		return c;
	}
	public static void back(int len, int[] selected, boolean[] visited) {
		if(len == L) {
			if(check(selected)) {
				for(int i=0; i<L; i++) {
					sb.append(ch[selected[i]]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		if(len == 0) {
			for(int i=0; i<C; i++) {
				selected[len] = i;
				visited[i] = true;
				back(len+1, selected, visited);
				visited[i] = false;
			}
		}else{
			for(int i=selected[len-1]; i<C; i++) {
				if(!visited[i]) {
					selected[len] = i;
					visited[i] = true;
					back(len+1, selected, visited);
					visited[i] = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			ch[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(ch);
		
		int[] selected = new int[L];
		boolean[] visited = new boolean[C];
		back(0, selected, visited);
		
		System.out.println(sb);
	}
}
