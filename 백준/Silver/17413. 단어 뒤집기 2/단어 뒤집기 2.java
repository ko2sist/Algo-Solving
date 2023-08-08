import java.util.*;
import java.io.*;

// BJ #17413 - 단어 뒤집기 2
// Strategy: stack
public class Main {
	public static void store(StringBuilder sb, Stack<Character> s) {
		while(!s.empty()) {
			sb.append(s.pop());
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		String line = br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder bracket = new StringBuilder();
		boolean in_b = false;
		for(int i=0; i<line.length(); i++) {
			char tmp = line.charAt(i);
			if(in_b) {
				if(tmp == '>') {
					bracket.append('>');
					sb.append(bracket);
					in_b = false;
					bracket = new StringBuilder();
				}else {
					bracket.append(tmp);
				}
			}else {
				if(tmp == '<') {
					store(sb, stack);
					in_b = true;
					bracket.append('<');
				}else if(tmp == ' ') {
					store(sb, stack);
					sb.append(' ');
				}else {
					stack.add(tmp);
				}
			}
		}
		store(sb , stack);
		
		System.out.println(sb);
	}
}
