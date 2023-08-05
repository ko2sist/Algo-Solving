import java.util.*;
import java.io.*;

// BJ #11659
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[1] = 1;
        int d = 10007;
        for(int i=2; i<N+1; i++) {
        	arr[i] = (arr[i-1]%d + arr[i-2]%d)%d;
        }
        System.out.println(arr[N]);
	}
}