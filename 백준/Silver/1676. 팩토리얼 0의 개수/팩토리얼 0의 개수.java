import java.io.*;
import java.util.*;

// BJ #1676
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if(N < 25) {
			System.out.println(N/5);
		} else if(N < 125) {
			System.out.println(N/5+N/25);
		} else {
			System.out.println(N/5+N/25+N/125);
		}
	}
}