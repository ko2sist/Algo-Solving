import java.io.*;
import java.util.*;

// BJ #2231
public class Main {
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int gen = 0;
        for(int i=N; i>=1; i--) {
        	int len = String.valueOf(N).length();
        	int copy = i;
        	int check = N-i;
        	for(int j=0; j<len; j++) {
        		int r = copy%10;
        		check -= r;
        		copy = copy/10;
        	}
        	if(check == 0) {
        		gen = i;
        	}
        }
        System.out.println(gen);
        
    }
}