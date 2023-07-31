import java.util.*;
import java.io.*;

// BJ #1620
public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> m1 = new HashMap<>();
        Map<Integer, String> m2 = new HashMap<>();
        for(int i=1; i<N+1; i++) {
        	String tmp = br.readLine();
        	m1.put(tmp, i);
        	m2.put(i, tmp);
        }
        
        for(int i=0; i<M; i++) {
        	String tmp = br.readLine();
        	if(tmp.charAt(0)>=49 && tmp.charAt(0)<58) {
        		int tmp_key = Integer.parseInt(tmp);
        		sb.append(m2.get(tmp_key)).append("\n");
        	}else {
        		sb.append(m1.get(tmp)).append("\n");
        	}
        }
        // 최종 결과 출력
        System.out.println(sb);
    }
}