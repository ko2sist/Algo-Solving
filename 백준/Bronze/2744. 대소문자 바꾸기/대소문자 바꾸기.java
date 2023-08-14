import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) <= 90 && s.charAt(i) >= 65) {
				sb.append((char)(s.charAt(i)+32));
			}else {
				sb.append((char)(s.charAt(i)-32));
			}
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
