import java.util.*;
import java.io.*;

// BJ #2420
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();
       
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        System.out.println(Math.abs(N-M));
	}
}