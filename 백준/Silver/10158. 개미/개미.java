import java.util.*;
import java.io.*;

// BJ #10158 - 개미
// Strategy:
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int x = (p + t % (2*w));
		int y = (q + t % (2*h));
		
		if(x/w == 0) {
			p = x;
		}else if(x/w == 1) {
			p = w-x%w;
		}else {
			p = x%w;
		}
		
		if(y/h == 0) {
			q = y;
		}else if(y/h == 1) {
			q = h-y%h;
		}else {
			q = y%h;
		}
		
		System.out.printf("%d %d",p,q);
	}
}
