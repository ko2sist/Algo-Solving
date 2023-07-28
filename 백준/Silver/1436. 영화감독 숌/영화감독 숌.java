import java.io.*;
import java.util.*;

// BJ #1436
public class Main {
	public static boolean check(int n) {
		String s = String.valueOf(n);
		int len = s.length();
		int c = 0;
		for(int i=0; i<len; i++) {
			if(s.charAt(i) == '6') {
				c++;
			}else {
				c=0;
			}
			
			if(c==3) {
				return true;
			}
		}
		
		
		return false;
	}
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int tmp = 666;
        int cnt = 0;
        
        while(cnt < N) {
        	if(check(tmp++) == true) {
        		cnt++;
        	}
        }
        System.out.println(tmp-1);
        
    }
}