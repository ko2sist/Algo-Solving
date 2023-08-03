import java.util.*;
import java.io.*;

// BJ #10872
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();
       
        int N = Integer.parseInt(br.readLine());
        
        int res =1;
        for(int i=1; i<N+1; i++) {
        	res *= i;
        }
        System.out.println(res);
	}
}