import java.util.*;
import java.io.*;

// BJ #11399
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> times = new PriorityQueue<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	times.add(tmp);
        }
        
        int sum = 0;
        for(int i=N; i>0; i--) {
        	sum += times.poll()*i;
        }
        
        // 최종 결과 출력
        System.out.println(sum);
    }
}