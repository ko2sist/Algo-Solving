import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		if(s.equals("A+")) {
			sb.append("4.3");
		}else if(s.equals("A0")) {
			sb.append("4.0");
		}else if(s.equals("A-")) {
			sb.append("3.7");
		}else if(s.equals("B+")) {
			sb.append("3.3");
		}else if(s.equals("B0")) {
			sb.append("3.0");
		}else if(s.equals("B-")) {
			sb.append("2.7");
		}else if(s.equals("C+")) {
			sb.append("2.3");
		}else if(s.equals("C0")) {
			sb.append("2.0");
		}else if(s.equals("C-")) {
			sb.append("1.7");
		}else if(s.equals("D+")) {
			sb.append("1.3");
		}else if(s.equals("D0")) {
			sb.append("1.0");
		}else if(s.equals("D-")) {
			sb.append("0.7");
		}else if(s.equals("F")) {
			sb.append("0.0");
		}
		// 최종 결과 출력
		System.out.println(sb);
	}
}
