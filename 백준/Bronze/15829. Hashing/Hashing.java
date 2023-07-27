import java.io.*;
import java.util.*;

// BJ #15829
public class Main {
	public static void main(String[] args) throws Exception{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int L = Integer.parseInt(br.readLine());
        long h = 0;
        String S = br.readLine();
        for(int i=0; i<L; i++) {
        	long tmp = (long)S.charAt(i)-96;
        	h += (tmp*((long)Math.pow(31, i)))%1234567891L;
        }
        
        System.out.println(h);
    }
}